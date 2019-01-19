package com.stusys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.TeacherCourse;
import com.stusys.service.TeacherCourseService;
import com.stusys.service.impl.CourseServiceImpl;
import com.stusys.servlet.base.BaseServlet;

@WebServlet("/teacher_course")
public class TeacherCourseServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private TeacherCourseService tcs = new CourseServiceImpl();
	private TeacherCourseService courseService = new CourseServiceImpl();


	@Override
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String courseNo = request.getParameter("courseNo");
		String teacherNo = request.getParameter("teacherNo");
		String semester = request.getParameter("semester");
		String teachTime = request.getParameter("teachTime");
		String teachAddress = request.getParameter("teachAddress");
		String studentNum = request.getParameter("studentNum");
		System.out.println(courseNo);
		int addResult = 0;
		System.out.println(semester);
		System.out.println(teacherNo);
		//组装TeacherCourse并添加教师授课信息
		if(courseNo != null && teacherNo != null) {
			TeacherCourse tc = new TeacherCourse();
			tc.getCourse().setCourseNo(Long.parseLong(courseNo));
			tc.setSemester(semester);
			tc.getTeacher().setTeacherNo(teacherNo);
			tc.setStudentNum(Integer.parseInt(studentNum));
			tc.setTeachAddressTime(teachAddress+ " " + teachTime); 
			addResult = tcs.addTC(tc);
		}
		
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("addResult", addResult);
		responseJson(response, jsonResult.toJSONString());
		
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {}

	@Override
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String courseName = request.getParameter("courseName");
		String teacherName = request.getParameter("teacherName");
		String teacherNo = request.getParameter("teacherNo");
		String courseNo = request.getParameter("courseNo");
		String TCNo = request.getParameter("TCNo");
		TeacherCourse teacherCourse = null;
		
		String role = request.getParameter("role");//获取登陆者身份
		teacherCourse = new TeacherCourse();
		if (TCNo != null) {
			teacherCourse.setTcNo(Long.parseLong(TCNo));
		} else {
			if (courseName != null) {
				teacherCourse.getCourse().setCourseName(courseName);
			}
			if (teacherName != null) {
				teacherCourse.getTeacher().setTeacherName(teacherName);
			}
			if (teacherNo != null) {
				teacherCourse.getTeacher().setTeacherNo(teacherNo);
			}
			if (courseNo != null) {
				teacherCourse.getCourse().setCourseNo(Long.parseLong(courseNo));
			}
		}
		List<TeacherCourse> teacherCourseList = courseService.queryTCByParameters(teacherCourse, null);
		request.setAttribute("teacherCourseList", teacherCourseList);
		
		if("teacher".equals(role)) {//如果以教师身份登录
			for(int i = 0;i < teacherCourseList.size();i++) {
				teacherCourseList.get(i).setTeacher(null);
			}
			request.getRequestDispatcher("/teacher/teacher-course.jsp").forward(request, response);
		}else if("student".equals(role)) {
			request.getRequestDispatcher("/student/course-list.jsp").forward(request, response);
		}
	}


}
