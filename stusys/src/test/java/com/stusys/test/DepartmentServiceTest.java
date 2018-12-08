package com.stusys.test;

import org.junit.Test;

import com.stusys.dept.service.impl.DepartmentAndMajorServiceImpl;

public class DepartmentServiceTest {

	@Test
	public void test() {
		DepartmentAndMajorServiceImpl deptService = new DepartmentAndMajorServiceImpl();	
		
//		System.out.println(deptService.queryDepartByParamenters(null, null));
//		System.out.println(deptService.queryMajorByParameters(null, null));
//		
		System.out.println(deptService.queryMajorByDeptNo(24, null));
	}
}
