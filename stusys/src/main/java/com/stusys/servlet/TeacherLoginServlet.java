package com.stusys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stusys.dept.bean.Teacher;
import com.stusys.dept.service.TeacherService;
import com.stusys.dept.service.impl.TeacherServiceImpl;
import com.stusys.util.MD5Util;

/**
 * Servlet implementation class TeacherLoginServlet
 */
@WebServlet("/teacher/login")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherService ts = new TeacherServiceImpl();
		String teacherNo = request.getParameter("teacherNo");
		String password = request.getParameter("password");
		Teacher teacher = null;
		if (teacherNo != null && password != null) {
			teacher = ts.queryTeacher(teacherNo, MD5Util.MD5(password)); // 通过教师编号和使用md5加密过的密码查找教师信息
		}
		if (teacher != null) {// 登录成功则跳转到教师首页
			request.getSession().setAttribute("teacher", teacher);
			request.getRequestDispatcher("/teacher/index.jsp").forward(request, response);
		} else { // 登录失败则跳转到教师登录界面
			request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
