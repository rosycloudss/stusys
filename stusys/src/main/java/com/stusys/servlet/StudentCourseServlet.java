package com.stusys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stusys.dept.bean.TeacherCourse;
import com.stusys.dept.service.TeacherCourseService;
import com.stusys.dept.service.impl.CourseServiceImpl;
import com.stusys.page.Page;

/**
 * Servlet implementation class StudentCourseServlet
 */
@WebServlet("/student/course/list")
public class StudentCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherCourseService courseService = new CourseServiceImpl();
		String courseName = request.getParameter("courseName");
		String teacherName = request.getParameter("teacherName");
		TeacherCourse teacherCourse = null;
		if (courseName != null || teacherName != null) {
			teacherCourse = new TeacherCourse();
			if (courseName != null) {
				teacherCourse.getCourse().setCourseName(courseName);
			}
			if (teacherName != null) {
				teacherCourse.getTeacher().setTeacherName(teacherName);
			}
		}
		List<TeacherCourse> teacherCourseList = courseService.queryTCByParameters(teacherCourse, null);
		request.setAttribute("teacherCourseList", teacherCourseList);
		System.out.println(teacherCourseList);
		request.getRequestDispatcher("/student/course-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
