package com.stusys.stu.service;

import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.ClassInfo;

/**
 * 
 * @author liwei
 * @time 2018年11月22日下午3:38:31
 * @description 班级信息Service类
 */
public interface ClassInfoService {

	int add(ClassInfo classInfo);
	
	int add(List<ClassInfo> classInfos);
	
	int delete(String classNo);
	
	int update(ClassInfo classInfo);
	
	List<ClassInfo> queryByMajor(int majorNo,Page page);
	
	ClassInfo queryByClassNo(String classNo);
	
	List<ClassInfo> queryByParameters(ClassInfo classInfo,Page page);
}
