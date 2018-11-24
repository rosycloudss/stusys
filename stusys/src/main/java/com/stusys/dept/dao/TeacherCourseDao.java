package com.stusys.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stusys.dept.bean.TeacherCourse;
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
	 * @param teacherCourseNo
	 * @return
	 */
	public int delete(long teacherCourseNo) {
		int affectColums = 0;
		
		return affectColums;
	}

}
