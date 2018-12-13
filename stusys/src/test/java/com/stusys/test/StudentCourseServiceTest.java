package com.stusys.test;

import java.util.List;

import org.junit.Test;

import com.stusys.bean.StudentCourse;
import com.stusys.service.StudentCourseService;
import com.stusys.service.impl.StudentCourseServiceImpl;

public class StudentCourseServiceTest {
	
	
	@Test
	public void test() {
		StudentCourseService scs = new StudentCourseServiceImpl();
		List<StudentCourse> scList = scs.queryStudentCourse((StudentCourse) null, null);
//		System.out.println(scList.get(0).getTc());
		System.out.println();
	}

}
