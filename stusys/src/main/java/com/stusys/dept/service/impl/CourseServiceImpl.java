package com.stusys.dept.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.stusys.dept.bean.Course;
import com.stusys.dept.bean.TeacherCourse;
import com.stusys.dept.dao.CourseDao;
import com.stusys.dept.dao.TeacherCourseDao;
import com.stusys.dept.service.CourseService;
import com.stusys.dept.service.TeacherCourseService;
import com.stusys.dept.service.TeacherService;
import com.stusys.page.Page;

/**
 * 
 * @author LIWEI
 * @time 2018年11月29日上午12:17:32
 * @description: 课程信息服务类
 */
public class CourseServiceImpl implements CourseService, TeacherCourseService {

	private CourseDao courseDao = new CourseDao();

	private TeacherCourseDao teacherCourseDao = new TeacherCourseDao();
	
	private TeacherService teacherService = new TeacherServiceImpl();

	/**
	 * 添加课程信息
	 */
	@Override
	public int add(Course course) {
		if (course != null) {
			return courseDao.add(course);
		}
		return 0;
	}

	/**
	 * 删除课程信息
	 */
	@Override
	public int delete(long courseNo) {
		return courseDao.delete(courseNo);
	}

	/**
	 * 修改课程信息
	 */
	@Override
	public int update(Course course) {
		if (course != null) {
			return courseDao.update(course);
		}
		return 0;
	}

	/**
	 * 通过课程编号查找课程信息
	 */
	@Override
	public Course queryByCourseNo(long courseNo) {
		Course course = new Course();
		course.setCourseNo(courseNo);
		List<Course> courseList = queryByParamenters(course, null);
		if (courseList != null && !courseList.isEmpty()) {
			return courseList.get(0);
		}
		return null;
	}

	/**
	 * 通过课程名称查找课程信息
	 */
	@Override
	public List<Course> queryByCourseName(String courseName, Page page) {
		List<Course> courseList = new ArrayList<Course>();
		if (courseName != null) {
			Course course = new Course();
			course.setCourseName(courseName);
			courseList = queryByParamenters(course, page);
		}
		return courseList;
	}

	/**
	 * 通过课程属性查找课程信息
	 */
	@Override
	public List<Course> queryByParamenters(Course course, Page page) {
		return courseDao.select(course, page);
	}

	/**
	 * 添加教师授课信息
	 */
	@Override
	public int addTC(TeacherCourse teaCourse) {
		if (teaCourse != null && teaCourse.getCourse() != null && teaCourse.getTeacher() != null) {
			return teacherCourseDao.add(teaCourse);
		}
		return 0;
	}

	/**
	 * 删除教师授课信息
	 */
	@Override
	public int deleteTC(long teaCourseNo) {
		return teacherCourseDao.delete(teaCourseNo, null, null);
	}

	@Override
	public int updateTC(TeacherCourse teaCourse) {
		if (teaCourse != null && teaCourse.getTeacher() != null && teaCourse.getCourse() != null) {
			return teacherCourseDao.update(teaCourse);
		}
		return 0;
	}

	/**
	 * 教师授课信息
	 */
	@Override
	public List<TeacherCourse> queryTCByParameters(TeacherCourse teaCourse, Page page) {
		List<TeacherCourse> teacherCourseList = teacherCourseDao.select(teaCourse, page);
		queryCourseAndTeacherByTC(teacherCourseList);
		return teacherCourseList;
	}

	/**
	 * 通过教师编号查找教师授课信息
	 */
	@Override
	public List<TeacherCourse> queryTCByTeacherInfo(String teacherNo, String teacherName, Page page) {
		List<TeacherCourse> teacherCourseList = new ArrayList<TeacherCourse>();
		if (teacherName != null || teacherNo != null) {
			TeacherCourse teacherCourse = new TeacherCourse();
			if (teacherNo != null) {
				teacherCourse.getTeacher().setTeacherNo(teacherNo);
			}
			if (teacherName != null) {
				teacherCourse.getTeacher().setTeacherName(teacherName);
			}
			teacherCourseList = teacherCourseDao.select(teacherCourse, page);
		}
		return teacherCourseList;
	}

	/**
	 * 通过课程名称查找教师授课信息
	 */
	@Override
	public List<TeacherCourse> queryTCByCourseInfo(String courseName, Long courseNo, Page page) {
		List<TeacherCourse> teacherCourseList = new ArrayList<TeacherCourse>();
		if (courseName != null || courseNo != null) {
			TeacherCourse teacherCourse = new TeacherCourse();
			if (courseName != null) {
				teacherCourse.getCourse().setCourseName(courseName);
			}
			if (courseNo != null) {
				teacherCourse.getCourse().setCourseNo(courseNo);
			}
			teacherCourseList = teacherCourseDao.select(teacherCourse, page);
		}
		return teacherCourseList;
	}

	@Override
	public int countTC(TeacherCourse teacherCourse) {
		return teacherCourseDao.count(teacherCourse);
	}
	
	private List<TeacherCourse> queryCourseAndTeacherByTC(List<TeacherCourse> teacherCourseList){
		if(teacherCourseList != null && !teacherCourseList.isEmpty()) {
			for(TeacherCourse teacherCourse : teacherCourseList) {
				teacherCourse.setCourse(queryByCourseNo(teacherCourse.getCourse().getCourseNo()));
				teacherCourse.setTeacher(teacherService.queryTeacherByNo(teacherCourse.getTeacher().getTeacherNo()));
			}
		}
		return teacherCourseList;
		
	}

	@Override
	public TeacherCourse queryTCByTCNo(long tcNo) {
		TeacherCourse tc = new TeacherCourse();
		tc.setTcNo(tcNo);
		List<TeacherCourse> tcList = queryTCByParameters(tc, null);
		if(tcList != null && !tcList.isEmpty()) {
			return tcList.get(0);
		}
		return null;
	}

}
