package com.stusys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stusys.bean.StudentCourse;
import com.stusys.page.Page;
import com.stusys.util.DBUtil;

/**
 * 
 * @author LIWEI
 * @time 2018年12月9日上午1:06:34
 * @description:学生选课信息的dao层
 */
public class StudentCourseDao {

	private Connection conn;
	private PreparedStatement prestat;
	private ResultSet rs;

	/**
	 * 添加教师授课信息
	 * 
	 * @param stuCourse
	 * @return
	 */
	public int add(StudentCourse stuCourse) {
		String sql = "INSERT INTO TB_STUDENT_COURSE(SC_NO,STU_NO,TC_NO,SCORE) VALUES(SEQ_SC.nextval,?,?,?)";
		int affectColums = 0;
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, stuCourse.getStuNo());
			prestat.setLong(2, stuCourse.getTc().getTcNo());
			prestat.setFloat(3, stuCourse.getScore() != null ? stuCourse.getScore().getScore() : null);
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("查询学生选课信息失败" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 删除学生选课信息
	 * 
	 * @param scNo
	 * @return
	 */
	public int delete(Long scNo,Long tcNo) {
		if(scNo == null && tcNo == null) {
			return 0;
		}
		
		StringBuffer sql = new StringBuffer("DELETE FROM TB_STUDENT_COURSE WHERE");
		StringBuffer appendSql = new StringBuffer("");
		if(scNo != null) {
			appendSql.append(" AND SC_NO=?");
		}
		if(tcNo != null) {
			appendSql.append(" AND TC_NO=?");
		}
		if (appendSql.length() > 0) {
			appendSql.replace(0, 4, "");
		}
		sql.append(appendSql);
		int affectColums = 0;
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql.toString());
			int count = 1;
			if(scNo != null) {
				prestat.setLong(count++, scNo);
			}
			if(tcNo != null) {
				prestat.setLong(count++, tcNo);
			}
			
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除学生选课信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}
	/**
	 * 修改学生选课信息
	 * @param sc
	 * @return
	 */
	public int update(StudentCourse sc) {
		StringBuffer sql = new StringBuffer("UPDATE TB_STUDENT_COURSE SET ");
		int affectColums = 0;
		if(sc != null && sc.getScNo() != 0) {
			if(sc.getStuNo() != null) {
				sql.append(" STU_NO=?,");
			}
			if(sc.getTc() != null && sc.getTc().getTcNo() != 0) {
				sql.append(" TC_NO=?,");
			}
			if(sc.getScore() != null && sc.getScore().getScore() != -1f) {
				sql.append(" SCORE=?,");
			}
			sql.append(" WHERE SC_NO=?");
		}
		if(sql.lastIndexOf(",") != -1) {
			sql.replace(sql.lastIndexOf(","), sql.lastIndexOf(",") + 1, "");
		}
		
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql.toString());
			if(sc != null && sc.getScNo() != 0) {
				int count = 1;
				if(sc.getStuNo() != null) {
					prestat.setString(count++, sc.getStuNo());
				}
				if(sc.getTc() != null && sc.getTc().getTcNo() != 0) {
					prestat.setLong(count++, sc.getTc().getTcNo());
				}
				if(sc.getScore() != null && sc.getScore().getScore() != -1f) {
					prestat.setFloat(count++, sc.getScore().getScore());
				}
				prestat.setLong(count++, sc.getScNo());
			}
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("修改学生选课信息失败" + e);
		}finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 查询学生选课信息
	 * @param sc
	 * @param page
	 * @return
	 */
	public List<StudentCourse> select(StudentCourse sc, Page page) {
		StringBuffer sql = new StringBuffer("SELECT SC_NO,STU_NO,TC_NO,SCORE FROM TB_STUDENT_COURSE WHERE 1=1");
		List<StudentCourse> scList = new ArrayList<>();
		if (sc != null) {
			if (sc.getScNo() != 0) {
				sql.append(" AND SC_NO=?");
			}
			if (sc.getStuNo() != null) {
				sql.append(" AND STU_NO=?");
			}
			if (sc.getTc() != null && sc.getTc().getTcNo() != 0) {
				sql.append(" AND TC_NO=?");
			}
			if (sc.getScore() != null && sc.getScore().getScore() > 0) {
				sql.append(" AND SCORE=?");
			}
		}
		if (page != null) {
			sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
					+ (page.getPageSize() + page.getPageStart()));
		}
		System.out.println(sql);
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql.toString());
			if (sc != null) {
				int count = 1;
				if (sc.getScNo() != 0) {
					prestat.setLong(count++, sc.getScNo());
				}
				if (sc.getStuNo() != null) {
					prestat.setString(count++, sc.getStuNo());
				}
				if (sc.getTc() != null && sc.getTc().getTcNo() != 0) {
					prestat.setLong(count++, sc.getTc().getTcNo());
				}
				if (sc.getScore() != null && sc.getScore().getScore() > 0) {
					prestat.setFloat(count++, sc.getScore().getScore());
				}
			}
			rs = prestat.executeQuery();
			scList = rowMapper(rs);
		} catch (SQLException e) {
			System.out.println("查询学生选课信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return scList;
	}

	public List<StudentCourse> rowMapper(ResultSet rs) throws SQLException {
		List<StudentCourse> scList = new ArrayList<>();
		while (rs.next()) {
			StudentCourse sc = new StudentCourse();
			sc.setScNo(rs.getLong("SC_NO"));
			sc.setStuNo(rs.getString("STU_NO"));
			sc.getTc().setTcNo(rs.getLong("TC_NO"));
			sc.getScore().setScore(rs.getFloat("SCORE"));
			scList.add(sc);
		}
		return scList;
	}

}
