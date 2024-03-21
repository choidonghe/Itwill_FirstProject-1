package com.itwillbs.domain;

// 페이징 처리에 필요한 정보를 저장하는 객체
public class MainCriteria {
	
	private int page; // 페이지 번호
	private int pageSize; // 페이지 크기
	

	public MainCriteria() {
		this.page = 1;
		this.pageSize = 10;
	}
	
	// 페이지 정보를 인덱스로 변경하는 메서드
	public int getStartPage() {
		return (this.page - 1) * pageSize;
		
	}


	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPage(int page) {
		if(page <= 0) { // 페이지 번호가 음수일때
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize > 100) { // 페이지 크기가 이상한 경우
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}


	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	
	
	
}
