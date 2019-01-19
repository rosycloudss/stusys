package com.stusys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.Major;
import com.stusys.service.MajorService;
import com.stusys.service.impl.DepartmentAndMajorServiceImpl;
import com.stusys.servlet.base.BaseServlet;

@WebServlet("/major/getbydeptno")
public class MajorsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private MajorService majorService = new DepartmentAndMajorServiceImpl();

	public MajorsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONArray jsonArray = new JSONArray();
		try {
			int deptNo = Integer.parseInt(request.getParameter("deptNo"));
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

		responseJson(response, jsonArray.toJSONString());

	}


	@Override
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}
