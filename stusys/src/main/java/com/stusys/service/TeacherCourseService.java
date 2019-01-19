package com.stusys.service;

import java.util.List;

import com.stusys.bean.TeacherCourse;
import com.stusys.page.Page;

public interface TeacherCourseService {

	
	public int addTC(TeacherCourse teaCourse);
	
	public int deleteTC(Long teaCourseNo,String teacherNo, Long courseNo);
	
	public int updateTC(TeacherCourse teaCourse);
	
	public List<TeacherCourse> queryTCByParameters(TeacherCourse teaCourse,Page page);
	
	public List<TeacherCourse> queryTCByTeacherInfo(String teacherNo,String teacherName,Page page);
	
	public List<TeacherCourse> queryTCByCourseInfo(String courseName,Long courseNo, Page page);
	
	public TeacherCourse queryTCByTCNo(long tcNo);
	
	public int countTC(TeacherCourse teacherCourse);
	
}
