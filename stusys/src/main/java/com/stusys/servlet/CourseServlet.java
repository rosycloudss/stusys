package com.stusys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stusys.dept.bean.Course;
import com.stusys.dept.service.CourseService;
import com.stusys.dept.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if("add".equals(flag)) {
			addCourse(request, response);
		}
		
		
	}
	/**
	 * 添加课程信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CourseService courseService = new CourseServiceImpl();
		String courseName = request.getParameter("course");
		String courseDescription = request.getParameter("courseDescription");
		String major = request.getParameter("major");
		String credt = request.getParameter("credt");//学分
		String classHour = request.getParameter("classHour");//学时
		String courseType = request.getParameter("courseType");
		int addCount = 0;//添加
		if(courseName != null ) {
			Course course = new Course();
			course.setCourseName(courseName);
			course.setCourseDescription(courseDescription);
			course.getMajor().setMajorNo(Integer.getInteger(major));
			course.setCredt(Float.parseFloat(credt));
			course.setClassHour(Integer.parseInt(classHour));
			course.setCourseType(courseType);
			addCount = courseService.add(course);
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		out.println("<html>");
		out.println("<script>");
		if (addCount > 0) {
			out.println("alert('添加 课程信息成功!');");
		} else {
			out.println("alert('添加课程信息失败!');");
		}
		out.println("window.location.href='" + request.getContextPath() + "/course/add-course.jsp");
		out.println("</script>");
		out.println("</html>");
		
	}
	
	private void queryCourse(HttpServletRequest request, HttpServletResponse response) {
		CourseServiceImpl courseService = new CourseServiceImpl();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
