package com.stt.domain;

public class Criteria {
	public static enum ORDERBY {CHART, NEW};
	private ORDERBY orderby;
	private int page;
	private int numPerPage;
	public Criteria() {
		page = 1;
		numPerPage = 10;
	}
	public char getOrderby() {
		if(orderby==ORDERBY.CHART)
			return 'c';
		else
			return 'n';
	}
	public void setOrderby(ORDERBY orderby) {
		this.orderby = orderby;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getPageStart() {
		return (page-1)*numPerPage;
	}
	@Override
	public String toString() {
		return "Criteria [orderby=" + orderby + ", page=" + page + ", numPerPage=" + numPerPage + "]";
	}
}
