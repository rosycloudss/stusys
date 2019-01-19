package com.stusys.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class DateTest {

//	@Test
	public void test() {
		List<String> semesterList = new ArrayList<String>();
		Date nowDate = new Date(System.currentTimeMillis());
		int year = nowDate.getYear() + 1900;
		int month = nowDate.getMonth() + 1;

		for (int i = 10; i > 0; i--) {
			if (i == 10) {
				if (month < 6) {
					semesterList.add((year - 1) + "-" + year + " 第二学期");
				} else {
					semesterList.add(year + "-" + (year + 1) + " 第一学期");
					semesterList.add((year - 1) + "-" + year + " 第二学期");
				}
			} else {
				semesterList.add(year + "-" + (year + 1) + " 第一学期");
				semesterList.add((year - 1) + "-" + year + " 第二学期");
			}
			year--;
		}
		System.out.println(semesterList);
	}
	@Test
	public void test1() {
		//将删除结果放在json中
		JSONObject jsonnResult = new JSONObject();
		jsonnResult.put("delResult", 1);
		System.out.println(jsonnResult.toJSONString());
	}
}
