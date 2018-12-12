package com.stusys.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liwei
 * @time 2018年11月19日下午8:05:00
 * @description 课程实体bean
 */
public class Course {
	private long courseNo;//课程编号
	private String courseName;//课程名称
	private String courseDescription;//课程描述
	private Major major = new Major();//专业信息
	private float credt;//学分
	private int classHour;//学时
	private String courseType;//课程种类
	private int lock = -1;//锁 1.已上锁 0.未上锁
	/**
	 * @return the courseNo
	 */
	public long getCourseNo() {
		return courseNo;
	}
	/**
	 * @param courseNo the courseNo to set
	 */
	public void setCourseNo(long courseNo) {
		this.courseNo = courseNo;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}
	/**
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
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
	 * @return the credt
	 */
	public float getCredt() {
		return credt;
	}
	/**
	 * @param credt the credt to set
	 */
	public void setCredt(float credt) {
		this.credt = credt;
	}
	/**
	 * @return the classHour
	 */
	public int getClassHour() {
		return classHour;
	}
	/**
	 * @param classHour the classHour to set
	 */
	public void setClassHour(int classHour) {
		this.classHour = classHour;
	}
	/**
	 * @return the courseType
	 */
	public String getCourseType() {
		return courseType;
	}
	/**
	 * @param courseType the courseType to set
	 */
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	/**
	 * @return the lock
	 */
	public int getLock() {
		return lock;
	}
	/**
	 * @param lock the lock to set
	 */
	public void setLock(int lock) {
		this.lock = lock;
	}
	
	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", major=" + major + ", credt=" + credt + ", classHour=" + classHour
				+ ", courseType=" + courseType + ", lock=" + lock + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classHour;
		result = prime * result + ((courseDescription == null) ? 0 : courseDescription.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + (int) (courseNo ^ (courseNo >>> 32));
		result = prime * result + ((courseType == null) ? 0 : courseType.hashCode());
		result = prime * result + Float.floatToIntBits(credt);
		result = prime * result + lock;
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseNo != other.courseNo)
			return false;
		if (courseType == null) {
			if (other.courseType != null)
				return false;
		} else if (!courseType.equals(other.courseType))
			return false;
		if (Float.floatToIntBits(credt) != Float.floatToIntBits(other.credt))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		return true;
	} 
	
}
