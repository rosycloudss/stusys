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

/**
 * Servlet implementation class StudentCourseServlet
 */
@WebServlet("/teacher_course")
public class TeacherCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag = request.getParameter("flag");
		if ("query".equals(flag)) {
			queryTeacherCourse(request, response);
		}

	}

	/**
	 * 查询教师授课信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void queryTeacherCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherCourseService courseService = new CourseServiceImpl();
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
		//如果TCNo不为null，则只查询一个教师授课信息，否则查询多个教师授课信息
		if (TCNo != null) {
			if (teacherCourseList != null && !teacherCourseList.isEmpty()) {
				TeacherCourse tc = teacherCourseList.get(0);
				request.setAttribute("teacherCourse", tc);
			}
		} else {
			request.setAttribute("teacherCourseList", teacherCourseList);
		}
		if("teacher".equals(role)) {
			
		}else if("student".equals(role)) {
			request.getRequestDispatcher("/student/course-list.jsp").forward(request, response);
		}
		
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
