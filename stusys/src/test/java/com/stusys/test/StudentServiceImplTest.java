package com.stusys.test;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.stusys.bean.Major;
import com.stusys.bean.Student;
import com.stusys.dao.StudentDao;
import com.stusys.page.Page;
import com.stusys.service.StudentService;
import com.stusys.service.impl.StudentServiceImpl;
import com.stusys.util.MD5Util;

public class StudentServiceImplTest {

	StudentService stuService = null;
	Page page = new Page();
	Student student = new Student();

	@Before
	public void init() {
		stuService = new StudentServiceImpl();

		student.setStuNo("2016243");
		student.setName("李伟");
		student.setPassword(MD5Util.MD5("123456"));
		student.setGender("男");
		Date birthday = new Date(1997 - 1900, 11 - 1, 4);
		student.setIdCard("5130291997100400");
		Major major = new Major();
		major.setMajorNo(241);
		student.setMajor(major);
		student.setAddress("四川省达州市大竹县");
		student.setPhone1("17803878845");
		student.setPhone2(null);
		student.setQq("1759840027");
		student.setEmail("1759840027@qq.com");
		student.setEducation("本科");
		student.setGrade("2017");
		Date enterTime = new Date(2016 - 1900, 9 - 1, 1);
		student.setEnterTime(enterTime.toString());
		student.setState(1);
		student.setPhotoPath("");
		student.setCreateTime(System.currentTimeMillis());
	}

	@Test
	public void addTest() {
		Student stu = new Student();
		Major major = new Major();
		major.setMajorNo(241);
		for (int i = 0; i < 100; i++) {
			int stuCount = stuService.count(stu);
			stuCount++;
			String stuNo = student.getGrade() + student.getMajor().getMajorNo();
			if (stuCount < 9) {
				stuNo += "00" + stuCount;
			} else if (stuCount < 99) {
				stuNo += "0" + stuCount;
			} else {
				stuNo += stuCount;
			}
			student.setStuNo(stuNo);
			System.out.println(stuService.add(student));;
		}
	}

//	@Test
	public void updateTest() {
		student.setName("liwei");
		System.out.println(stuService.update(student));
//		System.out.println(stuService.delete("20162430212"));
	}

//	@Test
	public void loginTest() {
		System.out.println(stuService.login("20162430212", "123456"));
	}

//
//	@Test
	public void queryTest() {
		Student stu = new Student();
		stu.setName("李伟");
//		System.out.println(student.getBirthday().toString());
//		System.out.println(stuService.query(student, page));
//		System.out.println(stuService.count(null));
//		System.out.println(stuService.query((Student) null, page));
		StudentDao stuDao = new StudentDao();
		System.out.println(stuDao.select(null, page));

//		System.out.println(student.getGrade());
	}

//	@Test
	public void deleteTest() {
//		System.out.println(stuService.delete("20162430214"));
		Page page = new Page(stuService.count(null), 2, 10);
		System.out.println(page);
		System.out.println(stuService.query((Student) null, page));
	}

}
