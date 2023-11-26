package com.z3un.dto;

public class Criteria {
	private int startNo;
	private int endNo;
	
	private int pageNo = 1;
	private int amount = 10;
	
	public Criteria(String pageNo, String amount) {
		if(!"".equals(pageNo) && pageNo != null) {
			this.pageNo = Integer.parseInt(pageNo);
		}
		if(!"".equals(amount) && amount != null) {
			this.amount = Integer.parseInt(amount);
		}
		endNo = this.pageNo * this.amount;
		startNo = this.endNo - (this.amount -1);
	}
	
	
	
	public int getStartNo() {
		return startNo;
	}




	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}




	public int getEndNo() {
		return endNo;
	}




	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}




	public int getPageNo() {
		return pageNo;
	}




	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}




	public int getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}






}
