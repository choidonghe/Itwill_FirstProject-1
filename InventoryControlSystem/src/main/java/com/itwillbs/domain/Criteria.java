package com.itwillbs.domain;

import java.util.Arrays;

// 페이징 처리에 필요한 정보를 저장하는 객체
public class Criteria {
	
	private int page;
	private int pageSize;
	private String keyword; // 검색어 키워드
	private String type; // 검색어 카테고리
	
	private String[] typeArr;
	
	public String[] getTypeArr() {
		return typeArr;
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
	}

	public Criteria() {
		this.page = 1;
		this.pageSize = 10;
	}
	
	public Criteria(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + ", keyword=" + keyword + ", type=" + type
				+ ", typeArr=" + Arrays.toString(typeArr) + "]";
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