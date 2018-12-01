package com.stusys.dept.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.stusys.dept.bean.Department;
import com.stusys.dept.bean.Major;
import com.stusys.dept.dao.DepartmentDao;
import com.stusys.dept.dao.MajorDao;
import com.stusys.dept.service.DepartmentService;
import com.stusys.dept.service.MajorService;
import com.stusys.page.Page;

public class DepartmentAndMajorServiceImpl implements DepartmentService, MajorService {

	private MajorDao majorDao = new MajorDao();
	private DepartmentDao departmentDao = new DepartmentDao();

	@Override
	public int addMajor(Major major) {
		if (major != null) {
			return majorDao.add(major);
		}
		return 0;
	}

	@Override
	public int deleteMajor(int majorNo) {
		return majorDao.delete(majorNo);
	}

	@Override
	public int updateMajor(Major major) {
		if (major != null) {
			return majorDao.update(major);
		}
		return 0;
	}

	@Override
	public List<Major> queryMajorByParameters(Major major, Page page) {
		return majorDao.select(major, page);
	}

	@Override
	public int addDepartment(Department dept) {
		if (dept != null) {
			return departmentDao.add(dept);
		}
		return 0;
	}

	@Override
	public int deleteDepartment(Integer deptNo) {
		if (deptNo != null) {
			return departmentDao.delete(deptNo);
		}
		return 0;
	}

	@Override
	public int updateDepartment(Department dept) {
//		if(dept != null) {
//			return departmentDao
//		}
		return 0;
	}

	/**
	 * 通过院系属性查找院系信息
	 */
	@Override
	public List<Department> queryDepartByParamenters(Department dept, Page page) {
		List<Department> departmentList = new ArrayList<Department>();
		if (dept != null) {
			departmentList = departmentDao.select(dept, page);
			for (Department department : departmentList) {
				Major major = new Major();
				major.setDept(department);
				department.getMajors().addAll(queryMajorByParameters(major, null));
			}
		}
		return departmentList;
	}

}
