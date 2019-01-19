package com.stusys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.stusys.bean.StudentCourse;
import com.stusys.bean.Teacher;
import com.stusys.service.StudentCourseService;
import com.stusys.service.StudentService;
import com.stusys.service.TeacherCourseService;
import com.stusys.service.impl.CourseServiceImpl;
import com.stusys.service.impl.StudentCourseServiceImpl;
import com.stusys.service.impl.StudentServiceImpl;
import com.stusys.servlet.base.BaseServlet;

@WebServlet("/student/course")
public class StudentCourseServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private StudentCourseService scs = new StudentCourseServiceImpl();
	private final String STUDENT_COURSE_LIST = "scl";// 学生选课列表
	private final String STUDENT_SCORE_LIST = "ssl";// 学生分数列表
	private final String TEACHER_STUDENT_COURSE_LIST = "tscl";// 教师查看选择该课的学生

	/**
	 * 学生选课
	 */
	@Override
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		responseJson(response, jsonResult.toJSONString());

	}

	/**
	 * 删除学生选课信息
	 */
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String scNo = request.getParameter("scNo");
		StudentCourseService scs = new StudentCourseServiceImpl();
		JSONObject jsonResult = new JSONObject();
		int delResult = 0;
		if (scNo != null) {
			delResult = scs.delStudentCourse(Long.parseLong(scNo),null);
		}
		jsonResult.put("delResult", delResult);

		responseJson(response, jsonResult.toJSONString());

	}

	/**
	 * 录入学生选课成绩
	 */
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Map<String, String[]> parameterMap = request.getParameterMap();// 获取参数的名称和值
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			if (!entry.getKey().equals("f")) {
				StudentCourse sc = new StudentCourse();
				long scNo = Long.parseLong(entry.getKey());
				sc.setScNo(scNo);
				for (String str : entry.getValue()) {
					sc.getScore().setScore(Float.parseFloat(str));
				}
				scs.updateStudentCourse(sc);
			}
		}
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		response.sendRedirect(request.getContextPath() + "/teacher_course?f=q&role=teacher&teacherNo="
				+ teacher.getTeacherNo());

	}

	/**
	 * 查询学生选课信息
	 */
	@Override
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tcNo = request.getParameter("tcNo");
		String stuNo = request.getParameter("stuNo");
		String scNo = request.getParameter("scNo");
		String flag1 = request.getParameter("f1");
//		String currenSemester = request.getParameter("semester");

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
		if (TEACHER_STUDENT_COURSE_LIST.equals(flag1)) {
			// 教师查看选择该课程的学生
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
			if (STUDENT_COURSE_LIST.equals(flag1)) {
				// 学生选课列表
				request.getRequestDispatcher("/student/student-course-list.jsp").forward(request, response);// 跳转到学生选课信息表
			} else if (STUDENT_SCORE_LIST.equals(flag1)) {
				// 学生成绩列表
				request.getRequestDispatcher("/student/score-list.jsp").forward(request, response);// 跳转到学生成绩列表
			}
		}

	}

}
