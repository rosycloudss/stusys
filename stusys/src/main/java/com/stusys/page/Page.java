package com.stusys.page;

/**
 * 分页信息
 * 
 * @author LIWEI
 * @time 2018年11月15日下午10:08:34 @description：
 *
 */
public class Page {

	private Integer pageStart = 0;// 当前页起始位置

	private Integer pageSize = 20;// 每页长度 默认为20

	private Integer pageNumber = 0;// 总页数

	private Integer pageCurrent = 1;// 当前页数

	/**
	 * @return the pageStart
	 */
	public Integer getPageStart() {
		return pageStart;
	}

	/**
	 * @param pageStart the pageStart to set
	 */
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageCurrent
	 */
	public Integer getPageCurrent() {
		return pageCurrent;
	}

	/**
	 * @param pageCurrent the pageCurrent to set
	 */
	public void setPageCurrent(Integer pageCurrent) {
		if (pageCurrent < pageNumber) {
			this.pageCurrent = pageCurrent;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Page [pageStart=" + pageStart + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber
				+ ", pageCurrent=" + pageCurrent + "]";
	}

}
