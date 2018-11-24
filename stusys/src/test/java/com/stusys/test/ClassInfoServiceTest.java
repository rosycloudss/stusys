package com.stusys.test;

import org.junit.Before;
import org.junit.Test;

import com.stusys.page.Page;
import com.stusys.stu.bean.ClassInfo;
import com.stusys.stu.service.ClassInfoService;
import com.stusys.stu.service.impl.ClassInfoServiceImpl;

public class ClassInfoServiceTest {
	private ClassInfo classInfo;
	private ClassInfoService classInfoService ;
	private Page page;

	@Before
	public void init() {
		classInfo = new ClassInfo();
		classInfoService = new ClassInfoServiceImpl();
		classInfo.setClassNo("201624301");
		classInfo.getMajor().setMajorNo(243);
		classInfo.getMonitor().setStuNo("20162430111");
		classInfo.getTeacher().setTeacherNo("17498");
		classInfo.setClassName("软工一班");
		page = new Page();
	}
	
	@Test
	public void test() {
//		System.out.println(classInfoService.add(classInfo));
//		System.out.println(classInfoService.queryByClassNo("201624301"));
//		System.out.println(classInfoService.delete());
		System.out.println(classInfoService.queryByParameters(classInfo,page));
	}

}
