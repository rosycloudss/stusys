package com.stusys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.Major;
import com.stusys.service.MajorService;
import com.stusys.service.impl.DepartmentAndMajorServiceImpl;

/**
 * Servlet implementation class GetDepartmentsServlet
 */
@WebServlet("/major/getbydeptno")
public class GetMajorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMajorsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MajorService majorService = new DepartmentAndMajorServiceImpl();
		// 设置响应内容类型
		// 设置响应内容类型
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		JSONArray jsonArray = new JSONArray();
		try {
			int deptNo = Integer.parseInt(request.getParameter("deptNo"));
//			Department de
			List<Major> majorList = majorService.queryMajorByDeptNo(deptNo, null);
			for (int i = 0; i < majorList.size(); i++) {
				Major major = majorList.get(i);
				JSONObject majorJson = new JSONObject();
				majorJson.put("majorNo", major.getMajorNo());
				majorJson.put("majorName", major.getMajorName());
				jsonArray.add(majorJson);
			}
		} catch (NumberFormatException e) {
			System.out.println("解析院系编号失败！" + e);
		}
		out.print(jsonArray);
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
