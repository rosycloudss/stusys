package com.stusys.service;

import java.util.List;

import com.stusys.bean.ApplyInfo;
import com.stusys.page.Page;

/**
 * 
 * @author liwei
 * @time 2018年11月21日下午10:51:56
 * @description 学生申请信息服务类
 */
public interface ApplyInfoService {
	
	int add(ApplyInfo applyInfo);
	
	int delete(long applyNo);
	
	int update(ApplyInfo applyInfo);
	
	List<ApplyInfo> queryByStuNo(String stuNo,Page page);
	
	List<ApplyInfo> queryByHandler(String teacherNo,Page page);
	
	List<ApplyInfo> queryByStatus(String status,Page page);
	
	ApplyInfo queryByApplyNo(long applyNo,Page page);
	
	List<ApplyInfo> queryByParameter(ApplyInfo applyInfo,Page page);

}
