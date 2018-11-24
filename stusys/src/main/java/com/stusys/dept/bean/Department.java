package com.stusys.dept.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liwei
 * @time 2018年11月19日下午7:56:03
 * @description 院系实体bean
 */
public class Department {
	private int deptNo;// 院系编号
	private String deptName;// 院系名称
	private String setUpTime;// 院系成立时间
	private Set<Major> majors = new HashSet<Major>();//院系专业信息
	/**
	 * @return the deptNo
	 */
	public int getDeptNo() {
		return deptNo;
	}
	/**
	 * @param deptNo the deptNo to set
	 */
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * @return the setUpTime
	 */
	public String getSetUpTime() {
		return setUpTime;
	}
	/**
	 * @param setUpTime the setUpTime to set
	 */
	public void setSetUpTime(String setUpTime) {
		this.setUpTime = setUpTime;
	}
	/**
	 * @return the majors
	 */
	public Set<Major> getMajors() {
		return majors;
	}
	/**
	 * @param majors the majors to set
	 */
	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", setUpTime=" + setUpTime + ", majors="
				+ majors + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + deptNo;
		result = prime * result + ((majors == null) ? 0 : majors.hashCode());
		result = prime * result + ((setUpTime == null) ? 0 : setUpTime.hashCode());
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
		Department other = (Department) obj;
		if (deptNo != other.deptNo)
			return false;
		return true;
	}

}
