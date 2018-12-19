package com.stusys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stusys.bean.Major;
import com.stusys.bean.Student;
import com.stusys.dao.StudentDao;
import com.stusys.page.Page;
import com.stusys.service.MajorService;
import com.stusys.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDao stuDao = new StudentDao();
	MajorService majorService = new DepartmentAndMajorServiceImpl();
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
		if (stuNo != null && password != null) {
			Student stu = new Student();
			stu.setStuNo(stuNo);
			stuList.addAll(query(stu, null));
		}
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
		stuList = stuDao.select(stu, page);
		if(stuList != null && !stuList.isEmpty()) {
			Map<Integer,Major> majorMap = new HashMap<Integer,Major>(); //缓存专业信息
			for(int i = 0;i < stuList.size();i++) {
				Student student = stuList.get(i); 
				if(student.getMajor() != null && student.getMajor().getMajorNo() != 0) {
					int majorNo = student.getMajor().getMajorNo();
					if(majorMap.get(majorNo) == null) {//如果缓存中没有当前专业信息，则从数据库中查找专业信息
						Major major = majorService.queryMajorByNo(majorNo);
						majorMap.put(majorNo, major);
					}
					student.setMajor(majorMap.get(majorNo));
				}
			}
		}
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
		List<Student> stuList = query(student, null);
		if (stuList != null && !stuList.isEmpty()) {
			return stuList.get(0);
		}
		return null;
	}

	@Override
	public List<Student> query(int majorNo, Page page) {
		Student student = new Student();
		Major major = new Major();
		major.setMajorNo(majorNo);
		student.setMajor(major);;
		return stuDao.select(student, page);
	}

	@Override
	public List<Student> query(String stuName, Page page) {
		Student student = new Student();
		student.setName(stuName);
		return query(student, page);
	}

}
