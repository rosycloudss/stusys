package com.stusys.service;

import java.util.List;

import com.stusys.bean.Student;
import com.stusys.page.Page;

public interface StudentService {
	
	int add(Student stu);
	
	int add(List<Student> stuList);
	
	int delete(String stuNo);
	
	int update(Student stu);
	
	Student login(String stuNo,String password);
	
	List<Student> query(Student stu, Page page);
	
	Student query(String stuNo);
	
	List<Student> query(int majorNo, Page page);
	
	List<Student> query(String stuName, Page page);
	
	int count(Student stu);

}
