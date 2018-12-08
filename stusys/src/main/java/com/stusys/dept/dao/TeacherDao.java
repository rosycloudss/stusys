package com.stusys.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stusys.dept.bean.Teacher;
import com.stusys.page.Page;
import com.stusys.util.DBUtil;

public class TeacherDao {

	private Connection conn;
	private PreparedStatement prestat;
	private ResultSet rs;

	/**
	 * 添加教师信息
	 * 
	 * @param teacher
	 * @return
	 */
	public int add(Teacher teacher) {
		int affectColums = 0;
		String sql = "INSERT INTO TB_TEACHER(TEACHER_NO,TEACHER_NAME,CREATE_TIME,ROLE,DEPT_NO) VALUES(?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, teacher.getTeacherNo());
			prestat.setString(2, teacher.getTeacherName());
			prestat.setLong(3, teacher.getCreateTime());
			prestat.setInt(4, teacher.getRole());
			prestat.setInt(5, teacher.getDepat().getDeptNo());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加教师信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 通过教师编号删除教师信息
	 * 
	 * @param teacherNo
	 * @return
	 */
	public int delete(String teacherNo) {
		int affectColums = 0;
		String sql = "DELETE FROM TB_TEACHER WHERE TEACHER_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, teacherNo);
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除教师信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 修改教师信息
	 * 
	 * @param teacher
	 * @return
	 */
	public int update(Teacher teacher) {
		int affectColums = 0;
		String sql = "UPDATE TB_TEACHER SET TEACHER_NAME=?,ROLE=?,DEPT_NO=? WHERE TEACHER_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, teacher.getTeacherName());
			prestat.setInt(2, teacher.getRole());
			prestat.setInt(3, teacher.getDepat().getDeptNo());
			prestat.setString(4, teacher.getTeacherNo());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("修改教师信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 查询教师个数
	 * 
	 * @param teacher
	 * @return
	 */
	public int count(Teacher teacher) {
		return select(teacher, null).size();
	}

	/**
	 * 通过
	 * 
	 * @param teacher
	 * @param page
	 * @return
	 */
	public List<Teacher> select(Teacher teacher, Page page) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		StringBuffer sql = new StringBuffer(
				"SELECT TEACHER_NO,TEACHER_NAME,CREATE_TIME,ROLE,DEPT_NO FROM TB_TEACHER WHERE 1=1 ");
		if (teacher != null) {
			if (teacher.getTeacherNo() != null) {
				sql.append(" AND TEACHER_NO=?");
			}
			if (teacher.getTeacherName() != null) {
				sql.append(" AND TEACHER_NAME=?");
			}
			if (teacher.getCreateTime() != 0) {
				sql.append(" AND CREATE_TIME=?");
			}
			if (teacher.getRole() != 0) {
				sql.append(" AND ROLE=?");
			}
			if (teacher.getDepat().getDeptNo() != 0) {
				sql.append(" AND DEPT_NO=?");
			}
		}
		if (page != null) {
			sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
					+ (page.getPageSize() + page.getPageStart()));
		}

		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql.toString());
			if (teacher != null) {
				int count = 1;
				if (teacher.getTeacherNo() != null) {
					prestat.setString(count++, teacher.getTeacherNo());
				}
				if (teacher.getTeacherName() != null) {
					prestat.setString(count++, teacher.getTeacherName());
				}
				if (teacher.getCreateTime() != 0) {
					prestat.setLong(count++, teacher.getCreateTime());
				}
				if (teacher.getRole() != 0) {
					prestat.setInt(count++, teacher.getRole());
				}
				if (teacher.getDepat().getDeptNo() != 0) {
					prestat.setInt(count++, teacher.getDepat().getDeptNo());
				}
			}
			rs = prestat.executeQuery();
			teacherList = rowMapper(rs);
		} catch (SQLException e) {
			System.out.println("查询教师信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return teacherList;
	}

	/**
	 * 查询一个教师信息
	 * 
	 * @param teacher
	 * @return
	 */
	public Teacher selectOne(String teacherNo) {
		Teacher teacher = new Teacher();
		teacher.setTeacherNo(teacherNo);
		List<Teacher> teacherList = select(teacher, null);
		if (!teacherList.isEmpty()) {
			return teacherList.get(0);
		} else {
			return null;
		}
	}

	public List<Teacher> rowMapper(ResultSet rs) throws SQLException {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		while (rs.next()) {
			Teacher teacher = new Teacher();
			teacher.setTeacherNo(rs.getString("TEACHER_NO"));
			teacher.setTeacherName(rs.getString("TEACHER_NAME"));
			teacher.setCreateTime(rs.getLong("CREATE_TIME"));
			teacher.setRole(rs.getInt("ROLE"));
			teacher.getDepat().setDeptNo(rs.getInt("DEPT_NO"));
			teacherList.add(teacher);
		}
		return teacherList;
	}
}
