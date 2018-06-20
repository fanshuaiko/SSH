package com.entity;

import java.util.List;
public class PageBean <T> {

	private List<T> list;//要返回的当前页的记录列表
	private int allRow;//总记录数
	private int totalPage;//总页数
	private int startRow;//起始行
	private int currentPage;//当前页
	private int pageSize;//每页记录条数
	
	
	private boolean isFirstPage;//是否为第一页
	private boolean isLastPage;//是否为最后一页
	private boolean hasPreviousPage;//是否有前一页
	private boolean hasNextPage;//是否有下一页
	
	public PageBean() {
		super();
	}

	
	
	public PageBean(List<T> list, int allRow, int totalPage, int startRow, int currentPage, int pageSize) {
		super();
		this.list = list;
		this.allRow = allRow;
		this.totalPage = totalPage;
		this.startRow = startRow;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}



	public int getAllRow() {
		return allRow;
	}



	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}



	public int getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public int getStartRow() {
		return startRow;
	}



	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	@Override
	public String toString() {
		return "PageBean [list=" + list + ", allRow=" + allRow + ", totalPage=" + totalPage + ", startRow=" + startRow
				+ ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", isFirstPage=" + isFirstPage
				+ ", isLastPage=" + isLastPage + ", hasPreviousPage=" + hasPreviousPage + ", hasNextPage=" + hasNextPage
				+ "]";
	}
}
