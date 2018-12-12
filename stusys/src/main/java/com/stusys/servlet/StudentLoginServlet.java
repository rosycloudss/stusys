package com.stusys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stusys.stu.bean.Student;
import com.stusys.stu.service.StudentService;
import com.stusys.stu.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/student/loginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService studentService;

	/**
	 * Default constructor.
	 */
	public StudentLoginServlet() {
		// TODO Auto-generated constructor stub
		studentService = new StudentServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNo = request.getParameter("stuNo");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		ServletContext servletContext = request.getServletContext();

		Student stu = null;
		if (stuNo != null && password != null) {
			stu = studentService.login(stuNo, password);
		}
		// 登录成功后将登录的学生信息添加到session和servletContext中
		if (stu != null) {
			session.setAttribute("student", stu);
			List<Student> loginStudentList = (ArrayList<Student>) servletContext.getAttribute("onlineStudentList");
			if (loginStudentList == null) {
				loginStudentList = new ArrayList<Student>();
				session.setAttribute("role", "学生");
				servletContext.setAttribute("onlineStudentList", loginStudentList);
			}
			loginStudentList.add(stu);
			response.sendRedirect(request.getContextPath() + "/student/index.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
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
