package com.stusys.bean;

public class Score {
	private float score = 0f;// 分数
	private float gradePoint = 0f;// 绩点




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



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Score [score=" + score + ", gradePoint=" + gradePoint + "]";
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
		result = prime * result + Float.floatToIntBits(gradePoint);
		result = prime * result + Float.floatToIntBits(score);
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
		return true;
	}

}
