package com.stusys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if ("add".equals(flag)) {
			addCourse(request, response);
		} else if ("query".equals(flag)) {
			queryCourse(request, response);
		} else if ("delete".equals(flag)) {
			deleteCourse(request, response);
		}
	}

	/**
	 * 添加课程信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CourseService courseService = new CourseServiceImpl();
		String courseName = request.getParameter("courseName");
		String courseDescription = request.getParameter("courseDescription");
		String major = request.getParameter("major");
		String credt = request.getParameter("credt");// 学分
		String classHour = request.getParameter("classHour");// 学时
		String courseType = request.getParameter("courseType");
		int addCount = 0;// 添加
		System.out.println(major);
		if (courseName != null) {
			Course course = new Course();
			course.setCourseName(courseName);
			course.setCourseDescription(courseDescription);
			course.getMajor().setMajorNo(Integer.parseInt(major));
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
			out.println("alert('添加成功!');");
		} else {
			out.println("alert('添加失败!');");
		}
		out.println("window.location.href='" + request.getContextPath() + "/course/add-course.jsp'");
		out.println("</script>");
		out.println("</html>");
		out.flush();
		System.out.println(addCount);
	}

	/**
	 * 查询课程信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void queryCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CourseServiceImpl courseService = new CourseServiceImpl();
		String courseName = request.getParameter("courseName");
		String major = request.getParameter("major");
		String courseNo = request.getParameter("courseNo");
		String flag1 = request.getParameter("flag1");
		Course course = null;
		if (courseName != null && major != null) {
			course = new Course();
			course.setCourseName(courseName);
			if (major != null) {
				course.getMajor().setMajorNo(Integer.parseInt(major));
			}
		}
		if (courseNo != null) {// 如果课程编号不为null则查询单个课程信息，并跳转到修改课程界面
			course = courseService.queryByCourseNo(Long.parseLong(courseNo));
			request.setAttribute("course", course);
			System.out.println(flag1);
			if ("select".equals(flag1)) {//如何flag1等于select则跳转到到教师选课界面
				request.getRequestDispatcher("/teacher/course-select.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/course/update-course.jsp").forward(request, response);
			}
		} else {// 如果课程编号为null则按照courseName，major查询课程信息，并跳转到课程列表界面
			List<Course> courseList = courseService.queryByParamenters(course, null);
			request.setAttribute("courseList", courseList);
			request.getRequestDispatcher("/course/course-list.jsp").forward(request, response);
		}
	}

	/**
	 * 删除课程信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CourseService courseService = new CourseServiceImpl();
		String courseNo = request.getParameter("courseNo");
		int delResult = 0;
		if (courseNo != null) {
			delResult = courseService.delete(Long.parseLong(courseNo));
		}

		JSONObject jsonnResult = new JSONObject();
		jsonnResult.put("delResult", delResult);
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonnResult); // 利用json返回删除结果
		out.flush();
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
