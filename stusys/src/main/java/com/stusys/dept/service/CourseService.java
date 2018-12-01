package com.stusys.dept.service;

import java.util.List;

import com.stusys.dept.bean.Course;
import com.stusys.page.Page;

public interface CourseService {

	int add(Course course);

	int delete(long courseNo);

	int update(Course course);

	Course queryByCourseNo(long courseNo);

	List<Course> queryByCourseName(String courseName,Page page);


	List<Course> queryByParamenters(Course course, Page page);

}
