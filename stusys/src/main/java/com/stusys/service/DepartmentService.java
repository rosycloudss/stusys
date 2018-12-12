package com.stusys.service;

import java.util.List;

import com.stusys.bean.Department;
import com.stusys.page.Page;

public interface DepartmentService {
	
	int addDepartment(Department dept);
	
	int deleteDepartment(Integer deptNo);
	
	int updateDepartment(Department dept);
	
	List<Department> queryDepartByParamenters(Department dept,Page page);
	
	public Department queryDepartByNo(Integer deptNo);
}
