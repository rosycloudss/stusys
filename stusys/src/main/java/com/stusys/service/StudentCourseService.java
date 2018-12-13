package com.stusys.service;

import java.util.List;

import com.stusys.bean.StudentCourse;
import com.stusys.page.Page;

public interface StudentCourseService {
	
	int addStudentCourse(StudentCourse sc);
	
	int delStudentCourse(long scNo);
	
	int updateStudentCourse(StudentCourse sc);
	
	List<StudentCourse> queryStudentCourse(StudentCourse sc,Page page);
	
	List<StudentCourse> queryStudentCourse(String stuNo,Page page);
	
	StudentCourse queryStudentCourse(long scNo);
	
}
