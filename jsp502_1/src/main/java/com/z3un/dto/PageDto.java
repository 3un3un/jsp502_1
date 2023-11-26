package com.z3un.dto;

public class PageDto {
	private int startNum;
	private int endNum;
	private int realEnd;
	
	private Criteria cri;
	private int totalCnt;
	private int blockAmount = 10;
	private boolean pre, next;

	public PageDto(Criteria cri, int totalCnt) {
		this.totalCnt = totalCnt;
		this.cri = cri;
		//7/10 = 0...-> 1*10 15/10 = 1.. -> 2*10 = 20
		endNum = (int)(Math.ceil(cri.getPageNo()*1.0/blockAmount))*blockAmount;
		startNum = endNum - (blockAmount - 1);
		//77 / 10 = 7.7 
		realEnd = (int)Math.ceil(totalCnt*1.0/cri.getAmount());
		
		endNum = (realEnd < endNum ? realEnd : endNum);
		
		pre = (startNum == 1 ? false : true);
		next = ( endNum == realEnd ? false : true);
		
		
		
		System.out.println("endNo "+endNum + " startNo " + startNum + " realEnd " + realEnd
				+ " prev " + pre + " next " + next);
		System.out.println("totalCnt "+totalCnt + " cri.getPageNo " + cri.getPageNo()
		+  " cri.getAmount() " + cri.getAmount() + " blockAmount " + blockAmount);
		
		
	}
	
	

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	public int getBlockAmount() {
		return blockAmount;
	}

	public void setBlockAmount(int blockAmount) {
		this.blockAmount = blockAmount;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}



	public Criteria getCri() {
		return cri;
	}



	public void setCri(Criteria cri) {
		this.cri = cri;
	}



	public int getTotalCnt() {
		return totalCnt;
	}



	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	

}
