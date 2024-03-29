package com.itwillbs.domain;

// 페이징 처리에 필요한 정보를 저장하는 객체
public class NoticeCriteria {
	
	private int noticePage; // 페이지 번호
	private int noticePageSize; // 페이지 크기
	

	public NoticeCriteria() {
		this.noticePage = 1;
		this.noticePageSize = 10;
	}
	
	// 페이지 정보를 인덱스로 변경하는 메서드
	public int getStartPage() {
		return (this.noticePage - 1) * noticePageSize;
		
	}


	public int getNoticePage() {
		return noticePage;
	}

	public int getNoticePageSize() {
		return noticePageSize;
	}

	public void setNoticePage(int noticePage) {
		if(noticePage <= 0) { // 페이지 번호가 음수일때
			this.noticePage = 1;
			return;
		}
		this.noticePage = noticePage;
	}

	public void setNoticePageSize(int noticePageSize) {
		if(noticePageSize <= 0 || noticePageSize > 100) { // 페이지 크기가 이상한 경우
			this.noticePageSize = 10;
			return;
		}
		this.noticePageSize = noticePageSize;
	}


	@Override
	public String toString() {
		return "Criteria [noticePage=" + noticePage + ", noticePageSize=" + noticePageSize + "]";
	}
	
}
