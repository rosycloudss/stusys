package com.stusys.test;

import java.util.Date;

import org.junit.Test;

import com.stusys.bean.Teacher;
import com.stusys.page.Page;
import com.stusys.service.TeacherService;
import com.stusys.service.impl.TeacherServiceImpl;
import com.stusys.util.MD5Util;

public class TeacherServiceTest {

	@Test
	public void test() {
		TeacherService teacherService = new TeacherServiceImpl();
//		List<Teacher> teacherList = teacherService.queryTeacher(null, null);
//		for(int i = 0;i < teacherList.size();i++) {
//			Teacher teacher = teacherList.get(i);
//			teacher.setPassword(MD5Util.MD5(teacher.getTeacherNo()));
//			System.out.println(teacherService.updateTeacher(teacher));
//		}
		
		Teacher teacher = new Teacher();
		teacher.setTeacherNo("" + new Date().getTime());// 以添加时间作为教师的编号
		teacher.setPassword(MD5Util.MD5("123456"));
		teacher.setTeacherName("张老师");
		teacher.getDepat().setDeptNo(24);
		teacher.setRole(2);
//		 System.out.println(teacherService.addTeacher(teacher)); 
		 System.out.println(teacherService.countTeacher(null));
		 
		 Page page = new Page(teacherService.countTeacher(null),2,4);
		 System.out.println(teacherService.queryTeacher((Teacher)null, page));
	}
}
