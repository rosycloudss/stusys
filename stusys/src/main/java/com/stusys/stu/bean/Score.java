package com.stusys.stu.bean;

import com.stusys.dept.bean.Course;

public class Score {
	private long scoreNo;// 成绩编号
	private Course course = new Course();// 课程信息
	private float score;// 分数
	private float gradePoint = -1f;// 绩点

	/**
	 * @return the scoreNo
	 */
	public long getScoreNo() {
		return scoreNo;
	}

	/**
	 * @param scoreNo the scoreNo to set
	 */
	public void setScoreNo(long scoreNo) {
		this.scoreNo = scoreNo;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the score
	 */
	public float getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(float score) {
		if (score < 0) {
			this.score = 0f;
		} else if (score > 100) {
			this.score = 100f;
		} else {
			this.score = score;
		}
		gradePoint = getGradePoint();
	}

	/**
	 * @return the gradePoint
	 */
	public float getGradePoint() {
		if (gradePoint != -1) {
			if (score < 60) {
				return 0;
			} else if (score < 65) {
				return 1.2f;
			} else if (score < 70) {
				return 1.7f;
			} else if (score < 75) {
				return 2.2f;
			} else if (score < 80) {
				return 2.7f;
			} else if (score < 85) {
				return 3.2f;
			} else if (score < 90) {
				return 3.7f;
			} else {
				return 4.0f;
			}
		}
		return gradePoint;
	}

	/**
	 * @param gradePoint the gradePoint to set
	 */
	public void setGradePoint(float gradePoint) {
		this.gradePoint = gradePoint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Score [scoreNo=" + scoreNo + ", course=" + course + ", score=" + score + ", gradePoint=" + gradePoint
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + Float.floatToIntBits(gradePoint);
		result = prime * result + Float.floatToIntBits(score);
		result = prime * result + (int) (scoreNo ^ (scoreNo >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (scoreNo != other.scoreNo)
			return false;
		return true;
	}

}
