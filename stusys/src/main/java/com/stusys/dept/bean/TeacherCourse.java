package com.stusys.dept.bean;

/**
 * 
 * @author liwei
 * @time 2018年11月19日下午8:41:38
 * @description 教师授课关系表
 */
public class TeacherCourse {
//	private long courseNo;//课程编号
	private Course course = new Course();//课程信息
	private Teacher teacher = new Teacher();//授课老师信息
	private String semester;//学期
	private long tcNo;//教师选课编号
	private String teachAddressTime;//上课时间和地点
	private int studentNum;//学生数量；
	private int selectNum;//已选学生数
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
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
	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
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
	 * @return the teachAddressTime
	 */
	public String getTeachAddressTime() {
		return teachAddressTime;
	}
	/**
	 * @param teachAddressTime the teachAddressTime to set
	 */
	public void setTeachAddressTime(String teachAddressTime) {
		this.teachAddressTime = teachAddressTime;
	}
	/**
	 * @return the studentNum
	 */
	public int getStudentNum() {
		return studentNum;
	}
	/**
	 * @param studentNum the studentNum to set
	 */
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	/**
	 * @return the selectNum
	 */
	public int getSelectNum() {
		return selectNum;
	}
	/**
	 * @param selectNum the selectNum to set
	 */
	public void setSelectNum(int selectNum) {
		this.selectNum = selectNum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeacherCourse [course=" + course + ", teacher=" + teacher + ", semester=" + semester + ", tcNo=" + tcNo
				+ ", teachAddressTime=" + teachAddressTime + ", studentNum=" + studentNum + ", selectNum=" + selectNum
				+ "]";
	}
}
