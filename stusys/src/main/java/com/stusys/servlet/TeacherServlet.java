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
import com.stusys.page.Page;
import com.stusys.service.TeacherService;
import com.stusys.service.impl.TeacherServiceImpl;
import com.stusys.servlet.base.BaseServlet;
import com.stusys.util.MD5Util;
import com.stusys.util.WebUtil;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/teacher")
public class TeacherServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService = new TeacherServiceImpl();
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//
//		if ("add".equals(flag)) { // 添加教师信息
//			addTeacher(request, response);
//		} else if ("query".equals(flag)) {
//			queryTeacher(request, response);
//		} else if ("delete".equals(flag)) {
//			deleteTeacher(request, response);
//		}
//
//	}

	/**
	 * 添加教师信息
	 */
	@Override
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
				teacher.setPassword(MD5Util.MD5("123456"));
				teacher.setTeacherName(teacherName);
				teacher.getDepat().setDeptNo(Integer.parseInt(dept));
				teacher.setRole(Integer.parseInt(role));
				add = teacherService.addTeacher(teacher); // 添加教师信息
			} catch (NumberFormatException e) {
				System.out.println("解析院系编号或职位编号失败！" + e);
			}
		}

		String msg = "";// 提示信息
		String url = request.getContextPath() + "/teacher/add-teacher.jsp";// 跳转url
		if (add > 0) {
			msg = "添加" + teacherNo + "成功!";
		} else {
			msg = "添加失败!";
		}
		responseHtml(response, msg, url);

	}

	/**
	 * 删除教师信息
	 */
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String teacherNo = request.getParameter("teacherNo");
		int delete = teacherService.deleteTeacher(teacherNo);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("delResult", delete);
		responseJson(response, jsonObject.toJSONString());

	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	}

	/**
	 * 查询教师信息
	 */
	@Override
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String teacherName = request.getParameter("teacherName");
		String teacherNo = request.getParameter("teacherNo");
		Teacher teacher = null;
		if (teacherName != null || teacherNo != null) {
			teacher = new Teacher();
			if (teacherName != null && !"".equals(teacherName)) {
				teacher.setTeacherName(teacherName);
			}
			if (teacherNo != null && !"".equals(teacherNo)) {
				teacher.setTeacherNo(teacherNo);
			}
		}
		// 设置当前页面信息
		String currentPageStr = request.getParameter("currentPage");
		Page page = new Page(teacherService.countTeacher(teacher), 1, 10);
		page.setPath(WebUtil.getPath(request));
		if (currentPageStr != null && !"".equals(currentPageStr)) {
			page.setPageCurrent(Integer.parseInt(currentPageStr));
			;
		}
		// 查询教师信息
		List<Teacher> teacherList = teacherService.queryTeacher(teacher, page);
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/teacher/teacher-list.jsp").forward(request, response);

	}

}
