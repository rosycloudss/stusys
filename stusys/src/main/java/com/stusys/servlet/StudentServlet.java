package com.stusys.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.Major;
import com.stusys.bean.Student;
import com.stusys.page.Page;
import com.stusys.service.StudentService;
import com.stusys.service.impl.StudentServiceImpl;
import com.stusys.servlet.base.BaseServlet;
import com.stusys.util.MD5Util;
import com.stusys.util.WebUtil;

/**
 * 
 * @author LIWEI
 * @time 2019年1月15日下午1:17:09
 * @description:与学生有关的Servlet
 */
@WebServlet("/student")
public class StudentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private StudentService stuService = new StudentServiceImpl();
	private final String UPDATE_PASSWORD = "up";// 修改密码
	private final String INIT_PASSWORD = "123456";// 初始密码

	/**
	 * 修改密码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void update_password(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String stuNo = request.getParameter("stuno");
		String oldPassword = request.getParameter("old_password");
		String newPassword = request.getParameter("new_password");

		System.out.println(stuNo);

		String msg = "";// 提示信息
		String url = request.getContextPath() + "/logout";// 跳转url

		if (stuNo != null) {
			Student student = stuService.query(stuNo);
			System.out.println(student);
			if (student != null) {
				if (MD5Util.MD5(oldPassword).equals(student.getPassword())) {
					student.setPassword(MD5Util.MD5(newPassword));
					if (stuService.update(student) > 0) {
						msg = "修改密码成功!  重新登录！";
					} else {
						msg = "修改密码失败!";
					}
				} else {
					msg = "旧密码错误!";
				}
			}
		} else {
			msg = "修改密码错误!";
		}
		// 返回添加结果
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		out.println("<html>");
		out.println("<script>");
		out.println("alert('" + msg + "');");
		if (url != null) {
			out.println("window.top.location.href='" + url + "'");
		}
		out.println("</script>");
		out.println("</html>");
		out.flush();
	}

	/**
	 * 获取前台传过来的学生信息并返回Student对象
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public Student getStudent(HttpServletRequest request, HttpServletResponse response) {
		Student student = new Student();
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		String sex = request.getParameter("sex");
		String idCard = request.getParameter("idCard");
		String grade = request.getParameter("grade");
		String education = request.getParameter("education");
		String password = request.getParameter("password");

		String enterTime = request.getParameter("enterTime");
		String state = request.getParameter("state");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		// 判断否添加学生
		if (ADD.equals(flagValue)) {
			// 获取学生专业信息
			String major = request.getParameter("major");
			Major m = new Major();
			m.setMajorNo(Integer.parseInt(major));
			student.setMajor(m);
			// 生成学生学号
			int stuCount = stuService.count(student);
			stuNo = grade + major + String.format("%03d", (++stuCount));
			// 初始密码设置为学号
			student.setPassword(MD5Util.MD5(INIT_PASSWORD));

			student.setCreateTime(new Date().getTime());
		} else {
			student.setStuNo(stuNo);
		}
		student.setName(stuName);
		student.setGender(sex);
		student.setIdCard(idCard);
		student.setEducation(education);
		student.setEnterTime(enterTime);
		student.setPhone1(phone1);
		student.setPhone2(phone2);
		student.setQq(qq);
		if (password != null) {
			student.setPassword(MD5Util.MD5(password));
		}
		student.setEmail(email);
		student.setAddress(address);
		student.setStuNo(stuNo);
		if (state != null) {
			student.setState(Integer.parseInt(state));
		}
		return student;

	}

	/**
	 * 添加学生信息
	 */
	@Override
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Student student = getStudent(request, response);// 获取学生信息
		int addCount = stuService.add(student);// 添加学生信息，并获取添加的学生数量
		String msg = "";
		String url = request.getContextPath() + "/student/add-student.jsp";
		if (addCount > 0) {
			msg = "添加成功!学号为" + student.getStuNo() + "!";
		} else {
			msg = "添加失败!";
		}
		responseHtml(response, msg, url);

	}

	/**
	 * 删除学生信息
	 */
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String stuNo = request.getParameter("stuNo");
		int delResult = stuService.delete(stuNo);
		JSONObject jsonnResult = new JSONObject();
		jsonnResult.put("delResult", delResult);
		responseJson(response, jsonnResult.toJSONString());

	}

	/**
	 * 修改学生信息
	 */
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String flag1 = request.getParameter("f1");
		if (UPDATE_PASSWORD.equals(flag1)) {
			// 修改密码
			update_password(request, response);
		} else {
			Student student = getStudent(request, response);// 获取学生信息
			int updateCount = stuService.update(student); // 修改学生信息
			// 返回前台修改结果
			JSONObject updateResult = new JSONObject();
			updateResult.put("updateResult", updateCount);
			responseJson(response, updateResult.toJSONString());
		}

	}

	private final String SELECT_ONE = "one";

	/**
	 * 查询学生信息
	 */
	@Override
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String flag1 = request.getParameter("f1");
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		if (SELECT_ONE.equals(flag1)) {// 修改学生信息
			Student stu = stuService.query(stuNo);
			request.setAttribute("queryedStu", stu);
			request.getRequestDispatcher("/student/student-update.jsp").forward(request, response);
		} else {
			// 查询学生信息
			// 获取学生查询条件
			Student student = new Student();
			if (stuNo != null && !stuNo.equals("")) {
				student.setStuNo(stuNo);
			}
			if (stuName != null && !stuName.equals("")) {
				student.setName(stuName);
			}
			// 设置当前页面信息
			String currentPageStr = request.getParameter("currentPage");
			Page page = new Page(stuService.count(student), 1, 10);
			page.setPath(WebUtil.getPath(request));
			if (currentPageStr != null && !"".equals(currentPageStr)) {
				page.setPageCurrent(Integer.parseInt(currentPageStr));
			}
			System.out.println(page.getPath());
			// 获取学生信息
			List<Student> stuList = stuService.query(student, page);
			request.setAttribute("stuList", stuList);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/student/student-list.jsp").forward(request, response);
		}

	}

//	/**
//	 * 添加学生信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws IOException
//	 */
//	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Student student = getStudent(request, response);// 获取学生信息
//		int addCount = stuService.add(student);// 添加学生信息，并获取添加的学生数量
//
//		PrintWriter out = response.getWriter();
//		// 返回添加结果
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		out.println("<html>");
//		out.println("<script>");
//		if (addCount > 0) {
//			out.println("alert('添加成功!学号为" + student.getStuNo() + "!');");
//		} else {
//			out.println("alert('添加失败!');");
//		}
//		out.println("window.location.href='" + request.getContextPath() + "/student/add-student.jsp'");
//		out.println("</script>");
//		out.println("</html>");
//		out.flush();
//		System.out.println("添加成功");
//	}
//
//	/**
//	 * 修改学生信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws IOException
//	 */
//	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Student student = getStudent(request, response);// 获取学生信息
//		int updateCount = stuService.update(student); // 修改学生信息
//
//		// 返回前台修改结果
//		JSONObject updateResult = new JSONObject();
//		updateResult.put("updateResult", updateCount);
//		responseJson(response, updateResult.toJSONString());
//	}
//
//	/**
//	 * 删除学生信息并将结果以json的格式返回
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws IOException
//	 */
//	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String stuNo = request.getParameter("stuNo");
//		int delResult = stuService.delete(stuNo);
//		JSONObject jsonnResult = new JSONObject();
//		jsonnResult.put("delResult", delResult);
//		responseJson(response, jsonnResult.toJSONString());
//
//	}
//
//	/**
//	 * 查询学生信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws IOException
//	 * @throws ServletException
//	 */
//	public void queryStudent(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//		String flag1 = request.getParameter("flag1");
//		String stuNo = request.getParameter("stuNo");
//		String stuName = request.getParameter("stuName");
//		if ("update".equals(flag1)) {// 修改学生信息
//			Student stu = stuService.query(stuNo);
//			request.setAttribute("queryedStu", stu);
//			request.getRequestDispatcher("/student/student-update.jsp").forward(request, response);
//		} else {
//			// 查询学生信息
//			// 获取学生查询条件
//			Student student = new Student();
//			if (stuNo != null && !stuNo.equals("")) {
//				student.setStuNo(stuNo);
//			}
//			if (stuName != null && !stuName.equals("")) {
//				student.setName(stuName);
//			}
//			// 设置当前页面信息
//			String currentPageStr = request.getParameter("currentPage");
//			Page page = new Page(stuService.count(student), 1, 10);
//			page.setPath(WebUtil.getPath(request));
//			if (currentPageStr != null && !"".equals(currentPageStr)) {
//				page.setPageCurrent(Integer.parseInt(currentPageStr));
//			}
//			System.out.println(page.getPath());
//			// 获取学生信息
//			List<Student> stuList = stuService.query(student, page);
//			request.setAttribute("stuList", stuList);
//			request.setAttribute("page", page);
//			request.getRequestDispatcher("/student/student-list.jsp").forward(request, response);
//		}
//	}
//
//	/**
//	 * 修改学生信息和添加学生信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws IOException
//	 */
//	public void addOrUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		boolean add = "add".equals(flag) ? true : false;
//
//		String stuNo = request.getParameter("stuNo");
//		String stuName = request.getParameter("stuName");
////		String stuPhoto = null;
//		String sex = request.getParameter("sex");
//		String idCard = request.getParameter("idCard");
//		String grade = request.getParameter("grade");
//		String education = request.getParameter("education");
////		String dept = request.getParameter("dept");
//		String major = request.getParameter("major");
//
//		String enterTime = request.getParameter("enterTime");
//		String state = request.getParameter("state");
//		String phone1 = request.getParameter("phone1");
//		String phone2 = request.getParameter("phone2");
//		String qq = request.getParameter("qq");
//		String email = request.getParameter("email");
//		String address = request.getParameter("address");
//
//		Student student = new Student();
//		int addCount = 0;
//		int updateCount = 0;
//		if (stuName != null) {
//			student = new Student();
//			try {
//				if (add) {// add为true则添加学生信息
//					Major m = new Major();
//					m.setMajorNo(Integer.parseInt(major));
//					student.setMajor(m);
//					int stuCount = stuService.count(student);
//					stuCount++;
//					stuNo = grade + major;
//					if (stuCount < 9) {
//						stuNo += "00" + stuCount;
//					} else if (stuCount < 99) {
//						stuNo += "0" + stuCount;
//					} else {
//						stuNo += stuCount;
//					}
//
//					student.setPassword(MD5Util.MD5(stuNo));
//				}
//				student.setName(stuName);
//				student.setGender(sex);
//				student.setIdCard(idCard);
//				student.setEducation(education);
//				student.setEnterTime(enterTime);
//				student.setPhone1(phone1);
//				student.setPhone2(phone2);
//				student.setQq(qq);
//				student.setEmail(email);
//				student.setAddress(address);
//				student.setStuNo(stuNo);
//				student.setCreateTime(new Date().getTime());
//				student.setState(Integer.parseInt(state));
//			} catch (NumberFormatException e) {
//				System.out.println("添加学生信息失败！" + e);
//			}
//			System.out.println(student);
//			if (add) {// add为true则添加学生信息
//				addCount = stuService.add(student);// 添加学生信息，并获取添加的学生数量
//			} else {
//				updateCount = stuService.update(student); // 修改学生信息
//			}
//		}
//
//		if (add) {
//			response.setContentType("text/html");
//			response.setCharacterEncoding("utf-8");
//			out.println("<html>");
//			out.println("<script>");
//			if (addCount > 0) {
//				out.println("alert('添加成功!');");
//			} else {
//				out.println("alert('添加失败!');");
//			}
//			out.println("window.location.href='" + request.getContextPath() + "/student/add-student.jsp'");
//			out.println("</script>");
//			out.println("</html>");
//			out.flush();
//		} else {
//			JSONObject updateResult = new JSONObject();
//			updateResult.put("updateResult", updateCount);
//			// 设置响应内容类型
//			// 设置响应内容类型
//			response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
//			response.setCharacterEncoding("UTF-8");
//			out.println(updateResult); // 利用json返回修改结果
//			out.flush();
//		}
//	}

}
