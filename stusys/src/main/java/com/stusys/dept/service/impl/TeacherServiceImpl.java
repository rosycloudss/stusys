package com.stusys.dept.service.impl;

import java.util.List;

import com.stusys.dept.bean.Department;
import com.stusys.dept.bean.Teacher;
import com.stusys.dept.dao.DepartmentDao;
import com.stusys.dept.dao.TeacherDao;
import com.stusys.dept.service.TeacherService;
import com.stusys.page.Page;

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
		if (teacherNo != null) {
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

}
