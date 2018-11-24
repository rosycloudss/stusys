package com.stusys.stu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.Student;
import com.stusys.stu.dao.StudentDao;
import com.stusys.stu.service.StudentService;
import com.stusys.util.MD5Util;

public class StudentServiceImpl implements StudentService {

	StudentDao stuDao = new StudentDao();

	/**
	 * 添加学生信息
	 */
	public int add(Student stu) {
		if (stu != null) {
			return stuDao.add(stu);
		}
		return 0;
	}

	/**
	 * 批量添加学生信息
	 */
	public int add(List<Student> stuList) {
		int addNum = 0;
		if (stuList != null && !stuList.isEmpty()) {
			for (Student stu : stuList) {
				addNum += stuDao.add(stu);
			}
		}
		return addNum;
	}

	/**
	 * 通过学号删除学生信息
	 */
	public int delete(String stuNo) {
		if (stuNo != null) {
			return stuDao.delte(stuNo);
		}
		return 0;
	}

	/**
	 * 修改学生信息
	 */
	public int update(Student stu) {
		if (stu != null) {
			return stuDao.update(stu);
		}
		return 0;
	}

	/**
	 * 学生登录
	 */
	public Student login(String stuNo, String password) {
		List<Student> stuList = new ArrayList<Student>();
		stuList.addAll(stuDao.select(stuNo, MD5Util.MD5(password)));
		if (!stuList.isEmpty()) {
			return stuList.get(0);
		}
		return null;
	}

	/**
	 * 通过学生属性查找学生信息
	 */
	public List<Student> query(Student stu, Page page) {
		List<Student> stuList = new ArrayList<Student>();
		stuList.addAll(query(stu, page));
		return stuList;
	}

	/**
	 * 查询学生数量
	 */
	public int count(Student stu) {
		return stuDao.count(stu);
	}

	@Override
	public Student query(String stuNo) {
		Student student = new Student();
		student.setStuNo(stuNo);
		List<Student> stus = query(student, null);
		if(!stus.isEmpty()) {
			return stus.get(0);
		}
		return null;
	}

	@Override
	public List<Student> query(int majorNo, Page page) {
		Student student = new Student();
		student.getMajor().setMajorNo(majorNo);
		return stuDao.select(student, page);
	}

	@Override
	public List<Student> query(String stuName, Page page) {
		Student student = new Student();
		student.setName(stuName);
		return query(student,page);
	}

}
