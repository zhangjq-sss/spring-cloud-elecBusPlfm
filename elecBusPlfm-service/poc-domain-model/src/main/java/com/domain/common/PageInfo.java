package com.domain.common;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("rawtypes")
public class PageInfo implements Serializable, Cloneable {
	/**
	 *
	 */
	private static final long serialVersionUID = -5021783945212013516L;

	/* the current viewing page */
	private int currentPage = 1;
	/* the total pages */
	private int totalPage;
	/* the total count of records existing */
	private int totalRecords;
	/* the count of result records viewing in the single page */
	private int pageSize = 20;
    private List records;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize != 0) {
			// 如果传入的值大于10000，则默认10000
			this.pageSize = (pageSize > 10000) ? 10000 : pageSize;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage != 0) {
			this.currentPage = currentPage;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		if(pageSize!=-1){
			setTotalPage(totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1);
		}else{
		    this.totalPage=-1;
        }
	}

	public List getRecords() {
		return records;
	}

	public void setRecords(List records) {
		this.records = records;
	}

	public PageInfo() {
	}

	public PageInfo(int pageSize, int currentPage) {
		setPageSize(pageSize);
		setCurrentPage(currentPage);
	}

	// invoke
	public int getFirstResult() {
		return (currentPage - 1) * pageSize;
	}

	@Override
	public PageInfo clone() {
		try {
			return (PageInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return this;
	}

}
