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
		System.out.println(flag);
		if ("query".equals(flag)) {
			queryTeacherCourse(request, response);
		}else if("add".equals(flag)) {
			addTeacherCourse(request, response);
		}

	}
	/**
	 * 添加教师授课信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void addTeacherCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TeacherCourseService tcs = new CourseServiceImpl();
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
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonResult); // 利用json返回删除结果
		out.flush();
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
