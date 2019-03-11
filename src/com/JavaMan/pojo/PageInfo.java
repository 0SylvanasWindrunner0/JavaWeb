package com.JavaMan.pojo;

import java.util.List;

public class PageInfo {
	private int pageSize;
	private int pageNumber;
	private long pageTotal;
	private List<?> list;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(long total) {
		this.pageTotal = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
	
}
