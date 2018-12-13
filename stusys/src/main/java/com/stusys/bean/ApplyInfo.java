package com.stusys.bean;
/**
 * 
 * @author liwei
 * @time 2018年11月19日下午8:22:32
 * @description 学籍信息修改申请
 */

public class ApplyInfo {

	private long applyNo;// 申请编号
	private Student student = new Student();// 申请学生信息
	private Teacher handler = new Teacher();// 审核老师信息
	private String handlerResult;//审核结果
	private long handleTime;// 审核时间
	private String status;// 状态（待审核，已审核）
	private String applyContent;// 申请内容
	private String eamil = "";// 申请人邮箱
	private String phone = "";// 申请人电话信息

	/**
	 * @return the applyNo
	 */
	public long getApplyNo() {
		return applyNo;
	}

	/**
	 * @param applyNo the applyNo to set
	 */
	public void setApplyNo(long applyNo) {
		this.applyNo = applyNo;
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
	 * @return the handler
	 */
	public Teacher getHandler() {
		return handler;
	}

	/**
	 * @return the handlerResult
	 */
	public String getHandlerResult() {
		return handlerResult;
	}

	/**
	 * @param handlerResult the handlerResult to set
	 */
	public void setHandlerResult(String handlerResult) {
		this.handlerResult = handlerResult;
	}

	/**
	 * @param handler the handler to set
	 */
	public void setHandler(Teacher handler) {
		this.handler = handler;
	}

	/**
	 * @return the handleTime
	 */
	public long getHandleTime() {
		return handleTime;
	}

	/**
	 * @param handleTime the handleTime to set
	 */
	public void setHandleTime(long handleTime) {
		this.handleTime = handleTime;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the applyContent
	 */
	public String getApplyContent() {
		return applyContent;
	}

	/**
	 * @param applyContent the applyContent to set
	 */
	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}

	/**
	 * @return the eamil
	 */
	public String getEamil() {
		return eamil;
	}

	/**
	 * @param eamil the eamil to set
	 */
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApplyInfo [applyNo=" + applyNo + ", student=" + student + ", handler=" + handler + ", handlerResult="
				+ handlerResult + ", handleTime=" + handleTime + ", status=" + status + ", applyContent=" + applyContent
				+ ", eamil=" + eamil + ", phone=" + phone + "]";
	}
}
