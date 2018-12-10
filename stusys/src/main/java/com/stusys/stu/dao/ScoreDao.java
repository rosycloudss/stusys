package com.stusys.stu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.Score;
import com.stusys.stu.bean.StudentCourse;
import com.stusys.util.DBUtil;

public class ScoreDao {

//	private Connection conn;
//	private PreparedStatement prestat;
//	private ResultSet rs;
//
//	/**
//	 * 添加分数信息
//	 * 
//	 * @param score
//	 * @return
//	 */
//	public int add(Score score) {
//		String sql = "INSERT INTO TB_SCORE(SCORE_NO,SC_NO,SCORE) VALUES(SEQ_SCORE.nextval,?,?)";
//		int affectColums = 0;
//		try {
//			conn = DBUtil.getConnection();
//			if (score != null) {
//				prestat = conn.prepareStatement(sql);
//				prestat.setLong(1, score.getSc().getScNo());
//				prestat.setFloat(2, score.getScore());
//				prestat.executeUpdate();
//			}
//		} catch (SQLException e) {
//			System.out.println("添加分数失败！" + e);
//		} finally {
//			DBUtil.close(rs, prestat, conn);
//		}
//		return affectColums;
//	}
//
//	/**
//	 * 通过分数编号查找分数信息
//	 * 
//	 * @param scoreNo
//	 * @return
//	 */
//	public Score select(long scoreNo) {
//		Score score = new Score();
//		score.setScoreNo(scoreNo);
//		List<Score> scoreList = select(score, null);
//		if (scoreList != null && !scoreList.isEmpty()) {
//			return scoreList.get(0);
//		}
//		return null;
//	}
//
//	/**
//	 * 通过 Score属性值查找分数信息，如果score为null则返回所有
//	 * 
//	 * @param score
//	 * @param page
//	 * @return
//	 */
//	public List<Score> select(Score score, Page page) {
//		List<Score> scoreList = new ArrayList<Score>();
//		StringBuffer sql = new StringBuffer("SELECT SCORE_NO,SC_NO,SCORE FROM TB_SCORE WHERE 1=1");
//		if (score != null) {
//			if (score.getScoreNo() != 0) {
//				sql.append(" AND SCORE_NO=?");
//			}
//			if (score.getSc() != null && score.getSc().getScNo() != 0) {
//				sql.append(" AND SC_NO=?");
//			}
//			if (score.getScore() != -1) {
//				sql.append(" AND SCORE=?");
//			}
//		}
//		if (page != null) {
//			sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
//					+ (page.getPageSize() + page.getPageStart()));
//		}
//
//		try {
//			conn = DBUtil.getConnection();
//			prestat = conn.prepareStatement(sql.toString());
//			if (score != null) {
//				int count = 1;
//				if (score.getScoreNo() != 0) {
//					prestat.setLong(count++, score.getScoreNo());
//				}
//				if (score.getSc() != null && score.getSc().getScNo() != 0) {
//					prestat.setLong(count++, score.getSc().getScNo());
//				}
//				if (score.getScore() != -1) {
//					prestat.setFloat(count++, score.getScore());
//				}
//			}
//			rs = prestat.executeQuery();
//			while (rs.next()) {
//				Score s = new Score();
//				s.setScoreNo(rs.getLong("SCORE_NO"));
//
//				StudentCourse sc = new StudentCourse();
//				sc.setScNo(rs.getLong("SC_NO"));
//				s.setSc(sc);
//
//				s.setScore(rs.getFloat("SCORE"));
//
//				scoreList.add(s);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(rs, prestat, conn);
//		}
//		return scoreList;
//	}
}
