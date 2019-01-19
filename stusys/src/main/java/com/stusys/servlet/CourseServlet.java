package com.stusys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.Course;
import com.stusys.service.CourseService;
import com.stusys.service.impl.CourseServiceImpl;
import com.stusys.servlet.base.BaseServlet;

@WebServlet("/course")
public class CourseServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CourseService courseService = new CourseServiceImpl();
	private final String SELECT_COURSE = "s";

	/**
	 * 添加课程信息
	 */
	@Override
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String courseName = request.getParameter("courseName");
		String courseDescription = request.getParameter("courseDescription");
		String major = request.getParameter("major");
		String credt = request.getParameter("credt");// 学分
		String classHour = request.getParameter("classHour");// 学时
		String courseType = request.getParameter("courseType");
		int addCount = 0;// 添加成功的数量
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

		String url = request.getContextPath() + "/course/add-course.jsp";
		if (addCount > 0) {
			responseHtml(response, "添加成功！", url);
		} else {
			responseHtml(response, "添加失败！", url);
		}
		System.out.println(addCount);

	}

	/**
	 * 删除课程信息，并返回json格式的数据 {"delResult":1} 删除成功 {"delResult":0} 删除失败
	 */
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String courseNo = request.getParameter("courseNo");
		int delResult = 0;
		if (courseNo != null) {
			delResult = courseService.delete(Long.parseLong(courseNo));
		}

		// 将删除结果放在json中
		JSONObject jsonnResult = new JSONObject();
		jsonnResult.put("delResult", delResult);
		responseJson(response, jsonnResult.toString());

	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 *  查询课程信息
	 */
	@Override
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String courseName = request.getParameter("courseName");
		String major = request.getParameter("major");
		String courseNo = request.getParameter("courseNo");
		String flag1 = request.getParameter("f1");

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
			if (SELECT_COURSE.equals(flag1)) {// 如何flag1等于select则跳转到到教师选课界面
				request.getRequestDispatcher("/teacher/course-select.jsp").forward(request, response);
			} else {// 否则跳转到修改课程界面
				request.getRequestDispatcher("/course/update-course.jsp").forward(request, response);
			}
		} else {// 如果课程编号为null则按照courseName，major查询课程信息，并跳转到课程列表界面
			List<Course> courseList = courseService.queryByParamenters(course, null);
			request.setAttribute("courseList", courseList);
			request.getRequestDispatcher("/course/course-list.jsp").forward(request, response);
		}

	}

}
