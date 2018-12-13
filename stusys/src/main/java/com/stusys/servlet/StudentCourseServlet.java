package com.stusys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.StudentCourse;
import com.stusys.bean.Teacher;
import com.stusys.bean.TeacherCourse;
import com.stusys.service.StudentCourseService;
import com.stusys.service.StudentService;
import com.stusys.service.TeacherCourseService;
import com.stusys.service.impl.CourseServiceImpl;
import com.stusys.service.impl.StudentCourseServiceImpl;
import com.stusys.service.impl.StudentServiceImpl;

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
		} else if ("del".equals(flag)) {
			delStudentCourse(request, response);
		}else if("update".equals(flag)) {
			updateStudentCourse(request, response);
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
	 * 修改学生选课信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void updateStudentCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String,String[]> parameterMap = request.getParameterMap();//获取参数的名称和值
		StudentCourseService scs =new StudentCourseServiceImpl();
		
		for(Entry<String,String[]> entry : parameterMap.entrySet()){
			if(!entry.getKey().equals("flag")) {
				StudentCourse sc = new StudentCourse();
				long scNo = Long.parseLong(entry.getKey());
				sc.setScNo(scNo);
				for(String str : entry.getValue()) {
					sc.getScore().setScore(Float.parseFloat(str));
				}
				scs.updateStudentCourse(sc);
			}
		}
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		response.sendRedirect(request.getContextPath() + "/teacher_course?flag=query&role=teacher&teacherNo=" + teacher.getTeacherNo());
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

		List<StudentCourse> scList = new ArrayList<StudentCourse>();
		System.out.println(tcNo);
		if (tcNo != null || stuNo != null) {
			StudentCourse sc = new StudentCourse();
			if (tcNo != null) {
				sc.getTc().setTcNo(Long.parseLong(tcNo));
			}
			if (stuNo != null) {
				sc.setStuNo(stuNo);
			}
			System.out.println(sc.getTc().getTcNo() + "----" + sc.getStuNo());
			scList = scs.queryStudentCourse(sc, null);
			request.setAttribute("scList", scList);
		}
		if ("sc".equals(flag1)) {
			StudentService stuService = new StudentServiceImpl();
			TeacherCourseService tcService = new CourseServiceImpl();
			request.setAttribute("teacherCourse", tcService.queryTCByTCNo(Long.parseLong(tcNo)));
			System.out.println(scList);
			if (scList != null && !scList.isEmpty()) {
				for (int i = 0; i < scList.size(); i++) {
					StudentCourse sc = scList.get(i);
					sc.setStudent(stuService.query(sc.getStuNo()));
					sc.setTc(null);
				}
			}
			request.getRequestDispatcher("/teacher/input-score.jsp").forward(request, response);// 跳转当前选择此课程的学生列表
		} else {
			
			if (scNo != null) {
				StudentCourse sc = scs.queryStudentCourse(Long.parseLong(scNo));
				request.setAttribute("sc", sc);
			}

			if ("cl".equals(flag1)) {// cl表示学生选课列表
				request.getRequestDispatcher("/student/student-course-list.jsp").forward(request, response);// 跳转到学生选课信息表
			} else if ("sl".equals(flag1)) {// sl表示学生成绩列表
				request.getRequestDispatcher("/student/score-list.jsp").forward(request, response);// 跳转到学生成绩列表
			}
		}

	}

	/**
	 * 删除学生选课信息
	 * 
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
