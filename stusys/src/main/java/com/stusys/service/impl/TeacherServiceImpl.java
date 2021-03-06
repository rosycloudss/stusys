package com.stusys.service.impl;

import java.util.List;

import com.stusys.bean.Department;
import com.stusys.bean.Teacher;
import com.stusys.dao.DepartmentDao;
import com.stusys.dao.TeacherDao;
import com.stusys.page.Page;
import com.stusys.service.TeacherCourseService;
import com.stusys.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao = new TeacherDao();
	private DepartmentDao deptDao = new DepartmentDao();
	
	
	@Override
	public int addTeacher(Teacher teacher) {
		if (teacher != null) {
			return teacherDao.add(teacher);
		}
		return 0;
	}

	@Override
	public int deleteTeacher(String teacherNo) {
		TeacherCourseService teacherCourseService = new CourseServiceImpl();
		if (teacherNo != null && teacherCourseService.deleteTC(null, teacherNo, null) > 0) {
			return teacherDao.delete(teacherNo);
		}
		return 0;
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		return teacherDao.update(teacher);
	}

	@Override
	public int countTeacher(Teacher teacher) {
		return teacherDao.count(teacher);
	}

	/**
	 * 通过教师属性查找教师信息，Page表示当前页面信息
	 */
	@Override
	public List<Teacher> queryTeacher(Teacher teacher, Page page) {
		List<Teacher> teacherList = teacherDao.select(teacher, page);
		if(teacherList != null && !teacherList.isEmpty()) {
			for(Teacher tea : teacherList) {
				if(tea.getDepat() != null) {
					List<Department> deptList = deptDao.select(tea.getDepat(), null);
					if(deptList != null && !deptList.isEmpty()) {
						tea.setDepat(deptList.get(0));
					}
				}
			}
		}
		
		return teacherList;
	}

	/**
	 * 通过教师编号查找教师信息
	 */
	@Override
	public Teacher queryTeacherByNo(String teacherNo) {
		if (teacherNo != null) {
			Teacher teacher = new Teacher();
			teacher.setTeacherNo(teacherNo);
			List<Teacher> teacherList = queryTeacher(teacher, null);
			if(teacherList != null && !teacherList.isEmpty()) {
				return teacherList.get(0);
			}
		}
		return null;
	}
	
	/**
	 * 通过教师编号和密码查找教师信息，如何查不到则返回null
	 */
	@Override
	public Teacher queryTeacher(String teacherNo, String password) {
		if(teacherNo != null && password != null) {
			Teacher teacher = new Teacher();
			teacher.setTeacherNo(teacherNo);
			teacher.setPassword(password);
			List<Teacher> teacherList = queryTeacher(teacher, null);
			if(teacherList != null && !teacherList.isEmpty()) {
				return teacherList.get(0);
			}
		}
		return null;
	}

}
