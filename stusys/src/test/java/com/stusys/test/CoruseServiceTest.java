package com.stusys.test;

import org.junit.Test;

import com.stusys.bean.Course;
import com.stusys.service.impl.CourseServiceImpl;

public class CoruseServiceTest {

	@Test
	public void test() {
		

		Course course = new Course();

		course.setCourseNo(241);
		CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
		
		System.out.println(courseServiceImpl.queryTCByParameters(null, null));

//		System.out.println(courseService.queryByCourseNo(241));
//		System.out.println(courseService.queryByParamenters(null, null));
//		for (int i = 1; i <2; i++) {
//			new Thread(new Runnable() {
//
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName());
//					CourseServiceImpl courseService = new CourseServiceImpl();
//					// TODO Auto-generated method stub
//					System.out.println(Thread.currentThread().getName() +  courseService.queryTCByParameters(null, null));
//
//				}
//			},"thread-" + i).start();
//			;
//		}

//		System.out.println();

//		course.setClassHour(32);
//		course.setCourseDescription("........");
//		course.setCourseName("操作系统");
//		course.setCourseType("工科");
//		course.getMajor().setMajorNo(24);
//		System.out.println(courseService.add(course));
	}

}
