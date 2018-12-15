package com.stusys.bean;

import java.util.Set;

/**
 * 
 * @author liwei
 * @time 2018年11月19日下午7:58:38
 * @description 专业实体bean
 */
public class Major {
	private int majorNo;// 专业编号
	private String majorName;// 专业名称
	private Department dept;// 学院信息
	private long createTime;// 创建时间
	private int lenOfSchool;// 学制
	private String type;// 专业种类
	private Teacher teacher;// 系主任信息
	private Set<Course> courseSet;

	/**
	 * @return the majorNo
	 */
	public int getMajorNo() {
		return majorNo;
	}

	/**
	 * @param majorNo the majorNo to set
	 */
	public void setMajorNo(int majorNo) {
		this.majorNo = majorNo;
	}

	/**
	 * @return the majorName
	 */
	public String getMajorName() {
		return majorName;
	}

	/**
	 * @param majorName the majorName to set
	 */
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	/**
	 * @return the dept
	 */
	public Department getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(Department dept) {
		this.dept = dept;
	}

	/**
	 * @return the createTime
	 */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the lenOfSchool
	 */
	public int getLenOfSchool() {
		return lenOfSchool;
	}

	/**
	 * @param lenOfSchool the lenOfSchool to set
	 */
	public void setLenOfSchool(int lenOfSchool) {
		this.lenOfSchool = lenOfSchool;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the courseSet
	 */
	public Set<Course> getCourseSet() {
		return courseSet;
	}

	/**
	 * @param courseSet the courseSet to set
	 */
	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Major [majorNo=" + majorNo + ", majorName=" + majorName + ", dept=" + dept + ", createTime="
				+ createTime + ", lenOfSchool=" + lenOfSchool + ", type=" + type + ", teacher=" + teacher
				+ ", courseSet=" + courseSet + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseSet == null) ? 0 : courseSet.hashCode());
		result = prime * result + (int) (createTime ^ (createTime >>> 32));
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + lenOfSchool;
		result = prime * result + ((majorName == null) ? 0 : majorName.hashCode());
		result = prime * result + majorNo;
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Major other = (Major) obj;
		if (majorNo != other.majorNo) {
			return false;
		}
		return true;
	}

}
