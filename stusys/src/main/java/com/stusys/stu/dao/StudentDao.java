package com.stusys.stu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stusys.page.Page;
import com.stusys.stu.bean.Student;
import com.stusys.util.DBUtil;

public class StudentDao {

	private String baseColumnList = "STU_NO,STU_PASSWORD,STU_NAME,STU_GENDER,STU_BIRTHDAY,STU_IDCARD,MAJOR_ID,STU_ADDRESS,"
			+ "STU_PHONE1,STU_PHONE2,STU_QQ,STU_EMAIL,STU_EDUCATION,STU_ENTER_TIME,STU_STATE,STU_PHOTO_PATH,STU_SALT,CREATE_TIME";

	private Connection conn;
	private Statement stat;
	private PreparedStatement prestat;
	private ResultSet rs;

	/**
	 * 添加学生信息
	 * 
	 * @param stu
	 * @return
	 */
	public int add(Student stu) {
		int affectColums = 0;
		String sql = "INSERT INTO TB_STUDENT(" + baseColumnList + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, stu.getStuNo());
			prestat.setString(2, stu.getPassword());
			prestat.setString(3, stu.getName());
			prestat.setString(4, stu.getGender());
			prestat.setString(5, stu.getBirthday());
			prestat.setString(6, stu.getIdCard());
			prestat.setInt(7, stu.getMajorId());
			prestat.setString(8, stu.getAddress());
			prestat.setString(9, stu.getPhone1());
			prestat.setString(10, stu.getPhone2());
			prestat.setString(11, stu.getQq());
			prestat.setString(12, stu.getEmail());
			prestat.setString(13, stu.getEducation());
			prestat.setString(14, stu.getEnterTime());
			prestat.setInt(15, stu.getState());
			prestat.setString(16, stu.getPhotoPath());
			prestat.setString(17, stu.getSalt());
			prestat.setLong(18, stu.getCreateTime());
			affectColums = prestat.executeUpdate();

		} catch (SQLException e) {
			System.out.println("添加学生" + stu.getStuNo() + "  " + stu.getName() + "失败" + e);
		} catch (NullPointerException e) {
			System.out.println("学生信息不能为空！" + e);
		} finally {
			DBUtil.close(null, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 通过学号删除学生信息
	 * 
	 * @param stuNo
	 * @return
	 */
	public int delte(String stuNo) {
		int affectColums = 0;
		String sql = "DELETE FROM TB_STUDENT WHERE STU_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, stuNo);
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除学生" + stuNo + "失败！" + e);
		} finally {
			DBUtil.close(null, stat, conn);
		}
		return affectColums;
	}

	/**
	 * 修改学生信息
	 * 
	 * @param stu
	 * @return
	 */
	public int update(Student stu) {
		int affectColums = 0;
//		StringBuffer sql = new StringBuffer("UPDATE TB_STUDENT SET ");
		String sql = "UPDATE TB_STUDENT SET STU_PASSWORD=?,STU_NAME=?,STU_GENDER=?,STU_BIRTHDAY=?,STU_IDCARD=?,MAJOR_ID=?,STU_ADDRESS=?,"
				+ "STU_PHONE1=?,STU_PHONE2=?,STU_QQ=?,STU_EMAIL=?,STU_EDUCATION=?,STU_ENTER_TIME=?,STU_STATE=?,STU_PHOTO_PATH=? WHERE STU_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, stu.getPassword());
			prestat.setString(2, stu.getName());
			prestat.setString(3, stu.getGender());
			prestat.setString(4, stu.getBirthday());
			prestat.setString(5, stu.getIdCard());
			prestat.setInt(6, stu.getMajorId());
			prestat.setString(7, stu.getAddress());
			prestat.setString(8, stu.getPhone1());
			prestat.setString(9, stu.getPhone2());
			prestat.setString(10, stu.getQq());
			prestat.setString(11, stu.getEmail());
			prestat.setString(12, stu.getEducation());
			prestat.setString(13, stu.getEnterTime());
			prestat.setInt(14, stu.getState());
			prestat.setString(15, stu.getPhotoPath());
			prestat.setString(16, stu.getStuNo());
			affectColums = prestat.executeUpdate();
			System.out.println(sql.toString());
		} catch (SQLException e) {
			System.out.println("修改学生+" + stu.getStuNo() + "失败！" + e);
		} catch (NullPointerException e) {
			System.out.println("学生信息不能为空！" + e);
		} catch (Exception e) {
			System.out.println("修改学生信息失败！" + e);
		} finally {
			DBUtil.close(null, stat, conn);
		}
		return affectColums;
	}

	/**
	 * 计数
	 * 
	 * @param stu
	 * @return
	 */
	public int count(Student stu) {
		int count = 0;
		StringBuffer sql = new StringBuffer("SELECT COUNT(STU_NO) STU_COUNT FROM TB_STUDENT WHERE 1=1 ");
		try {
			if (stu != null) {
				if (stu.getStuNo() != null) {
					sql.append(" AND STU_NO='" + stu.getStuNo() + "'");
				}
				if (stu.getPassword() != null) {
					sql.append(" AND STU_PASSWORD='" + stu.getPassword() + "'");
				}
				if (stu.getName() != null) {
					sql.append(" AND STU_NAME LIKE '%" + stu.getName() + "%'");
				}
				if (stu.getGender() != null) {
					sql.append(" AND STU_GENDER='" + stu.getGender() + "'");
				}
				if (stu.getIdCard() != null) {
					sql.append(" AND STU_IDCARD='" + stu.getIdCard() + "'");
				}
				if (stu.getMajorId() != null) {
					sql.append(" AND MAJOR_ID=" + stu.getMajorId());
				}
				if (stu.getAddress() != null) {
					sql.append(" AND STU_ADDRESS LIKE '%" + stu.getAddress() + "%'");
				}
				if (stu.getPhone1() != null) {
					sql.append(" AND STU_PHONE1='" + stu.getPhone1() + "'");
				}
				if (stu.getPhone2() != null) {
					sql.append(" AND STU_PHONE2='" + stu.getPhone2() + "'");
				}
				if (stu.getQq() != null) {
					sql.append(" AND STU_QQ='" + stu.getQq() + "'");
				}
				if (stu.getEmail() != null) {
					sql.append(" AND STU_EMAIL='" + stu.getEmail() + "'");
				}
				if (stu.getEducation() != null) {
					sql.append(" AND STU_EDUCATION='" + stu.getEducation() + "'");
				}
				if (stu.getEnterTime() != null) {
					sql.append(" AND STU_ENTER_TIME='" + stu.getEnterTime() + "'");
				}
				if (stu.getBirthday() != null) {
					sql.append(" AND STU_BIRTHDAY='" + stu.getBirthday() + "'");
				}
				if (stu.getState() != null) {
					sql.append(" AND STU_STATE='" + stu.getState() + "'");
				}
				if (stu.getPhotoPath() != null) {
					sql.append(" AND STU_PHOTO_PATH='" + stu.getPhotoPath() + "'");
				}
			}
			System.out.println(sql.toString());
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql.toString());
			while (rs.next()) {
				count = rs.getInt("STU_COUNT");
			}
		} catch (SQLException e) {
			System.out.println("查询学生数量失败！" + e);
		} catch (NullPointerException e) {
			System.out.println("学生信息不能为空！" + e);
		} finally {
			DBUtil.close(rs, stat, conn);
		}
		return count;
	}

	/**
	 * 通过学生属性查询学生信息
	 * 
	 * @param stu
	 * @return
	 */
	public List<Student> select(Student stu, Page page) {
		List<Student> stuList = new ArrayList<Student>();
		//
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM (SELECT " + baseColumnList + ",ROWNUM RN FROM TB_STUDENT) N  WHERE 1=1 ");
		try {
			if (stu.getStuNo() != null) {
				sql.append(" AND STU_NO='" + stu.getStuNo() + "'");
			}
			if (stu.getPassword() != null) {
				sql.append(" AND STU_PASSWORD='" + stu.getPassword() + "'");
			}
			if (stu.getName() != null) {
				sql.append(" AND STU_NAME='" + stu.getName() + "'");
			}
			if (stu.getGender() != null) {
				sql.append(" AND STU_GENDER='" + stu.getGender() + "'");
			}
			if (stu.getIdCard() != null) {
				sql.append(" AND STU_IDCARD='" + stu.getIdCard() + "'");
			}
			if (stu.getMajorId() != null) {
				sql.append(" AND MAJOR_ID=" + stu.getMajorId());
			}
			if (stu.getAddress() != null) {
				sql.append(" AND STU_ADDRESS='" + stu.getAddress() + "'");
			}
			if (stu.getPhone1() != null) {
				sql.append(" AND STU_PHONE1='" + stu.getPhone1() + "'");
			}
			if (stu.getPhone2() != null) {
				sql.append(" AND STU_PHONE2='" + stu.getPhone2() + "'");
			}
			if (stu.getQq() != null) {
				sql.append(" AND STU_QQ='" + stu.getQq() + "'");
			}
			if (stu.getEmail() != null) {
				sql.append(" AND STU_EMAIL='" + stu.getEmail() + "'");
			}
			if (stu.getEducation() != null) {
				sql.append(" AND STU_EDUCATION='" + stu.getEducation() + "'");
			}
			if (stu.getEnterTime() != null) {
				sql.append(" AND STU_ENTER_TIME='" + stu.getEnterTime() + "'");
			}
			if (stu.getBirthday() != null) {
				sql.append(" AND STU_BIRTHDAY='" + stu.getBirthday() + "'");
			}
			if (stu.getState() != null) {
				sql.append(" AND STU_STATE='" + stu.getState() + "'");
			}
			if (stu.getPhotoPath() != null) {
				sql.append(" AND STU_PHOTO_PATH='" + stu.getPhotoPath() + "'");
			}

			if (page != null) {
				sql.append(" AND N.RN>=" + page.getPageStart() + " AND N.RN<"
						+ (page.getPageSize() + page.getPageStart()));
			}

			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			System.out.println(sql.toString());
			rs = stat.executeQuery(sql.toString());
			stuList.addAll(rowIntoStudent(rs));
		} catch (SQLException e) {
			System.out.println("查询学生" + stu + "失败！" + e);
		} catch (NullPointerException e) {
			System.out.println("学生信息不能为空！" + e);
		} finally {
			DBUtil.close(rs, stat, conn);
		}
		return stuList;
	}

	/**
	 * 通过学生学号和密码查询学生信息
	 * 
	 * @param stuNo
	 * @param password
	 */
	public List<Student> select(String stuNo, String password) {
		List<Student> stuList = new ArrayList<Student>();
		String sql = "SELECT " + baseColumnList + " FROM TB_STUDENT WHERE STU_NO=? AND STU_PASSWORD=?";

		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, stuNo);
			prestat.setString(2, password);
			rs = prestat.executeQuery();
			stuList.addAll(rowIntoStudent(rs));
		} catch (SQLException e) {
			System.out.println("通过学号" + stuNo + " 和 密码 " + password + "查询学生信息失败");
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return stuList;

	}

	/**
	 * 将rs 中的学生信息转化为Student对象数组
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public List<Student> rowIntoStudent(ResultSet rs) throws SQLException {
		List<Student> stuList = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setStuNo(rs.getString("STU_NO"));
			student.setName(rs.getString("STU_NAME"));
			student.setPassword(rs.getString("STU_PASSWORD"));
			student.setGender(rs.getString("STU_GENDER"));
			student.setBirthday(rs.getString("STU_BIRTHDAY"));
			student.setIdCard(rs.getString("STU_IDCARD"));
			student.setMajorId(rs.getInt("MAJOR_ID"));
			student.setAddress(rs.getString("STU_ADDRESS"));
			student.setPhone1(rs.getString("STU_PHONE1"));
			student.setPhone2(rs.getString("STU_PHONE2"));
			student.setQq(rs.getString("STU_QQ"));
			student.setEmail(rs.getString("STU_EMAIL"));
			student.setEducation(rs.getString("STU_EDUCATION"));
			student.setEnterTime(rs.getString("STU_ENTER_TIME"));
			student.setState(rs.getInt("STU_STATE"));
			student.setPhotoPath(rs.getString("STU_PHOTO_PATH"));
			student.setSalt(rs.getString("STU_SALT"));
			student.setCreateTime(rs.getLong("CREATE_TIME"));
			stuList.add(student);
		}
		return stuList;
	}

}
