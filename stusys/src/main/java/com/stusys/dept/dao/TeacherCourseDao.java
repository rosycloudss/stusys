package com.stusys.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stusys.dept.bean.TeacherCourse;
import com.stusys.page.Page;
import com.stusys.util.DBUtil;

/**
 * 
 * @author liwei
 * @time 2018年11月24日下午2:46:41
 * @description 教师选课信息的dao层
 */
public class TeacherCourseDao {

	private Connection conn;
	private PreparedStatement prestat;
	private ResultSet rs;



	/**
	 * 添加教师授课信息
	 * 
	 * @param teaCourse
	 * @return
	 */
	public int add(TeacherCourse teaCourse) {
		int affectColums = 0;
		String sql = "INSERT INTO TB_TEACHER_COURSE(TC_NO,COURSE_NO,TEACHER_NO,SEMESTER,TEACH_ADDRESS_TIME,STUDENT_NUM,SELECT_NUM) VALUES(SEQ_TC,?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setLong(1, teaCourse.getCourse().getCourseNo());
			prestat.setString(2, teaCourse.getTeacher().getTeacherNo());
			prestat.setString(3, teaCourse.getSemester());
			prestat.setString(4, teaCourse.getTeachAddressTime());
			prestat.setInt(5, teaCourse.getStudentNum());
			prestat.setInt(6, teaCourse.getSelectNum());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加教师授课信息失败");
		} finally {
			DBUtil.close(null, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 删除教师授课信息
	 * 
	 * @param teacherCourseNo
	 * @return
	 */
	public int delete(Long teacherCourseNo, String teacherNo, Long courseNo) {
		if (teacherCourseNo == null && teacherNo == null && courseNo == null) {
			return 0;
		}
		int affectColums = 0;
		StringBuffer sql = new StringBuffer("DELETE FROM TB_TEACHER_COURSE WHERE ");
		StringBuffer appendSql = new StringBuffer("");
		if (teacherCourseNo != null) {
			appendSql.append(" AND TC_NO=?");
		}
		if (teacherNo != null) {
			appendSql.append(" AND TEACHER_NO=?");
		}
		if (courseNo != null) {
			appendSql.append(" AND COURSE_NO=?");
		}
		if (appendSql.length() > 0) {
			appendSql.replace(0, 4, "");
		}
		sql.append(appendSql);
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql.toString());
			int count = 1;
			if (teacherCourseNo != null) {
				prestat.setLong(count++, teacherCourseNo);
			}
			if (teacherNo != null) {
				prestat.setString(count++, teacherNo);
			}
			if (courseNo != null) {
				prestat.setLong(count++, courseNo);
			}
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("删除教师讲课信息失败" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 修改教师授课信息
	 * 
	 * @param teaCourse
	 * @return
	 */
	public int update(TeacherCourse teaCourse) {
		int affectColums = 0;
		String sql = "UPDATE SET TB_TEACHER_COURSE SET COURSE_NO=?,TEACHER_NO=?,SEMESTER=?,TEACH_ADDRESS_TIME=?,STUDENT_NUM=?,SELECT_NUM=? WHERE TC_NO=?";
		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql);
			prestat.setLong(1, teaCourse.getCourse().getCourseNo());
			prestat.setString(2, teaCourse.getTeacher().getTeacherNo());
			prestat.setString(3, teaCourse.getSemester());
			prestat.setString(4, teaCourse.getTeachAddressTime());
			prestat.setInt(5, teaCourse.getStudentNum());
			prestat.setInt(6, teaCourse.getSelectNum());
			prestat.setLong(7, teaCourse.getTcNo());
			affectColums = prestat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("修改教师讲课信息失败！" + e);
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return affectColums;
	}

	/**
	 * 查询教师授课信息个数
	 * @param teaCourse
	 * @return
	 */
	public int count(TeacherCourse teaCourse) {
		return select(teaCourse, null).size();
	}
	public List<TeacherCourse> select(TeacherCourse teaCourse, Page page) {
		List<TeacherCourse> teacherCourseList = new ArrayList<TeacherCourse>();
		StringBuffer sql = new StringBuffer(
				"SELECT TC_NO,COURSE_NO,TEACHER_NO,SEMESTER,TEACH_ADDRESS_TIME,STUDENT_NUM,SELECT_NUM FROM TB_TEACHER_COURSE WHERE 1=1 ");
		if (teaCourse != null) {
			if (teaCourse.getTcNo() != 0) {
				sql.append(" AND TC_NO=?");
			}
			if (teaCourse.getCourse().getCourseNo() != 0) {
				sql.append(" AND COURSE_NO=?");
			}
			if (teaCourse.getTeacher().getTeacherNo() != null) {
				sql.append(" AND TEACHER_NO=?");
			}
			if (teaCourse.getSemester() != null) {
				sql.append(" AND SEMESTER=?");
			}
			if (teaCourse.getTeachAddressTime() != null) {
				sql.append(" AND TEACH_ADDRESS_TIME=?");
			}
			if (teaCourse.getStudentNum() != -1) {
				sql.append(" AND STUDENT_NUM=?");
			}
			if (teaCourse.getSelectNum() != -1) {
				sql.append(" AND SELECT_NUM=?");
			}
		}
		if (page != null) {
			sql.append(" AND ROWNUM>=" + page.getPageStart() + " AND ROWNUM<"
					+ (page.getPageSize() + page.getPageStart()));
		}

		try {
			conn = DBUtil.getConnection();
			prestat = conn.prepareStatement(sql.toString());
			if (teaCourse != null) {
				int count = 1;
				if (teaCourse.getTcNo() != 0) {
					prestat.setLong(count++, teaCourse.getTcNo());
				}
				if (teaCourse.getCourse().getCourseNo() != 0) {
					prestat.setLong(count++, teaCourse.getCourse().getCourseNo());
				}
				if (teaCourse.getTeacher().getTeacherNo() != null) {
					prestat.setString(count++, teaCourse.getTeacher().getTeacherNo());
				}
				if (teaCourse.getSemester() != null) {
					prestat.setString(count++, teaCourse.getSemester());
				}
				if (teaCourse.getTeachAddressTime() != null) {
					prestat.setString(count++, teaCourse.getTeachAddressTime());
				}
				if (teaCourse.getStudentNum() != -1) {
					prestat.setInt(count++, teaCourse.getStudentNum());
				}
				if (teaCourse.getSelectNum() != -1) {
					prestat.setInt(count++, teaCourse.getSelectNum());
				}
			}
			rs = prestat.executeQuery();
			teacherCourseList = rowMapper(rs);
		} catch (SQLException e) {
			System.out.println("查询教师教授信息失败");
		} finally {
			DBUtil.close(rs, prestat, conn);
		}
		return teacherCourseList;
	}

	public List<TeacherCourse> rowMapper(ResultSet rs) throws SQLException {
		List<TeacherCourse> teacherCourseList = new ArrayList<TeacherCourse>();
		while (rs.next()) {
			TeacherCourse teacherCourse = new TeacherCourse();
			teacherCourse.setTcNo(rs.getLong("TC_NO"));
			teacherCourse.getCourse().setCourseNo(rs.getLong("COURSE_NO"));
			teacherCourse.getTeacher().setTeacherNo(rs.getString("TEACHER_NO"));
			teacherCourse.setSemester(rs.getString("SEMESTER"));
			teacherCourse.setTeachAddressTime(rs.getString("TEACH_ADDRESS_TIME"));
			teacherCourse.setStudentNum(rs.getInt("STUDENT_NUM"));
			teacherCourse.setSelectNum(rs.getInt("SELECT_NUM"));
			teacherCourseList.add(teacherCourse);
		}
		return teacherCourseList;
	}

}
