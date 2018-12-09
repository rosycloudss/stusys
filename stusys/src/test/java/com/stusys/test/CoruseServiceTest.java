package com.stusys.test;

import org.junit.Test;

import com.stusys.dept.bean.Course;
import com.stusys.dept.service.impl.CourseServiceImpl;

public class CoruseServiceTest {

	@Test
	public void test() {
		CourseServiceImpl courseService = new CourseServiceImpl();
		

		Course course = new Course();

		course.setCourseNo(241);

//		System.out.println(courseService.queryByCourseNo(241));
//		System.out.println(courseService.queryByParamenters(null, null));
//		System.out.println(courseService.queryTCByParameters(null, null));
		
//		System.out.println();
		
		
		course.setClassHour(32);
		course.setCourseDescription("........");
		course.setCourseName("操作系统");
		course.setCourseType("工科");
		course.getMajor().setMajorNo(24);
		System.out.println(courseService.add(course));
	}

}
