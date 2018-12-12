package com.stusys.stu.bean;

import com.stusys.bean.TeacherCourse;

/**
 * 
 * @author liwei
 * @time 2018年11月19日下午8:37:09
 * @description 学生选课信息
 */
public class StudentCourse {
	private long scNo;// 学生选课编号
	private String stuNo;// 学生学号
	private Student student;//学生信息
	private TeacherCourse tc = new TeacherCourse();// 教师授课信息
	private Score score = new Score();// 学生选课成绩
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
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * @return the tc
	 */
	public TeacherCourse getTc() {
		return tc;
	}
	/**
	 * @param tc the tc to set
	 */
	public void setTc(TeacherCourse tc) {
		this.tc = tc;
	}
	/**
	 * @return the score
	 */
	public Score getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Score score) {
		this.score = score;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentCourse [scNo=" + scNo + ", stuNo=" + stuNo + ", student=" + student + ", tc=" + tc + ", score="
				+ score + "]";
	}

	
}
