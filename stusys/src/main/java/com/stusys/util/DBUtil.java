package com.stusys.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据库连接获取和释放工具类
 * 数据库连接池
 * 
 * @author liwei
 * @date 2018年10月12日
 * @time 下午1:30:32
 * @projectName chapter01
 */
public class DBUtil {
	
	// 创建数据源
	private static DataSource dataSource = null;

	static {
		try {
			// 加载dbcpconfig.properties配置文件
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (IOException e) {
			System.out.println("加载dbcpconfig.properties配置文件失败！" + e);
		} catch (Exception e) {
			System.out.println("创建数据源失败！" + e);
		}
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
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
	private static void close(ResultSet rs) {
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
	private static void close(Statement stat) {
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
	private static void close(Connection conn) {
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
