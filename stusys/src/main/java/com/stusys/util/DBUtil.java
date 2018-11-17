package com.stusys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接获取和释放工具类
 * 
 * @author liwei
 * @date 2018年10月12日
 * @time 下午1:30:32
 * @projectName chapter01
 */
public class DBUtil {
	// 数据库实例用户名
	static String user = "scott";
	// 数据库实例密码
	static String password = "1759840027";
	// 数据库实例连接地址
	static String url = "jdbc:oracle:thin:@123.207.171.28:1521:stusys";
	// 数据库驱动
	static String driver = "oracle.jdbc.driver.OracleDriver";

	static {
		try {
			Class.forName(driver);// 加载数据库驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		close(rs);
		close(stat);
		close(conn);
	}

	/**
	 * 关闭 ResultSet
	 * 
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭 Statement
	 * 
	 * @param stat
	 */
	public static void close(Statement stat) {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭 Connection
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
