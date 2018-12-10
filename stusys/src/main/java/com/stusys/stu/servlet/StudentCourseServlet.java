package com.stusys.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.stusys.stu.bean.StudentCourse;
import com.stusys.stu.service.StudentCourseService;
import com.stusys.stu.service.impl.StudentCourseServiceImpl;

/**
 * Servlet implementation class StudentSelectCourseServlet
 */
@WebServlet("/student/course")
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
		String flag = request.getParameter("flag");
		if ("select".equals(flag)) {
			selectCourse(request, response);
		} else if ("query".equals(flag)) {
			queryStudentCourse(request, response);
		} else if("del".equals(flag)) {
			delStudentCourse(request, response);
		}
	}

	/**
	 * 添加学生选课信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void selectCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentCourseService scs = new StudentCourseServiceImpl();
		String tcNo = request.getParameter("tcNo");
		String stuNo = request.getParameter("stuNo");

		int select = 0;
		if (tcNo != null && stuNo != null) {
			StudentCourse sc = new StudentCourse();
			sc.setStuNo(stuNo);
			sc.getTc().setTcNo(Long.parseLong(tcNo));
			if (!scs.queryStudentCourse(sc, null).isEmpty()) {
				select = -1;// 该课程已被选择
			} else {
				select = scs.addStudentCourse(sc);
			}
		}

		JSONObject jsonResult = new JSONObject();
		jsonResult.put("select", select);
		// 设置响应内容类型
		// 设置响应内容类型
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonResult); // 利用json返回删除结果
		out.flush();
	}

	/**
	 * 查询学生选课信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void queryStudentCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentCourseService scs = new StudentCourseServiceImpl();
		String tcNo = request.getParameter("tcNo");
		String stuNo = request.getParameter("stuNo");
		String scNo = request.getParameter("scNo");
		String flag1 = request.getParameter("flag1");
		String currenSemester = request.getParameter("semester");
		
		//判断request中是否有学期信息，没有则从session中获取，有则替换session中的学期信息
		if(currenSemester == null) {
			currenSemester = (String) request.getSession().getAttribute("currentSemester");
		}else {
			request.getSession().setAttribute("currentSemester",currenSemester);
		}
		
		List<StudentCourse> scList = new ArrayList<StudentCourse>();
		if (tcNo != null || stuNo != null) {
			StudentCourse sc = new StudentCourse();
			if (tcNo != null) {
				sc.getTc().setTcNo(Long.parseLong(tcNo));
			}
			if (stuNo != null) {
				sc.setStuNo(stuNo);
			}
			scList = scs.queryStudentCourse(sc, null);
			request.setAttribute("scList", scList);
		}
		if (scNo != null) {
			StudentCourse sc = scs.queryStudentCourse(Long.parseLong(scNo));
			request.setAttribute("sc", sc);
		}
		if ("cl".equals(flag1)) {// cl表示学生选课列表
			request.getRequestDispatcher("/student/student-course-list.jsp").forward(request, response);// 跳转到学生选课信息表
		} else if ("sl".equals(flag1)) {// sl表示学生成绩列表
			for(int i =0;i < scList.size();i++) { //过滤掉成绩为-1 的
				if(scList.get(i).getScore().getScore() != -1f) {
					scList.remove(i);
				}else if(!scList.get(i).getTc().getSemester().equals(currenSemester)){//过滤掉与当前学期不符合的
					scList.remove(i);
				}
				
			}
			request.getRequestDispatcher("/student/score-list.jsp").forward(request, response);// 跳转到学生成绩列表
		}

	}

	/**
	 * 删除学生选课信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void delStudentCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String scNo = request.getParameter("scNo");
		StudentCourseService scs = new StudentCourseServiceImpl();
		JSONObject jsonResult = new JSONObject();
		int delResult = 0;
		if (scNo != null) {
			delResult = scs.delStudentCourse(Long.parseLong(scNo));
		}
		jsonResult.put("delResult", delResult);

		// 设置响应内容类型
		// 设置响应内容类型
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonResult); // 利用json返回删除结果
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
