package com.stusys.service.impl;

import java.util.List;

import com.stusys.bean.StudentCourse;
import com.stusys.bean.TeacherCourse;
import com.stusys.dao.StudentCourseDao;
import com.stusys.page.Page;
import com.stusys.service.StudentCourseService;
import com.stusys.service.TeacherCourseService;

public class StudentCourseServiceImpl implements StudentCourseService {

	StudentCourseDao scDao = new StudentCourseDao();
	TeacherCourseService teacherCourseService = new CourseServiceImpl();

	/**
	 * 添加学生选课信息，同时将教师授课中的已选学生数量增加
	 */
	@Override
	public int addStudentCourse(StudentCourse sc) {
		if (sc != null) {
			TeacherCourse tc = teacherCourseService.queryTCByTCNo(sc.getTc().getTcNo());
			System.out.println(tc);
			tc.setSelectNum(tc.getSelectNum() + 1);
			if (tc.getSelectNum() < tc.getStudentNum() && teacherCourseService.updateTC(tc) > 0) {
				return scDao.add(sc);
			}
		}
		return 0;
	}

	/**
	 * 删除学生选课信息，同时在老师授课表中的选课学生数减一
	 */
	@Override
	public int delStudentCourse(long scNo) {
		StudentCourse sc = queryStudentCourse(scNo);
		System.out.println(sc);
		if (sc != null) {
			int delete = scDao.delete(scNo);
			TeacherCourse tc = teacherCourseService.queryTCByTCNo(sc.getTc().getTcNo());
			tc.setSelectNum(tc.getSelectNum() - 1);
			if (tc.getSelectNum() >= 0) {
				teacherCourseService.updateTC(tc);
			}
			return delete;
		}
		return 0;
	}

	@Override
	public int updateStudentCourse(StudentCourse sc) {
		return scDao.update(sc);
	}

	@Override
	public List<StudentCourse> queryStudentCourse(StudentCourse sc, Page page) {
		List<StudentCourse> scList = scDao.select(sc, page);
		if (scList != null && !scList.isEmpty()) {
			for (int i = 0; i < scList.size(); i++) {
				StudentCourse stuCourse = scList.get(i);
				if (stuCourse.getTc() != null) {
					stuCourse.setTc(teacherCourseService.queryTCByTCNo(stuCourse.getTc().getTcNo()));
				}
			}
		}
		return scList;
	}

	@Override
	public List<StudentCourse> queryStudentCourse(String stuNo, Page page) {
		StudentCourse sc = new StudentCourse();
		sc.setStuNo(stuNo);
		return queryStudentCourse(sc, page);
	}

	@Override
	public StudentCourse queryStudentCourse(long scNo) {
		StudentCourse sc = new StudentCourse();
		sc.setScNo(scNo);
		List<StudentCourse> scList = queryStudentCourse(sc, null);
		if (scList != null && !scList.isEmpty()) {
			return scList.get(0);
		}
		return null;
	}

}
