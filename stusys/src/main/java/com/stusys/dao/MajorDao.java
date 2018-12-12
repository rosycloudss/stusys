package com.stusys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stusys.bean.Major;
import com.stusys.page.Page;
import com.stusys.util.DBUtil;

/**
 * 
 * @author liwei
 * @time 2018年11月24日下午7:48:10
 * @description 专业信息的dao层
 */
public class MajorDao {

	private Connection conn;
	private PreparedStatement prestat;
	private ResultSet rs;

	/**
	 * 添加专业信息
	 * 
	 * @param major
	 * @return
	 */
	public int add(Major major) {
		int affectColums = 0;
		String sql = "INSERT INTO TB_MAJOR(MAJOR_NO,MAJOR_NAME,DEPT_NO,CREATE_TIME,LEN_OF_SCHOOL,TYPE,TEACHER_NO) VALUES(?,?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setLong(1, major.getMajorNo());
			prestat.setString(2, major.getMajorName());
			prestat.setInt(3, major.getDept().getDeptNo());
			prestat.setLong(4, major.getCreateTime());
			prestat.setInt(5, major.getLenOfSchool());
			prestat.setString(6, major.getType());
			prestat.setString(7, major.getTeacher().getTeacherNo());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加专业信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 通过专业编号删除专业信息
	 * 
	 * @param majorNo
	 * @return
	 */
	public int delete(long majorNo) {
		int affectColums = 0;
		String sql = "DELETE FROM TB_MAJOR WHERE MAJOR_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setLong(1, majorNo);
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除专业信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 修改专业信息
	 * 
	 * @param major
	 * @return
	 */
	public int update(Major major) {
		int affectColums = 0;
		String sql = "UPDATE TB_MAJOR SET MAJOR_NAME=?,DEPT_NO=?,LEN_OF_SCHOOL=?,TYPE=?,TEACHER_NO=? WHERE MAJOR_NO=? ";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, major.getMajorName());
			prestat.setInt(2, major.getDept().getDeptNo());
			prestat.setInt(3, major.getLenOfSchool());
			prestat.setString(4, major.getType());
			prestat.setString(5, major.getTeacher().getTeacherNo());
			prestat.setLong(6, major.getMajorNo());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("修改" + major + "专业信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	public int select(Major major) {
		return select(major, null).size();
	}

	public List<Major> select(Major major, Page page) {
		List<Major> majorList = new ArrayList<Major>();
		StringBuffer sql = new StringBuffer(
				"SELECT MAJOR_NO,MAJOR_NAME,DEPT_NO,CREATE_TIME,LEN_OF_SCHOOL,TYPE,TEACHER_NO FROM TB_MAJOR WHERE 1=1");
		if (major != null) {
			if (major.getMajorNo() != 0) {
				sql.append(" AND MAJOR_NO=?");
			}
			if (major.getMajorName() != null) {
				sql.append(" AND MAJOR_NAME=?");
			}
			if (major.getDept() != null && major.getDept().getDeptNo() != 0) {
				sql.append(" AND DEPT_NO=?");
			}
			if (major.getCreateTime() != 0) {
				sql.append(" AND CREATE_TIME=?");
			}
			if (major.getLenOfSchool() != 0) {
				sql.append(" AND LEN_OF_SCHOOL=?");
			}
			if (major.getType() != null) {
				sql.append(" AND TYPE=?");
			}
			if (major.getTeacher() != null && major.getTeacher().getTeacherNo() != null) {
				sql.append(" AND TEACHER_NO=?");
			}
		}
		if (page != null) {
			sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
					+ (page.getPageSize() + page.getPageStart()));
		}
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql.toString());
			if (major != null) {
				int count = 1;
				if (major.getMajorNo() != 0) {
					prestat.setInt(count++, major.getMajorNo());
				}
				if (major.getMajorName() != null) {
					prestat.setString(count++, major.getMajorName());
				}
				if (major.getDept() != null && major.getDept().getDeptNo() != 0) {
					prestat.setInt(count++, major.getDept().getDeptNo());
				}
				if (major.getCreateTime() != 0) {
					prestat.setLong(count++, major.getCreateTime());
				}
				if (major.getLenOfSchool() != 0) {
					prestat.setInt(count++, major.getLenOfSchool());
				}
				if (major.getType() != null) {
					prestat.setString(count++, major.getType());
				}
				if (major.getTeacher() != null && major.getTeacher().getTeacherNo() != null) {
					prestat.setString(count++, major.getTeacher().getTeacherNo());
				}
			}
			rs = prestat.executeQuery();
			majorList = rowMapper(rs);
		} catch (SQLException e) {
			System.out.println("查询专业信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return majorList;
	}

	public List<Major> rowMapper(ResultSet rs) throws SQLException {
		List<Major> majorList = new ArrayList<Major>();
		while (rs.next()) {
			Major major = new Major();
			major.setMajorNo(rs.getInt("MAJOR_NO"));
			major.setMajorName(rs.getString("MAJOR_NAME"));
			major.getDept().setDeptNo(rs.getInt("DEPT_NO"));
			major.setCreateTime(rs.getLong("CREATE_TIME"));
			major.setLenOfSchool(rs.getInt("LEN_OF_SCHOOL"));
			major.setType(rs.getString("TYPE"));
			major.getTeacher().setTeacherNo("TEACHER_NO");
			majorList.add(major);
		}
		return majorList;
	}
}
