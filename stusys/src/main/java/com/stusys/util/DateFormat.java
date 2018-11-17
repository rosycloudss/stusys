package com.stusys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	
	public static  String dateToString(Date date,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date stringToDate(String source) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		return  (Date) sdf.parse(source);
	}
	
	
	
}
