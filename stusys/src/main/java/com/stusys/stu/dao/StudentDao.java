package com.stusys.stu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stusys.dept.bean.Department;
import com.stusys.dept.bean.Major;
import com.stusys.dept.bean.Teacher;
import com.stusys.page.Page;
import com.stusys.stu.bean.ClassInfo;
import com.stusys.stu.bean.Student;
import com.stusys.util.DBUtil;

public class StudentDao {

	private String baseColumnList = "STU_NO,STU_PASSWORD,STU_NAME,STU_GENDER,STU_BIRTHDAY,STU_IDCARD,MAJOR_NO,STU_ADDRESS,"
			+ "STU_PHONE1,STU_PHONE2,STU_QQ,STU_EMAIL,STU_EDUCATION,STU_ENTER_TIME,STU_STATE,STU_PHOTO_PATH,STU_SALT,CREATE_TIME,CLASS_NO";

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
		String sql = "INSERT INTO TB_STUDENT(" + baseColumnList + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			
			prestat.setString(1, stu.getStuNo());
			prestat.setString(2, stu.getPassword());
			prestat.setString(3, stu.getName());
			prestat.setString(4, stu.getGender());
			prestat.setString(5, stu.getBirthday());
			prestat.setString(6, stu.getIdCard());
			Major major = stu.getMajor();
			prestat.setInt(7, major == null ? 0 : major.getMajorNo());
			
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
			prestat.setString(19, stu.getClassNo());
			System.out.println(stu);
			affectColums = prestat.executeUpdate();
		} catch (Exception e) {
			System.out.println("添加学生" + stu.getStuNo() + "  " + stu.getName() + "失败" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
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
		String sql1 = "UPDATE TB_STUDENT SET STU_PASSWORD=?,STU_NAME=?,STU_GENDER=?,STU_BIRTHDAY=?,STU_IDCARD=?,MAJOR_NO=?,STU_ADDRESS=?,"
				+ "STU_PHONE1=?,STU_PHONE2=?,STU_QQ=?,STU_EMAIL=?,STU_EDUCATION=?,STU_ENTER_TIME=?,STU_STATE=?,STU_PHOTO_PATH=? WHERE STU_NO=?";
		StringBuffer sql = new StringBuffer("UPDATE TB_STUDENT SET ");
		
		
		try {
			
			
			if(stu != null && stu.getStuNo() != null) {
				conn = DBUtil.getConnection();
				if(stu.getPassword() != null) {
					sql.append(" STU_PASSWORD=?,");
				}
				if(stu.getName() != null) {
					sql.append(" STU_NAME=?,");
				}
				if(stu.getGender() != null) {
					sql.append(" STU_GENDER=?,");
				}
				if(stu.getBirthday() != null) {
					sql.append(" STU_BIRTHDAY=?,");
				}
				if(stu.getIdCard() != null) {
					sql.append(" STU_IDCARD=?,");
				}
				if(stu.getMajor() != null && stu.getMajor().getMajorNo() != 0) {
					sql.append(" MAJOR_NO=?,");
				}
				if(stu.getAddress() != null) {
					sql.append(" STU_ADDRESS=?,");
				}
				if(stu.getPhone1() != null) {
					sql.append(" STU_PHONE1=?,");
				}
				if(stu.getPhone2() != null) {
					sql.append(" STU_PHONE2=?,");
				}
				if(stu.getQq() != null) {
					sql.append(" STU_QQ=?,");
				}
				if(stu.getEmail() != null) {
					sql.append(" STU_EMAIL=?,");
				}
				if(stu.getEducation() != null) {
					sql.append(" STU_EDUCATION=?,");
				}
				
				if(stu.getEnterTime() != null) {
					sql.append(" STU_ENTER_TIME=?,");
				}
				if(stu.getState() != null) {
					sql.append(" STU_STATE=?,");
				}
				if(stu.getPhotoPath() != null) {
					sql.append(" STU_PHOTO_PATH=?,");
				}
				sql.append(" WHERE STU_NO=? ");
				sql.replace(sql.lastIndexOf(","), sql.lastIndexOf(",")+1, "");
				prestat = conn.prepareStatement(sql.toString());
				int count = 1;
				if(stu.getPassword() != null) {
					prestat.setString(count++, stu.getPassword());
				}
				if(stu.getName() != null) {
					prestat.setString(count++, stu.getName());
				}
				if(stu.getGender() != null) {
					prestat.setString(count++,stu.getGender());
				}
				if(stu.getBirthday() != null) {
					prestat.setString(count++, stu.getBirthday());
				}
				if(stu.getIdCard() != null) {
					prestat.setString(count++, stu.getIdCard());
				}
				if(stu.getMajor() != null && stu.getMajor().getMajorNo() != 0) {
					prestat.setInt(count++, stu.getMajor().getMajorNo());
				}
				if(stu.getAddress() != null) {
					prestat.setString(count++, stu.getAddress());
				}
				if(stu.getPhone1() != null) {
					prestat.setString(count++, stu.getPhone1());
				}
				if(stu.getPhone2() != null) {
					prestat.setString(count++, stu.getPhone2());
				}
				if(stu.getQq() != null) {
					prestat.setString(count++, stu.getQq());
				}
				if(stu.getEmail() != null) {
					prestat.setString(count++, stu.getEmail());
				}
				if(stu.getEducation() != null) {
					prestat.setString(count++, stu.getEducation());
				}
				
				if(stu.getEnterTime() != null) {
					prestat.setString(count++, stu.getEnterTime());
				}
				if(stu.getState() != null) {
					prestat.setInt(count++, stu.getState());
				}
				if(stu.getPhotoPath() != null) {
					prestat.setString(count++, stu.getPhotoPath());
				}
				prestat.setString(count++, stu.getStuNo());
				
			}
//			prestat.setString(1, stu.getPassword());
//			prestat.setString(2, stu.getName());
//			prestat.setString(3, stu.getGender());
//			prestat.setString(4, stu.getBirthday());
//			prestat.setString(5, stu.getIdCard());
//			Major major = stu.getMajor();
//			prestat.setInt(6, major == null ? 0 : major.getMajorNo());
//			prestat.setString(7, stu.getAddress());
//			prestat.setString(8, stu.getPhone1());
//			prestat.setString(9, stu.getPhone2());
//			prestat.setString(10, stu.getQq());
//			prestat.setString(11, stu.getEmail());
//			prestat.setString(12, stu.getEducation());
//			prestat.setString(13, stu.getEnterTime());
//			prestat.setInt(14, stu.getState());
//			prestat.setString(15, stu.getPhotoPath());
//			prestat.setString(16, stu.getStuNo());
			affectColums = prestat.executeUpdate();
			System.out.println(sql.toString());
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
				if (stu.getMajor() != null && stu.getMajor().getMajorNo() != 0) {
					sql.append(" AND MAJOR_NO=" + stu.getMajor().getMajorNo());
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
		} catch (Exception e) {
			System.out.println("查询学生数量失败！" + e);
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
				"SELECT S.STU_NO,S.STU_PASSWORD,S.STU_NAME,S.STU_GENDER,S.STU_BIRTHDAY,S.STU_IDCARD,S.MAJOR_NO,S.STU_ADDRESS,S.STU_PHONE1,S.STU_PHONE2,"
						+ "S.STU_QQ,S.STU_EMAIL,S.STU_EDUCATION,S.STU_ENTER_TIME,S.STU_STATE,S.STU_PHOTO_PATH,S.STU_SALT,S.CREATE_TIME,S.CLASS_NO,"
						+ "M.MAJOR_NO,M.MAJOR_NAME,M.DEPT_NO,M.CREATE_TIME AS MAJOR_CREATE_TIME,M.LEN_OF_SCHOOL,M.TYPE,M.TEACHER_NO "
						+ " FROM TB_STUDENT S LEFT JOIN TB_MAJOR M ON M.MAJOR_NO=S.MAJOR_NO WHERE 1=1");
		try {
			if (stu != null) {
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
				if (stu.getMajor() != null && stu.getMajor().getMajorNo() != 0) {
					sql.append(" AND S.MAJOR_NO=" + stu.getMajor().getMajorNo());
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
			}
			if (page != null) {
				sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
						+ (page.getPageSize() + page.getPageStart()));
			}

			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			System.out.println(sql.toString());
			rs = stat.executeQuery(sql.toString());
			stuList.addAll(rowIntoStudent(rs));
		} catch (Exception e) {
			System.out.println("查询学生" + stu + "失败！" + e);
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
		Student student = new Student();
		student.setStuNo(stuNo);
		student.setPassword(password);
		return select(student, null);
		
//		List<Student> stuList = new ArrayList<Student>();
//		String sql = "SELECT " + baseColumnList + " FROM TB_STUDENT WHERE STU_NO=? AND STU_PASSWORD=?";
//		try {
//			conn = DBUtil.getConnection();
//			prestat = conn.prepareStatement(sql);
//			prestat.setString(1, stuNo);
//			prestat.setString(2, password);
//			rs = prestat.executeQuery();
//			stuList.addAll(rowIntoStudent(rs));
//		} catch (SQLException e) {
//			System.out.println("通过学号" + stuNo + " 和 密码 " + password + "查询学生信息失败" + e);
//		} finally {
//			DBUtil.close(rs, prestat, conn);
//		}
//		return stuList;
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
			// 设置学生专业信息
			Major major = student.getMajor();
			major.setMajorNo(rs.getInt("MAJOR_NO"));

			Department dept = major.getDept();
			dept.setDeptNo(rs.getInt("DEPT_NO"));
			major.setMajorName(rs.getString("MAJOR_NAME"));
			major.setCreateTime(rs.getLong("MAJOR_CREATE_TIME"));
			major.setLenOfSchool(rs.getInt("LEN_OF_SCHOOL"));
			major.setType(rs.getString("TYPE"));

			Teacher teacher = new Teacher();
			teacher.setTeacherNo(rs.getString("TEACHER_NO"));
			major.setTeacher(teacher);

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
