package com.stusys.stu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.ApplyInfo;
import com.stusys.stu.dao.ApplyInfoDao;
import com.stusys.stu.service.ApplyInfoService;
/**
 * 
 * @author liwei
 * @time 2018年11月21日下午11:09:45
 * @description 学生申请信息的服务类
 */
public class ApplyInfoServiceImpl implements ApplyInfoService{

	private ApplyInfoDao applyInfoDao = new ApplyInfoDao();
	
	/**
	 * 添加学生申请信息
	 */
	@Override
	public int add(ApplyInfo applyInfo) {
		if(applyInfo != null) {
			return applyInfoDao.add(applyInfo);
		}
		return 0;
	}

	/**
	 * 删除学生申请信息
	 */
	@Override
	public int delete(long applyNo) {
		return applyInfoDao.delete(applyNo);
	}

	/**
	 * 
	 * 修改学生申请信息
	 */
	@Override
	public int update(ApplyInfo applyInfo) {
		if(applyInfo != null) {
			return applyInfoDao.update(applyInfo);
		}
		return 0;
	}

	/**
	 * 通过学号查找学生申请信息
	 */
	@Override
	public List<ApplyInfo> queryByStuNo(String stuNo, Page page) {
		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.getStudent().setStuNo(stuNo);
		return queryByParameter(applyInfo, page);
	}
	/**
	 * 通过处理申请的教师编号查找学生申请信息
	 */
	@Override
	public List<ApplyInfo> queryByHandler(String teacherNo, Page page) {
		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.getHandler().setTeacherNo(teacherNo);
		return queryByParameter(applyInfo, page);
	}

	/**
	 * 通过申请信息的状态查找
	 */
	@Override
	public List<ApplyInfo> queryByStatus(String status, Page page) {
		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.setStatus(status);
		return queryByParameter(applyInfo, page);
	}

	/**
	 * 通过申请编号查找
	 */
	@Override
	public ApplyInfo queryByApplyNo(long applyNo, Page page) {
		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.setApplyNo(applyNo);
		List<ApplyInfo> applyInfos = queryByParameter(applyInfo, page);
		if(!applyInfos.isEmpty()) {
			return applyInfos.get(0);
		}
		return null;
	}

	/**
	 * 通过ApplyInfo 属性查找学生申请信息
	 */
	@Override
	public List<ApplyInfo> queryByParameter(ApplyInfo applyInfo, Page page) {
		if(applyInfo != null) {
			return applyInfoDao.select(applyInfo, page);
		}
		return new ArrayList<ApplyInfo>();
	}

}
