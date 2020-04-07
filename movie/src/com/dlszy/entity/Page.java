package com.dlszy.entity;

import java.util.List;

public class Page<T> {
	private Integer totalNum;//总共的数据条数
	private Integer pageSize;//每页显示的数据的条数
	private Integer totalPage;//总共的页数
	private Integer currentPage;//当前页
	//private Integer beginIndex; // 开始位置
	private List<T> content; 
	public Page() {
		this.totalNum=0;
		this.pageSize=0;
		this.totalPage=0;
		this.currentPage=0;
	}
	
	public Page(Integer totalNum, Integer pageSize, Integer totalPage,
			Integer currentPage, List<T> content) {
		super();
		this.totalNum = totalNum;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.content = content;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "Page [totalNum=" + totalNum + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", content=" + content + "]";
	}
}
