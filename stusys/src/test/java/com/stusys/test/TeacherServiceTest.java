package com.stusys.test;

import java.util.List;

import org.junit.Test;

import com.stusys.bean.Teacher;
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
	}
}
