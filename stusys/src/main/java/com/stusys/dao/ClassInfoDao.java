package com.stusys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stusys.bean.ClassInfo;
import com.stusys.page.Page;
import com.stusys.util.DBUtil;

/**
 * 
 * @author liwei
 * @time 2018年11月22日下午2:17:12
 * @description 班级信息的增删改查
 */
public class ClassInfoDao {

	private Connection conn;
	private Statement stat;
	private PreparedStatement prestat;
	private ResultSet rs;

	/**
	 * 添加班级信息
	 * 
	 * @param classInfo
	 */
	public int add(ClassInfo classInfo) {
		int affectColums = 0;
		String sql = "INSERT INTO TB_CLASS(CLASS_NO,MAJOR_NO,CLASS_NAME,MONITOR_NO,TEACHER_NO) VALUES(?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, classInfo.getClassNo());
			prestat.setInt(2, classInfo.getMajor().getMajorNo());
			prestat.setString(3, classInfo.getClassName());
			prestat.setString(4, classInfo.getMonitor().getStuNo());
			prestat.setString(5, classInfo.getTeacher().getTeacherNo());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加班级信息失败！" + e);
		} finally {
			DBUtil.close(null, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 删除班级信息
	 * 
	 * @param classNo
	 * @return
	 */
	public int delete(String classNo) {
		int affectColums = 0;
		String sql = "DELETE FROM TB_CLASS WHERE CLASS_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, classNo);
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除班级信息失败！" + e);
		} finally {
			DBUtil.close(null, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 修改班级信息
	 * 
	 * @param classInfo
	 * @return
	 */
	public int update(ClassInfo classInfo) {
		return 0;
	}

	/**
	 * 通过班级属性查找班级信息
	 * @param classInfo
	 * @param page
	 * @return
	 */
	public List<ClassInfo> select(ClassInfo classInfo, Page page) {
		List<ClassInfo> classInfos = new ArrayList<ClassInfo>();
		StringBuffer sql = new StringBuffer(
				"SELECT C.CLASS_NO,C.CLASS_NAME,M.MAJOR_NO,M.MAJOR_NAME,S.STU_NO,S.STU_NAME,T.TEACHER_NO,T.TEACHER_NAME FROM TB_CLASS C"
						+ " LEFT JOIN TB_MAJOR M ON M.MAJOR_NO=C.MAJOR_NO "
						+ " LEFT JOIN TB_STUDENT S ON S.STU_NO=C.MONITOR_NO "
						+ " LEFT JOIN TB_TEACHER T ON T.TEACHER_NO=C.TEACHER_NO " + " WHERE 1=1");
		try {
			if (classInfo != null) {
				if (classInfo.getClassNo() != null) {
					sql.append(" AND C.CLASS_NO='" + classInfo.getClassNo() + "'");
				}
				if (classInfo.getClassName() != null) {
					sql.append(" AND C.CLASS_NAME='" + classInfo.getClassName() + "'");
				}
				if (classInfo.getMajor().getMajorNo() != 0) {
					sql.append(" AND C.MAJOR_NO=" + classInfo.getMajor().getMajorNo());
				}
				if (classInfo.getMonitor().getStuNo() != null) {
					sql.append(" AND C.MONITOR_NO='" + classInfo.getMonitor().getStuNo() + "'");
				}
				if (classInfo.getTeacher().getTeacherNo() != null) {
					sql.append(" AND C.TEACHER_NO='" + classInfo.getTeacher().getTeacherNo() + "'");
				}
			}
			if (page != null) {
				sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
						+ (page.getPageSize() + page.getPageStart()));
			}
			sql.append(" ORDER BY MAJOR_NO, CLASS_NO");

			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql.toString());
			classInfos = rowMapper(rs);
		} catch (SQLException e) {
			System.out.println("查询班级信息失败！" + e);
		}
		return classInfos;
	}
	
	public List<ClassInfo> rowMapper(ResultSet rs) throws SQLException{
		List<ClassInfo> classInfos = new ArrayList<ClassInfo>();
		if(rs != null) {
			while(rs.next()) {
				ClassInfo classInfo = new ClassInfo();
				classInfo.setClassNo(rs.getString("CLASS_NO"));
				classInfo.setClassName(rs.getString("CLASS_NAME"));
				classInfo.getMajor().setMajorNo(rs.getInt("MAJOR_NO"));
				classInfo.getMajor().setMajorName(rs.getString("MAJOR_NAME"));
				classInfo.getMonitor().setStuNo(rs.getString("STU_NO"));
				classInfo.getTeacher().setTeacherNo(rs.getString("TEACHER_NO"));
				classInfo.getTeacher().setTeacherName(rs.getString("TEACHER_NAME"));
				classInfos.add(classInfo);
			}
		}
		return classInfos;
	}

}
