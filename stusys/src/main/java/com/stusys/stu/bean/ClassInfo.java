package com.stusys.stu.bean;

import java.util.HashSet;
import java.util.Set;

import com.stusys.dept.bean.Major;
import com.stusys.dept.bean.Teacher;

/**
 * 
 * @author liwei
 * @time 2018年11月19日下午8:11:35
 * @description 学生班级信息
 */
public class ClassInfo {
	private String classNo;//班级编号 年级 + 专业 + 序号 比如：201624301
	private Major major = new Major();//专业信息
	private String className;//班级名称
	private Student monitor = new Student();//班长信息
	private Teacher teacher = new Teacher();//班主任信息
	private Set<Student> studentSet = new HashSet<Student>(); //班级学生信息
	/**
	 * @return the classNo
	 */
	public String getClassNo() {
		return classNo;
	}
	/**
	 * @param classNo the classNo to set
	 */
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	/**
	 * @return the major
	 */
	public Major getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(Major major) {
		this.major = major;
	}
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @return the monitor
	 */
	public Student getMonitor() {
		return monitor;
	}
	/**
	 * @param monitor the monitor to set
	 */
	public void setMonitor(Student monitor) {
		this.monitor = monitor;
	}
	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassInfo [classNo=" + classNo + ", major=" + major + ", className=" + className + ", monitor="
				+ monitor + ", teacher=" + teacher + "]";
	}
	
}
