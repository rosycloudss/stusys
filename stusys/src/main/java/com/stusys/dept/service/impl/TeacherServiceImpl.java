package com.stusys.dept.service.impl;

import java.util.List;

import com.stusys.dept.bean.Teacher;
import com.stusys.dept.dao.TeacherDao;
import com.stusys.dept.service.TeacherService;
import com.stusys.page.Page;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao = new TeacherDao();

	@Override
	public int addTeacher(Teacher teacher) {
		if(teacher != null) {
			return teacherDao.add(teacher); 
		}
		return 0;
	}

	@Override
	public int deleteTeacher(String teacherNo) {
		if(teacherNo != null) {
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

	@Override
	public List<Teacher> queryTeacher(Teacher teacher, Page page) {
		return teacherDao.select(teacher, page);
	}
	
}
