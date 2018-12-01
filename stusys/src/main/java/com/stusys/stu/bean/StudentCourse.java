package com.stusys.stu.bean;

import com.stusys.dept.bean.Course;
import com.stusys.dept.bean.TeacherCourse;

/**
 * 
 * @author liwei
 * @time 2018年11月19日下午8:37:09
 * @description 学生选课信息
 */
public class StudentCourse {
	private long scNo;//学生选课编号
	private String stuNo;//学号
	private Student student = new Student();//学生信息
	private long tcNo;//教师授课编号
	private long scoreNo;//学生成绩编号
	private Score score = new Score();//学生选课成绩
	/**
	 * @return the scNo
	 */
	public long getScNo() {
		return scNo;
	}
	/**
	 * @param scNo the scNo to set
	 */
	public void setScNo(long scNo) {
		this.scNo = scNo;
	}
	/**
	 * @return the stuNo
	 */
	public String getStuNo() {
		return stuNo;
	}
	/**
	 * @param stuNo the stuNo to set
	 */
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	/**
	 * @return the tcNo
	 */
	public long getTcNo() {
		return tcNo;
	}
	/**
	 * @param tcNo the tcNo to set
	 */
	public void setTcNo(long tcNo) {
		this.tcNo = tcNo;
	}
	/**
	 * @return the scoreNo
	 */
	public long getScoreNo() {
		return scoreNo;
	}
	/**
	 * @param scoreNo the scoreNo to set
	 */
	public void setScoreNo(long scoreNo) {
		this.scoreNo = scoreNo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentCourse [scNo=" + scNo + ", stuNo=" + stuNo + ", tcNo=" + tcNo + ", scoreNo=" + scoreNo + "]";
	}
	
}
