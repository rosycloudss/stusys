package com.stusys.bean;

/**
 * 
 * @author liwei
 * @time 2018年11月19日下午8:03:56
 * @description 教师信息
 */
public class Teacher {
	private String teacherNo;// 教师编号
	private String password;//教师登录密码
	private String teacherName;// 教师名称
	private Department depat = new Department();// 院系信息
	private long createTime;// 创建时间
	private int role;// 教师身份 1.普通教师，2.管理员

	/**
	 * @return the teacherNo
	 */
	public String getTeacherNo() {
		return teacherNo;
	}

	/**
	 * @param teacherNo the teacherNo to set
	 */
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @return the depat
	 */
	public Department getDepat() {
		return depat;
	}

	/**
	 * @param depat the depat to set
	 */
	public void setDepat(Department depat) {
		this.depat = depat;
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
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
	
	public String getRoleStr() {
		if(role == 1) {
			return "普通教师";
		}else if(role == 2) {
			return "管理员";
		}
		return "";
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + ", password=" + password + ", teacherName=" + teacherName
				+ ", depat=" + depat + ", createTime=" + createTime + ", role=" + role + "]";
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
		result = prime * result + (int) (createTime ^ (createTime >>> 32));
		result = prime * result + ((depat == null) ? 0 : depat.hashCode());
		result = prime * result + role;
		result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode());
		result = prime * result + ((teacherNo == null) ? 0 : teacherNo.hashCode());
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
		Teacher other = (Teacher) obj;
		if (teacherNo == null) {
			if (other.teacherNo != null)
				return false;
		} else if (!teacherNo.equals(other.teacherNo))
			return false;
		return true;
	}

}
