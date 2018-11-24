package com.stusys.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stusys.stu.bean.Student;

/**
 * 判断学生是否登录
 * 
 * @author liwei
 *
 */
@WebFilter(urlPatterns = { "/student/index.jsp", "/student/scrore-table.jsp", "/student/student-info.jsp" })
public class StudentLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
//		System.out.println(request.getRequestURL());
		if (request.getRequestURL().toString().contains("student")
				&& !request.getRequestURL().toString().contains("login.jsp")) {
			Student student = (Student) session.getAttribute("student");
			if (student == null) {
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<script>");
				out.println("alert('您还未登录!');");
				out.println("window.location.href='" + request.getContextPath() + "/student/login.jsp'");
				out.println("</script>");
				out.println("</html>");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

}
