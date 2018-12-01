package com.stusys.dept.service;

import java.util.List;

import com.stusys.dept.bean.Major;
import com.stusys.page.Page;

public interface MajorService {

	int addMajor(Major major);

	int deleteMajor(int majorNo);

	int updateMajor(Major major);

	List<Major> queryMajorByParameters(Major major, Page page);

}
