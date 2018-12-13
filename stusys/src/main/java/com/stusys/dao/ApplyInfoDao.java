package com.stusys.dao;
/**
 * 
 * @author liwei
 * @time 2018年11月21日下午6:15:41
 * @description 学生申请信息dao层
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stusys.bean.ApplyInfo;
import com.stusys.page.Page;
import com.stusys.util.DBUtil;

public class ApplyInfoDao {

	private Connection conn;
	private Statement stat;
	private PreparedStatement prestat;
	private ResultSet rs;
	private final String baseColumList = "APPLY_NO, STU_NO,HANDLER,HANDLE_TIME,HANDLE_RESULT,"
			+ "STATUS,APPLY_CONTENT,EMAIL,PHONE";

	/**
	 * 添加学生申请信息
	 * 
	 * @param applyInfo
	 * @return
	 */
	public int add(ApplyInfo applyInfo) {
		int affectColums = 0;
		String sql = "INSERT INTO TB_APPLY(" + baseColumList + ") VALUES(SEQ_APPLY,?,?,?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, applyInfo.getStudent().getStuNo());
			prestat.setString(2, applyInfo.getHandler().getTeacherNo());
			prestat.setLong(3, applyInfo.getHandleTime());
			prestat.setString(4, applyInfo.getHandlerResult());
			prestat.setString(5, applyInfo.getStatus());
			prestat.setString(6, applyInfo.getApplyContent());
			prestat.setString(7, applyInfo.getEamil());
			prestat.setString(8, applyInfo.getPhone());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加学生申请失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 删除学生申请信息
	 * 
	 * @param applyNo
	 * @return
	 */
	public int delete(long applyNo) {
		int affectColums = 0;
		String sql = "DELETE FROM TB_APPLY WHERE APPLY_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setLong(1, applyNo);
			prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除学生申请失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 修改学生申请
	 * 
	 * @param applyInfo
	 * @return
	 */
	public int update(ApplyInfo applyInfo) {
		int affectColums = 0;
		String sql = "UPDATE TB_APPLY SET STU_NO=?,HANDLER=?,HANDLE_RESULT=?,STATUS=?,APPLY_CONTENT=?,EMAIL=?,PHONE=? WHERE APPLY_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, applyInfo.getStudent().getStuNo());
			prestat.setString(2, applyInfo.getHandler().getTeacherNo());
			prestat.setLong(3, applyInfo.getHandleTime());
			prestat.setString(4, applyInfo.getHandlerResult());
			prestat.setString(5, applyInfo.getStatus());
			prestat.setString(6, applyInfo.getApplyContent());
			prestat.setString(7, applyInfo.getEamil());
			prestat.setString(8, applyInfo.getPhone());
			prestat.setLong(9, applyInfo.getApplyNo());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("修改学生申请信息" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 根据学生申请信息的属性查找学生申请信息
	 * 
	 * @param applyInfo
	 * @param page
	 * @return
	 */
	public List<ApplyInfo> select(ApplyInfo applyInfo, Page page) {
		List<ApplyInfo> applyInfos = new ArrayList<ApplyInfo>();

		StringBuffer sql = new StringBuffer(
				"SELECT A.APPLY_NO,A.HANDLE_TIME,A.HANDLE_RESULT,A.STATUS,A.APPLY_CONTENT,A.EMAIL,"
						+ "A.PHONE,S.STU_NO,S.STU_NAME,T.TEACHER_NO,T.TEACHER_NAME FROM TB_APPLY A "
						+ " LEFT JOIN TB_STUDENT S ON S.STU_NO=A.STU_NO "
						+ " LEFT JOIN TB_TEACHER T ON T.TEACHER_NO=A.HANDLER WHERE 1=1");
		if (applyInfo != null) {
			if (applyInfo.getApplyNo() != 0) {
				sql.append(" AND A.APPLY_NO=" + applyInfo.getApplyNo());
			}
			if (applyInfo.getStudent().getStuNo() != null) {
				sql.append(" AND A.STU_NO='" + applyInfo.getStudent().getStuNo() + "'");
			}
			if (applyInfo.getHandler().getTeacherNo() != null) {
				sql.append(" AND A.HANDLER='" + applyInfo.getHandler().getTeacherNo() + "'");
			}
			if (applyInfo.getHandleTime() != 0) {
				sql.append(" AND A.HANDLE_TIME='" + applyInfo.getHandleTime() + "'");
			}
			if (applyInfo.getStatus() != null) {
				sql.append(" AND A.STATUS='" + applyInfo.getStatus() + "'");
			}
			if (applyInfo.getApplyContent() != null) {
				sql.append(" AND A.APPLY_CONTENT LIKE '%" + applyInfo.getApplyContent() + "%'");
			}
			if (applyInfo.getEamil() != null) {
				sql.append(" AND A.EMAIL='" + applyInfo.getEamil() + "'");
			}
			if (applyInfo.getPhone() != null) {
				sql.append(" AND A.PHONE='" + applyInfo.getPhone() + "'");
			}
		}
		if (page != null) {
			sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
					+ (page.getPageSize() + page.getPageStart()));
		}
		sql.append(" ORDER BY STATUS, APPLY_NO, STU_NO");
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql.toString());
			applyInfos = rowMapper(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询学生申请信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return applyInfos;
	}

	/**
	 * 将rs 转换为ApplyInfo 对象
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<ApplyInfo> rowMapper(ResultSet rs) throws SQLException {
		List<ApplyInfo> applyInfos = new ArrayList<ApplyInfo>();
		if (rs != null) {
			while (rs.next()) {
				ApplyInfo applyInfo = new ApplyInfo();
				applyInfo.setApplyNo(rs.getLong("APPLY_NO"));
				applyInfo.getStudent().setStuNo(rs.getString("STU_NO"));
				applyInfo.getStudent().setName(rs.getString("STU_NAME"));
				applyInfo.getHandler().setTeacherNo(rs.getString("TEACHER_NO"));
				applyInfo.getHandler().setTeacherName(rs.getString("TEACHER_NAME"));
				applyInfo.setHandleTime(rs.getLong("HANDLE_TIME"));
				applyInfo.setHandlerResult(rs.getString("HANDLE_RESULT"));
				applyInfo.setStatus(rs.getString("STATUS"));
				applyInfo.setApplyContent(rs.getString("APPLY_CONTENT"));
				applyInfo.setEamil(rs.getString("EAMIL"));
				applyInfo.setPhone(rs.getString("PHONE"));
				applyInfos.add(applyInfo);
			}
		}
		return applyInfos;
	}
}
