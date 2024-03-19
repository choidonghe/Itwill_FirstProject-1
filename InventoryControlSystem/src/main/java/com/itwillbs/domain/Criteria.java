package com.itwillbs.domain;

// 페이징 처리에 필요한 정보를 저장하는 객체
public class Criteria {
	
	private int page;
	private int pageSize;
	
	public Criteria() {
		this.page = 1;
		this.pageSize = 10;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	// 페이지 정보를 인덱스로 변경하는 메서드 -----------------------------------
	public int getStartPage() {
		return (this.page - 1 ) * pageSize;
	}
	// 페이지 정보를 인덱스로 변경하는 메서드 -----------------------------------
	
	public int getPage() {
		return page;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize > 200) { // 페이지 크기 200이 안넘어가게
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}
	
}
