package com.itwillbs.domain;

// 페이징 처리에 필요한 정보를 저장하는 객체
public class ErgOrderCriteria {
	
	private int orderPage; // 페이지 번호
	private int orderPageSize; // 페이지 크기
	

	public ErgOrderCriteria() {
		this.orderPage = 1;
		this.orderPageSize = 10;
	}
	
	// 페이지 정보를 인덱스로 변경하는 메서드
	public int getStartPage() {
		return (this.orderPage - 1) * orderPageSize;
		
	}


	public int getOrderPage() {
		return orderPage;
	}

	public int getOrderPageSize() {
		return orderPageSize;
	}

	public void setOrderPage(int orderPage) {
		if(orderPage <= 0) { // 페이지 번호가 음수일때
			this.orderPage = 1;
			return;
		}
		this.orderPage = orderPage;
	}

	public void setOrderPageSize(int orderPageSize) {
		if(orderPageSize <= 0 || orderPageSize > 100) { // 페이지 크기가 이상한 경우
			this.orderPageSize = 10;
			return;
		}
		this.orderPageSize = orderPageSize;
	}


	@Override
	public String toString() {
		return "Criteria [orderPage=" + orderPage + ", orderPageSize=" + orderPageSize + "]";
	}
	
	
	
	
}
