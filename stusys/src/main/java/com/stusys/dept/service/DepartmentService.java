package com.stusys.dept.service;

import java.util.List;

import com.stusys.dept.bean.Department;
import com.stusys.page.Page;

public interface DepartmentService {
	
	int addDepartment(Department dept);
	
	int deleteDepartment(Integer deptNo);
	
	int updateDepartment(Department dept);
	
	List<Department> queryDepartByParamenters(Department dept,Page page);
}
