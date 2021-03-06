package com.stusys.bean;

/**
 * 
 * @author LIWEI
 * @time 2018年11月14日下午5:23:39
 * @description：学生实体bean类
 *
 */
public class Student {

	private String stuNo;// 学号
	private String password;// 密码
	private String name;// 学生姓名
	private String gender;// 学生性别
	private String idCard;// 学生身份证号
	private Major major;// 专业信息
	private String address;// 学生家庭住址
	private String phone1;// 联系电话1
	private String phone2;// 联系电话2
	private String qq;// 学生QQ
	private String email;// 学生邮箱
	private String education;// 学历 （本科，研究生，博士）
	private String enterTime;// 入校时间
	private int state;// 状态（1.在读，2.毕业，3.休学，4.劝退）
	private String photoPath;// 学生照片地址
	private Long createTime;// 创建时间
	private int lock = 0;// 0,表示未上锁，1表示已上锁

	private String grade;

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
		if (stuNo != null && stuNo.length() > 4) {
			grade = stuNo.substring(0, 4);
		}
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the enterTime
	 */
	public String getEnterTime() {
		return enterTime;
	}

	/**
	 * @param enterTime the enterTime to set
	 */
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	// 状态（1.在读，2.毕业，3.休学，4.劝退）
	public String getStateStr() {
		switch (state) {
		case 1:
			return "在读";
		case 2:
			return "已毕业";
		case 3:
			return "休学";
		case 4:
			return "劝退";
		default:
			return "";
		}
	}

	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * @return the createTime
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", idCard=" + idCard + ", major=" + major + ", address=" + address + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", qq=" + qq + ", email=" + email + ", education=" + education + ", enterTime="
				+ enterTime + ", state=" + state + ", photoPath=" + photoPath + ", createTime=" + createTime + ", lock="
				+ lock + ", grade=" + grade + "]";
	}
}
