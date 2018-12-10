package com.stusys.dept.service;

import java.util.List;

import com.stusys.dept.bean.Teacher;
import com.stusys.page.Page;

public interface TeacherService {

	int addTeacher(Teacher teacher);

	int deleteTeacher(String teacherNo);

	int updateTeacher(Teacher teacher);

	int countTeacher(Teacher teacher);
	
	Teacher queryTeacher(String teacherNo,String password);

	List<Teacher> queryTeacher(Teacher teacher, Page page);

	Teacher queryTeacherByNo(String teacherNo);
	
}
