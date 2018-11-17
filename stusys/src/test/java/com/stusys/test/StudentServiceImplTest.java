package com.stusys.test;


import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.stusys.page.Page;
import com.stusys.stu.bean.Student;
import com.stusys.stu.service.StudentService;
import com.stusys.stu.service.impl.StudentServiceImpl;
import com.stusys.util.DateFormat;
import com.stusys.util.MD5Util;

public class StudentServiceImplTest {
	
	StudentService stuService = null;
	Page page = new Page();
	Student student = new Student();

	@Before
	public void init() {
		stuService = new StudentServiceImpl();
		
		student.setStuNo("20162430212");
		student.setName("李伟");
		student.setPassword(MD5Util.MD5("123456" + "12345"));
		student.setGender("男");
		Date birthday = new Date(1997-1900, 11 - 1, 4 );
		student.setBirthday(birthday.toString());
		student.setIdCard("5130291997100400");
		student.setMajorId(1);
		student.setAddress("四川省达州市大竹县");
		student.setPhone1("17803878845");
		student.setPhone2(null);
		student.setQq("1759840027");
		student.setEmail("1759840027@qq.com");
		student.setEducation("本科");
		Date enterTime = new Date(2016-1900, 9 - 1, 1 );
//		System.out.println(enterTime);
		student.setEnterTime(enterTime.toString());
		student.setState(1);
		student.setPhotoPath("  ");
		student.setSalt("12345");
		student.setCreateTime(System.currentTimeMillis());
		page.setPageStart(0);
		page.setPageCurrent(1);
		page.setPageSize(20);
	}

//	@Test
	public void addTest() {
		System.out.println(stuService.add(student));;
	}	
	public void updateTest() {
		student.setName("liwei");
		System.out.println(stuService.update(student));
	}
	
//	@Test
	public void loginTest() {
		System.out.println(stuService.login("20162430212",MD5Util.MD5("12345612345")));
	}
	@Test
	public void queryTest() {
		Student stu = new Student();
		stu.setName("李伟");
//		System.out.println(student.getBirthday().toString());
		System.out.println(stuService.query(student, page));
		System.out.println(stuService.count(null));
		System.out.println(stuService.query(stu, page));
	}
}
