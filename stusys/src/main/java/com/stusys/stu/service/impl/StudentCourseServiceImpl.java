package com.stusys.stu.service.impl;

import java.util.List;

import com.stusys.dept.service.TeacherCourseService;
import com.stusys.dept.service.impl.CourseServiceImpl;
import com.stusys.page.Page;
import com.stusys.stu.bean.StudentCourse;
import com.stusys.stu.dao.ScoreDao;
import com.stusys.stu.dao.StudentCourseDao;
import com.stusys.stu.service.StudentCourseService;

public class StudentCourseServiceImpl implements StudentCourseService{

	StudentCourseDao scDao = new StudentCourseDao();
	ScoreDao scoreDao = new ScoreDao();
	TeacherCourseService teacherCourseService = new CourseServiceImpl();
	
	@Override
	public int addStudentCourse(StudentCourse sc) {
		if(sc != null) {
			return scDao.add(sc);
		}
		return 0;
	}

	@Override
	public int delStudentCourse(long scNo) {
		return scDao.delete(scNo);
	}

	@Override
	public int updateStudentCourse(StudentCourse sc) {
		return 0;
	}

	@Override
	public List<StudentCourse> queryStudentCourse(StudentCourse sc, Page page) {
		List<StudentCourse> scList = scDao.select(sc, page);
		if(scList != null && !scList.isEmpty()) {
			for(StudentCourse stuCourse : scList) {
				if(stuCourse.getScore() != null) {
					stuCourse.setScore(scoreDao.select(stuCourse.getScore().getScoreNo()));
				}
				if(stuCourse.getTc() != null) {
					stuCourse.setTc(teacherCourseService.queryTCByTCNo(stuCourse.getTc().getTcNo()));
				}
			}
		}
		return scDao.select(sc, page);
	}

	@Override
	public List<StudentCourse> queryStudentCourse(String stuNo, Page page) {
		StudentCourse sc = new StudentCourse();
		sc.setStuNo(stuNo);
		return queryStudentCourse(sc, page);
	}


}
