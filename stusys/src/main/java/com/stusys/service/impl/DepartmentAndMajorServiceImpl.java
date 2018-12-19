package com.stusys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.stusys.bean.Department;
import com.stusys.bean.Major;
import com.stusys.dao.DepartmentDao;
import com.stusys.dao.MajorDao;
import com.stusys.page.Page;
import com.stusys.service.DepartmentService;
import com.stusys.service.MajorService;

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
		List<Major> majorList = majorDao.select(major, page);
		if (majorList != null && !majorList.isEmpty()) {
			for (Major m : majorList) {
				if (m.getDept() != null && m.getDept().getDeptNo() != 0) {
					m.setDept(queryDepartByNo(m.getDept().getDeptNo()));
				}
			}
		}
		return majorList;
	}

	@Override
	public List<Major> queryMajorByDeptNo(Integer deptNo, Page page) {
		List<Major> majorList = new ArrayList<Major>();
		if (deptNo != null) {
			Major major = new Major();
			Department dept = new Department();
			dept.setDeptNo(deptNo);
			major.setDept(dept);
			majorList = queryMajorByParameters(major, page);
		}
		return majorList;
	}

	/**
	 * 通过专业编号专业信息
	 */
	@Override
	public Major queryMajorByNo(int majorNo) {
		Major major = new Major();
		major.setMajorNo(majorNo);
		List<Major> majorList = queryMajorByParameters(major, null);
		if (majorList != null && !majorList.isEmpty()) {
			return majorList.get(0);
		}
		return null;
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

	@Override
	public Department queryDepartByNo(Integer deptNo) {
		if (deptNo != null) {
			Department dept = new Department();
			dept.setDeptNo(deptNo);
			List<Department> deptList = queryDepartByParamenters(dept, null);
			if (deptList != null && !deptList.isEmpty()) {
				return deptList.get(0);
			}
		}
		return null;
	}

	/**
	 * 通过院系属性查找院系信息
	 */
	@Override
	public List<Department> queryDepartByParamenters(Department dept, Page page) {
		List<Department> departmentList = new ArrayList<Department>();
		departmentList = departmentDao.select(dept, page);
		for (Department department : departmentList) {
			Major major = new Major();
			major.setDept(department);
			department.getMajors().addAll(majorDao.select(major, null));
		}
		return departmentList;
	}

}
