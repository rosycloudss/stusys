package com.stusys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stusys.bean.Course;
import com.stusys.bean.Major;
import com.stusys.bean.Teacher;
import com.stusys.bean.TeacherCourse;
import com.stusys.dao.CourseDao;
import com.stusys.dao.TeacherCourseDao;
import com.stusys.page.Page;
import com.stusys.service.CourseService;
import com.stusys.service.MajorService;
import com.stusys.service.TeacherCourseService;
import com.stusys.service.TeacherService;

/**
 * 
 * @author LIWEI
 * @time 2018年11月29日上午12:17:32
 * @description: 课程信息服务类
 */
public class CourseServiceImpl implements CourseService, TeacherCourseService {

	private CourseDao courseDao = new CourseDao();

	private TeacherCourseDao teacherCourseDao = new TeacherCourseDao();

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
		if (deleteTC(null, null, courseNo) >= 0) {
			return courseDao.delete(courseNo);
		} else {
			return 0;
		}
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
		MajorService majorService = new DepartmentAndMajorServiceImpl();
		List<Course> courseList = courseDao.select(course, page);
		if (courseList != null && !courseList.isEmpty()) {
			Map<Integer, Major> majorMap = new HashMap<Integer, Major>();// 缓存Major信息
			for (int i = 0; i < courseList.size(); i++) {
				Course cou = courseList.get(i);
				if (cou.getMajor() != null && cou.getMajor().getMajorNo() != 0) {
					int majorNo = cou.getMajor().getMajorNo();
					if (majorMap.get(majorNo) != null) {// 如果majorMap含有当前Major信息，则设置为课程的专业信息
						cou.setMajor(majorMap.get(majorNo));
					} else {// 否则从数据库中查询专业信息
						Major major = majorService.queryMajorByNo(majorNo);
						majorMap.put(majorNo, major);
						cou.setMajor(major);
					}
				}
			}
		}
		return courseList;
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
	public int deleteTC(Long teaCourseNo, String teacherNo, Long courseNo) {
		return teacherCourseDao.delete(teaCourseNo, teacherNo, courseNo);
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
		TeacherService teacherService = new TeacherServiceImpl();
		List<TeacherCourse> teacherCourseList = teacherCourseDao.select(teaCourse, page);
		if (teacherCourseList != null && !teacherCourseList.isEmpty()) {
			Map<Long, Course> courseMap = new HashMap<Long, Course>();// 缓存课程信息
			Map<String, Teacher> teacherMap = new HashMap<String, Teacher>();// 缓存教师信息
			for (TeacherCourse teacherCourse : teacherCourseList) {
				// 设置TeacherCourse中的课程信息
				if (teacherCourse.getCourse() != null && teacherCourse.getCourse().getCourseNo() != 0) {
					long courseNo = teacherCourse.getCourse().getCourseNo();
					if (courseMap.get(courseNo) == null) {
						Course course = queryByCourseNo(courseNo);
						courseMap.put(courseNo, course);
					}
					teacherCourse.setCourse(courseMap.get(courseNo));
				}
				// 设置TeacherCourse中的老师信息
				if (teacherCourse.getTeacher() != null && teacherCourse.getTeacher().getTeacherNo() != null) {
					String teacherNo = teacherCourse.getTeacher().getTeacherNo();
					if (teacherMap.get(teacherNo) == null) {
						Teacher teacher = teacherService.queryTeacherByNo(teacherCourse.getTeacher().getTeacherNo());
						teacherMap.put(teacherNo, teacher);
					}
					teacherCourse.setTeacher(teacherMap.get(teacherNo));
				}
				teacherCourse.setTeacher(teacherService.queryTeacherByNo(teacherCourse.getTeacher().getTeacherNo()));
			}
		}
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
			teacherCourseList = queryTCByParameters(teacherCourse, page);
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
			teacherCourseList = queryTCByParameters(teacherCourse, page);
		}

		return teacherCourseList;
	}

	@Override
	public int countTC(TeacherCourse teacherCourse) {
		return teacherCourseDao.count(teacherCourse);
	}

	@Override
	public TeacherCourse queryTCByTCNo(long tcNo) {
		TeacherCourse tc = new TeacherCourse();
		tc.setTcNo(tcNo);
		List<TeacherCourse> tcList = queryTCByParameters(tc, null);
		if (tcList != null && !tcList.isEmpty()) {
			return tcList.get(0);
		}
		return null;
	}

}
