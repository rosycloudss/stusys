package com.stusys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.Teacher;
import com.stusys.service.TeacherService;
import com.stusys.service.impl.TeacherServiceImpl;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherServlet() {
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

		if ("add".endsWith(flag)) { // 添加教师信息
			addTeacher(request, response);
		} else if ("query".equals(flag)) {
			queryTeacher(request, response);
		} else if ("delete".equals(flag)) {
			deleteTeacher(request, response);
		}

	}

	/**
	 * 添加教师信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TeacherService teacherService = new TeacherServiceImpl();
		String teacherName = request.getParameter("teacherName");
		String role = request.getParameter("role");
		String dept = request.getParameter("dept");

		int add = 0; // 记录添加教师数量
		String teacherNo = null;
		if (teacherName != null && role != null && dept != null) {
			try {
				Teacher teacher = new Teacher();
				teacher.setTeacherNo("" + new Date().getTime());// 以添加时间作为教师的编号
				teacherNo = teacher.getTeacherNo();

				teacher.setTeacherName(teacherName);
				teacher.getDepat().setDeptNo(Integer.parseInt(dept));
				teacher.setRole(Integer.parseInt(role));
				add = teacherService.addTeacher(teacher); // 添加教师信息
			} catch (NumberFormatException e) {
				System.out.println("解析院系编号或职位编号失败！" + e);
			}
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		out.println("<html>");
		out.println("<script>");
		if (add > 0) {
			out.println("alert('添加" + teacherNo + "成功!');");
		} else {
			out.println("alert('添加失败!');");
		}
		out.println("window.location.href='" + request.getContextPath() + "/teacher/add-teacher.jsp'");
		out.println("</script>");
		out.println("</html>");
	}

	/**
	 * 查询教师信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void queryTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherService teacherService = new TeacherServiceImpl();
		String teacherName = request.getParameter("teacherName");
		String teacherNo = request.getParameter("teacherNo");
		Teacher teacher = null;
		if (teacherName != null || teacherNo != null) {
			teacher = new Teacher();
			teacher.setTeacherName(teacherName);
			teacher.setTeacherNo(teacherNo);
		}
		// 查询教师信息
		List<Teacher> teacherList = teacherService.queryTeacher(teacher, null);
		request.setAttribute("teacherList", teacherList);
		request.getRequestDispatcher("/teacher/teacher-list.jsp").forward(request, response);
	}

	/**
	 * 删除教师信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TeacherService teacherService = new TeacherServiceImpl();
		String teacherNo = request.getParameter("teacherNo");
		int delete = teacherService.deleteTeacher(teacherNo);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("delResult", delete);

		// 设置响应内容类型
		// 设置响应内容类型
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonObject); // 利用json返回删除结果
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
