package com.stusys.stu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.Score;

public class ScoreDao {
	
	private Connection conn;
	private PreparedStatement prestat;
	private ResultSet rs;
	
	public int add(Score score) {
		int affectColums = 0;
		return affectColums;
	}

	
	public Score select(long scoreNo) {
		Score score = new Score();
		score.setScoreNo(scoreNo);
		List<Score> scoreList = select(score, null);
		if(scoreList != null && !scoreList.isEmpty()) {
			return scoreList.get(0);
		}
		return null;
	}
	
	public List<Score> select(Score score,Page page){
		List<Score> scoreList = new ArrayList<Score>();
		
		return scoreList;
	}
}
