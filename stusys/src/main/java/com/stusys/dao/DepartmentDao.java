package com.stusys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stusys.bean.Department;
import com.stusys.page.Page;
import com.stusys.util.DBUtil;

/**
 * 
 * @author LIWEI
 * @time 2018年11月28日下午12:47:53
 * @description: 院系dao类
 */
public class DepartmentDao {

	private Connection conn;
	private PreparedStatement prestat;
	private Statement statement;
	private ResultSet rs;

	/**
	 * 添加院系信息
	 * 
	 * @param dept
	 * @return
	 */
	public int add(Department dept) {
		int affectColums = 0;
		String sql = "INSERT INTO TB_DEPT(DEPT_NO,DEPT_NAME,SET_UP_TIME) VALUES(SEQ_APPLY,?,?)";

		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, dept.getDeptName());
			prestat.setString(2, dept.getSetUpTime());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加院系信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}

		return affectColums;
	}

	/**
	 * 删除院系信息
	 * 
	 * @param deptNo
	 * @return
	 */
	public int delete(int deptNo) {
		int affectColums = 0;
		String sql = "DELETE FROM TB_DEPT WHERE DEPT_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setInt(1, deptNo);
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除院系信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}

		return affectColums;
	}

	public List<Department> select(Department dept, Page page) {
		List<Department> deptList = new ArrayList<Department>();
		StringBuffer sql = new StringBuffer("SELECT DEPT_NO,DEPT_NAME,SET_UP_TIME FROM TB_DEPT WHERE 1=1 ");
		if (dept != null) {
			if (dept.getDeptNo() != 0) {
				sql.append(" AND DEPT_NO=" + dept.getDeptNo());
			}

			if (dept.getDeptName() != null) {
				sql.append(" AND DEPT_NAME LIKE '%" + dept.getDeptName() + "%'");
			}
		}
		if (page != null) {
			sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
					+ (page.getPageSize() + page.getPageStart()));
		}
		try {
			conn = DBUtil.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql.toString());
			while (rs.next()) {
				Department department = new Department();
				department.setDeptNo(rs.getInt("DEPT_NO"));
				department.setDeptName(rs.getString("DEPT_NAME"));
				department.setSetUpTime(rs.getString("SET_UP_TIME"));
				deptList.add(department);
			}
		} catch (SQLException e) {
			System.out.println("查询院系信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}

		return deptList;
	}

}
