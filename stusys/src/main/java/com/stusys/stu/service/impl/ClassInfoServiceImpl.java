package com.stusys.stu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.ClassInfo;
import com.stusys.stu.dao.ClassInfoDao;
import com.stusys.stu.service.ClassInfoService;

public class ClassInfoServiceImpl implements ClassInfoService{
	
	private ClassInfoDao classInfoDao = new ClassInfoDao();

	@Override
	public int add(ClassInfo classInfo) {
		if(classInfo != null) {
			return classInfoDao.add(classInfo);
		}
		return 0;
	}

	@Override
	public int add(List<ClassInfo> classInfos) {
		int count = 0;
		if(classInfos != null && !classInfos.isEmpty()) {
			for(ClassInfo classInfo : classInfos) {
				count += add(classInfo);
			}
		}
		return count;
	}

	@Override
	public int delete(String classNo) {
		return classInfoDao.delete(classNo);
	}

	@Override
	public int update(ClassInfo classInfo) {
		return 0;
	}

	@Override
	public List<ClassInfo> queryByMajor(int majorNo, Page page) {
		ClassInfo classInfo = new ClassInfo();
		classInfo.getMajor().setMajorNo(majorNo);
		return queryByParameters(classInfo, page);
	}

	@Override
	public ClassInfo queryByClassNo(String classNo) {
		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassNo(classNo);
		List<ClassInfo> classInfos = queryByParameters(classInfo, null);
		if(classInfos != null && !classInfos.isEmpty()) {
			return classInfos.get(0);
		}
		return null;
	}

	@Override
	public List<ClassInfo> queryByParameters(ClassInfo classInfo, Page page) {
		return classInfoDao.select(classInfo, page);
	}

}
