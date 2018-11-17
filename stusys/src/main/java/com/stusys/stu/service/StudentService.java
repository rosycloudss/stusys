package com.stusys.stu.service;

import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.Student;

public interface StudentService {
	
	int add(Student stu);
	
	int add(List<Student> stuList);
	
	int delete(String stuNo);
	
	int update(Student stu);
	
	Student login(String stuNo,String password);
	
	List<Student> query(Student stu, Page page);
	
	int count(Student stu);

}
