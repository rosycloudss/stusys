package com.stusys.stu.service;

import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.StudentCourse;

public interface StudentCourseService {
	
	int addStudentCourse(StudentCourse sc);
	
	int delStudentCourse(long scNo);
	
	int updateStudentCourse(StudentCourse sc);
	
	List<StudentCourse> queryStudentCourse(StudentCourse sc,Page page);
	
	List<StudentCourse> queryStudentCourse(String stuNo,Page page);
}
