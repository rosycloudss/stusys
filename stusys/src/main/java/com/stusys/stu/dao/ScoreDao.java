package com.stusys.stu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.stusys.stu.bean.Score;

public class ScoreDao {
	
	private Connection conn;
	private PreparedStatement prestat;
	private ResultSet rs;
	
	public int add(Score score) {
		int affectColums = 0;
		return affectColums;
	}

}
