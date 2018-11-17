package com.stusys.stu.bean;


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
	private String birthday;// 学生生日
	private String idCard;// 学生身份证号
	private Integer majorId;// 专业编号
	private String address;// 学生家庭住址
	private String phone1;// 联系电话1
	private String phone2;// 联系电话2
	private String qq;// 学生QQ
	private String email;// 学生邮箱
	private String education;// 学历 （本科，研究生，博士）
	private String enterTime;// 入校时间
	private Integer state;// 状态（1.在读，2.毕业，3.休学，4.劝退）
	private String photoPath;// 学生照片地址
	private String salt;// 盐
	private Long createTime;
	
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
	 * @param bame the bame to set
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
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	 * @return the majorId
	 */
	public Integer getMajorId() {
		return majorId;
	}
	/**
	 * @param majorId the majorId to set
	 */
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
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
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", idCard=" + idCard + ", majorId=" + majorId + ", address=" + address
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", qq=" + qq + ", email=" + email + ", education="
				+ education + ", enterTime=" + enterTime + ", state=" + state + ", photoPath=" + photoPath + ", salt="
				+ salt + "]";
	}
	

}
