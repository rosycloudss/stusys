package com.stusys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stusys.bean.Student;
import com.stusys.service.StudentService;
import com.stusys.service.impl.StudentServiceImpl;

/**
 * 
 * @author LIWEI
 * @time 2019年1月19日上午9:07:07
 * @description:学生登录
 */
@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentServiceImpl();
	PrintWriter out = null;


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out = response.getWriter();
		
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
			
			// 返回添加结果
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			out.println("<html>");
			out.println("<script>");
			
			out.println("alert('账号或密码错误!');");
			out.println("window.location.href='" + request.getContextPath() + "/login.jsp'");
			out.println("</script>");
			out.println("</html>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
