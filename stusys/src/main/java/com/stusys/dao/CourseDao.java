package com.stusys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stusys.bean.Course;
import com.stusys.bean.Major;
import com.stusys.page.Page;
import com.stusys.util.DBUtil;

/**
 * 
 * @author liwei
 * @time 2018年11月24日上午12:04:50
 * @description 课程dao类
 */
public class CourseDao {

	private Connection conn;
	private PreparedStatement prestat;
	private ResultSet rs;

	/**
	 * 添加课程信息
	 * 
	 * @param course
	 * @return
	 */
	public int add(Course course) {
		int affectColums = 0;
		String sql = "INSERT INTO TB_COURSE(COURSE_NO,COURSE_NAME,COURSE_DESCRIPTION,MAJOR_NO,CREDIT,CLASS_HOUR,COURSE_TYPE) VALUES(SEQ_COURSE.nextval,?,?,?,?,?,?) ";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);

//			prestat.setLong(1, course.getCourseNo());
			prestat.setString(1, course.getCourseName());
			prestat.setString(2, course.getCourseDescription());
			prestat.setInt(3, course.getMajor().getMajorNo());
			prestat.setFloat(4, course.getCredt());
			prestat.setInt(5, course.getClassHour());
			prestat.setString(6, course.getCourseType());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加课程信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 通过课程编号删除课程信息
	 * 
	 * @param courseNo
	 * @return
	 */
	public int delete(long courseNo) {
		int affectColums = 0;
		String sql = "DELETE FROM TB_COURSE WHERE COURSE_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setLong(1, courseNo);
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除课程信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 修改课程信息
	 * 
	 * @param course
	 * @return
	 */
	public int update(Course course) {
		int affectColums = 0;
		String sql1 = "UPDATE TB_COURSE SET COURSE_NAME=?,COURSE_DESCRIPTION=?,MAJOR_NO=?,CREDIT=?,CLASS_HOUR=?,COURSE_TYPE=? WHERE COURSE_NO=? ";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql1);
			prestat.setString(1, course.getCourseName());
			prestat.setString(2, course.getCourseDescription());
			prestat.setInt(3, course.getMajor().getMajorNo());
			prestat.setFloat(4, course.getCredt());
			prestat.setInt(5, course.getClassHour());
			prestat.setString(6, course.getCourseType());
			prestat.setLong(7, course.getCourseNo());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("修改课程信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 查询课程个数
	 * 
	 * @param course
	 * @return
	 */
	public int count(Course course) {
		return select(course, null).size();
	}

	/**
	 * 通过课程属性查找课程信息
	 * 
	 * @param course
	 * @param page
	 * @return
	 */
//	public List<Course> select(Course course, Page page) {
//		List<Course> courseList = new ArrayList<Course>();
//		StringBuffer sql = new StringBuffer(
//				"SELECT C.COURSE_NO,C.COURSE_NAME,C.COURSE_DESCRIPTION,C.CREDIT,C.CLASS_HOUR,C.COURSE_TYPE, M.MAJOR_NO,M.MAJOR_NAME FROM TB_COURSE C "
//						+ " LEFT JOIN TB_MAJOR M ON C.MAJOR_NO=M.MAJOR_NO WHERE 1=1 ");
//		
////		StringBuffer sql = new StringBuffer("SELECT COURSE_NO,COURSE_NAME,COURSE_DESCRIPTION,MAJOR_NO,CREDIT,CLASS_HOUR,COURSE_TYPE FROM TB_COURSE WHERE 1=1");
//		try {
//			if (course != null) {
//				if (course.getCourseNo() != 0) {
//					sql.append(" AND C.COURSE_NO=?");
//				}
//				if (course.getCourseName() != null) {
//					sql.append(" AND C.COUSE_NAME=?");
//				}
//				if (course.getCourseDescription() != null) {
//					sql.append(" AND C.COURSE_DESCRIPTION=?");
//				}
//				if (course.getMajor() != null && course.getMajor().getMajorNo() != 0) {
//					sql.append(" AND C.MAJOR_NO=?");
//
//				}
//				if (course.getCredt() != 0f) {
//					sql.append(" AND C.CREDIT=?");
//				}
//
//				if (course.getClassHour() != 0) {
//					sql.append(" AND C.CLASS_HOUR=?");
//				}
//				if (course.getCourseType() != null) {
//					sql.append(" AND C.COURSE_TYPE=?");
//				}
//			}
//			if (page != null) {
//				sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
//						+ (page.getPageSize() + page.getPageStart()));
//			}
//			
//			conn = DBUtil.getConnection();
//			prestat = conn.prepareStatement(sql.toString());
//			if (course != null) {
//				int preCount = 1;
//				if (course.getCourseNo() != 0) {
//					prestat.setLong(preCount++, course.getCourseNo());
//				}
//				if (course.getCourseName() != null) {
//					prestat.setString(preCount++, course.getCourseName());
//				}
//				if (course.getCourseDescription() != null) {
//					prestat.setString(preCount++, course.getCourseDescription());
//				}
//				if (course.getMajor().getMajorNo() != 0) {
//					prestat.setInt(preCount++, course.getMajor().getMajorNo());
//
//				}
//				if (course.getCredt() != 0f) {
//					prestat.setFloat(preCount++, course.getCredt());
//				}
//
//				if (course.getClassHour() != 0) {
//					prestat.setInt(preCount++, course.getClassHour());
//				}
//				if (course.getCourseType() != null) {
//					prestat.setString(preCount++, course.getCourseType());
//				}
//
//			}
//			rs = prestat.executeQuery();
//			
//			courseList = rowMapper(rs);
//		} catch (SQLException e) {
//			System.out.println("查询课程信息失败！");
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(rs, prestat, conn);
//		}
//		return courseList;
//	}

	/**
	 * 查询课程信息
	 * @param course
	 * @param page
	 * @return
	 */
	public List<Course> select(Course course, Page page){
		List<Course> courseList = new ArrayList<Course>();
		StringBuffer sql = new StringBuffer("SELECT COURSE_NO,COURSE_NAME,COURSE_DESCRIPTION,MAJOR_NO,CREDIT,CLASS_HOUR,COURSE_TYPE,COURSE_LOCK FROM TB_COURSE WHERE 1=1 ");
		try {
			if (course != null) {
				if (course.getCourseNo() != 0) {
					sql.append(" AND COURSE_NO=?");
				}
				if (course.getCourseName() != null) {
					sql.append(" AND COUSE_NAME=?");
				}
				if (course.getCourseDescription() != null) {
					sql.append(" AND COURSE_DESCRIPTION=?");
				}
				if (course.getMajor() != null && course.getMajor().getMajorNo() != 0) {
					sql.append(" AND MAJOR_NO=?");

				}
				if (course.getCredt() != 0f) {
					sql.append(" AND CREDIT=?");
				}

				if (course.getClassHour() != 0) {
					sql.append(" AND CLASS_HOUR=?");
				}
				if (course.getCourseType() != null) {
					sql.append(" AND COURSE_TYPE=?");
				}
				sql.append(" AND COURSE_LOCK=0");
			}
			if (page != null) {
				sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
						+ (page.getPageSize() + page.getPageStart()));
			}
			
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql.toString());
			if (course != null) {
				int preCount = 1;
				if (course.getCourseNo() != 0) {
					prestat.setLong(preCount++, course.getCourseNo());
				}
				if (course.getCourseName() != null) {
					prestat.setString(preCount++, course.getCourseName());
				}
				if (course.getCourseDescription() != null) {
					prestat.setString(preCount++, course.getCourseDescription());
				}
				if (course.getMajor().getMajorNo() != 0) {
					prestat.setInt(preCount++, course.getMajor().getMajorNo());

				}
				if (course.getCredt() != 0f) {
					prestat.setFloat(preCount++, course.getCredt());
				}

				if (course.getClassHour() != 0) {
					prestat.setInt(preCount++, course.getClassHour());
				}
				if (course.getCourseType() != null) {
					prestat.setString(preCount++, course.getCourseType());
				}

			}
			rs = prestat.executeQuery();
			courseList = rowMapper(rs);
		} catch (SQLException e) {
			System.out.println("查询课程信息失败！");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return courseList;
	}
	/**
	 * 查询单个课程信息
	 * 
	 * @param courseNo
	 * @return
	 */
	public Course selectOne(long courseNo) {
		Course course = new Course();
		course.setCourseNo(courseNo);
		List<Course> courseList = select(course, null);
		if (!courseList.isEmpty()) {
			return courseList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public List<Course> rowMapper(ResultSet rs) throws SQLException {
		List<Course> courseList = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setCourseNo(rs.getLong("COURSE_NO"));
			course.setCourseName(rs.getString("COURSE_NAME"));
			course.setCourseDescription(rs.getString("COURSE_DESCRIPTION"));
			if(rs.getInt("MAJOR_NO") != 0) {
				Major major = new Major();
				major.setMajorNo(rs.getInt("MAJOR_NO"));
				course.setMajor(major);
			}
			course.setCredt(rs.getFloat("CREDIT"));
			course.setClassHour(rs.getInt("CLASS_HOUR"));
			course.setCourseType(rs.getString("COURSE_TYPE"));
			courseList.add(course);
		}
		return courseList;
	}

}
