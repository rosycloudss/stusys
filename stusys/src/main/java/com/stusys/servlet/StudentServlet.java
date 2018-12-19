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

import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.Major;
import com.stusys.bean.Student;
import com.stusys.page.Page;
import com.stusys.service.StudentService;
import com.stusys.service.impl.StudentServiceImpl;
import com.stusys.util.MD5Util;
import com.stusys.util.WebUtil;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
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
		if ("add".equals(flag) || "update".equals(flag)) {
			addOrUpdateStudent(request, response);
		} else if ("query".equals(flag)) {
			queryStudent(request, response);
		} else if ("delete".equals(flag)) {
			delete(request, response);
		}

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

	/**
	 * 修改学生信息和添加学生信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void addOrUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentService stuService = new StudentServiceImpl();
		String flag = request.getParameter("flag");
		boolean add = "add".equals(flag) ? true : false;
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		String stuPhoto = null;
		String sex = request.getParameter("sex");
		String idCard = request.getParameter("idCard");
		String grade = request.getParameter("grade");
		String education = request.getParameter("education");
		String dept = request.getParameter("dept");
		String major = request.getParameter("major");
		String enterTime = request.getParameter("enterTime");
		String state = request.getParameter("state");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		Student student = new Student();
		int addCount = 0;
		int updateCount = 0;
		System.out.println("major =" + major);
		if (stuName != null) {
			student = new Student();
			try {
				if (add) {//add为true则添加学生信息
					Major m = new Major();
					m.setMajorNo(Integer.parseInt(major));
					student.setMajor(m);
					int stuCount = stuService.count(student);
					stuCount++;
					stuNo = grade + major;
					if (stuCount < 9) {
						stuNo += "00" + stuCount;
					} else if (stuCount < 99) {
						stuNo += "0" + stuCount;
					} else {
						stuNo += stuCount;
					}
					
					student.setPassword(MD5Util.MD5(stuNo));
				}
				student.setName(stuName);
				student.setGender(sex);
				student.setIdCard(idCard);
				student.setEducation(education);
				student.setEnterTime(enterTime);
				student.setPhone1(phone1);
				student.setPhone2(phone2);
				student.setQq(qq);
				student.setEmail(email);
				student.setAddress(address);
				student.setStuNo(stuNo);
				student.setCreateTime(new Date().getTime());
				student.setState(Integer.parseInt(state));
			} catch (NumberFormatException e) {
				System.out.println("添加学生信息失败！" + e);
			}
			System.out.println(student);
			if (add) {//add为true则添加学生信息
				addCount = stuService.add(student);// 添加学生信息，并获取添加的学生数量
			} else {
				updateCount = stuService.update(student); //修改学生信息
			}
		}
		PrintWriter out = response.getWriter();
		if (add) {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			out.println("<html>");
			out.println("<script>");
			if (addCount > 0) {
				out.println("alert('添加成功!');");
			} else {
				out.println("alert('添加失败!');");
			}
			out.println("window.location.href='" + request.getContextPath() + "/student/add-student.jsp'");
			out.println("</script>");
			out.println("</html>");
		} else {
			JSONObject updateResult = new JSONObject();
			updateResult.put("updateResult", updateCount);
			// 设置响应内容类型
			// 设置响应内容类型
			response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
			response.setCharacterEncoding("UTF-8");
			out.println(updateResult); // 利用json返回删除结果
			out.flush();
		}

	}
	/**
	 * 删除学生信息并将结果以json的格式返回
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentService stuService = new StudentServiceImpl();
		
		String stuNo = request.getParameter("stuNo");
		int delResult = stuService.delete(stuNo);
		
		JSONObject jsonnResult = new JSONObject();
		jsonnResult.put("delResult", delResult);
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonnResult); // 利用json返回删除结果
		out.flush();

	}

	/**
	 * 查询学生信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void queryStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		StudentService stuService = new StudentServiceImpl();
		String flag1 = request.getParameter("flag1");
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		if ("update".equals(flag1)) {//修改学生信息
			Student stu = stuService.query(stuNo);
			request.setAttribute("queryedStu", stu);
			request.getRequestDispatcher("/student/student-update.jsp").forward(request, response);
		} else {
			//查询学生信息
			//获取学生查询条件
			Student student = new Student();
			if (stuNo != null && !stuNo.equals("")) {
				student.setStuNo(stuNo);
			}
			if (stuName != null && !stuName.equals("")) {
				student.setName(stuName);
			}
			//设置当前页面信息
			String currentPageStr = request.getParameter("currentPage");
			Page page = new Page(stuService.count(student), 1, 10);
			page.setPath(WebUtil.getPath(request));
			if(currentPageStr != null && !"".equals(currentPageStr)) {
				page.setPageCurrent(Integer.parseInt(currentPageStr));;
			}
			System.out.println(page.getPath());
			//获取学生信息
			List<Student> stuList = stuService.query(student, page);
			request.setAttribute("stuList", stuList);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/student/student-list.jsp").forward(request, response);
		}
	}

}
