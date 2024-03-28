package com.itwillbs.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 페이징처리 하단 블럭
public class ErgOrderPageVO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ErgOrderPageVO.class);
	
	private int totalCount; // 전체 글의 수
	private int startPage;  // 블럭의 시작번호
	private int endPage;    // 블럭의 끝번호
	
	private boolean prev; // 이전버튼
	private boolean next; // 다음버튼
	
	private int pageBlock = 3; // 페이지 블럭의 개수
	
	//private int page; // 페이지 번호
	//private int pageSize; // 페이지 크기
	private ErgOrderCriteria cri;

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setCri(ErgOrderCriteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		logger.debug(" 페이징 처리에 필요한 정보를 계산 - 시작 ");
		
		pageCalc();
		
		logger.debug(" 페이징 처리에 필요한 정보를 계산 - 끝 ");
		
	} // setTotalCount()
	
	
	public void pageCalc() {
		endPage = (int) Math.ceil(cri.getOrderPage() / (double)pageBlock) * pageBlock;
		
		// startPage
		startPage = (endPage - pageBlock) + 1; 
		
		// tmpEndPage (실제 endPage)
		int tmpEndPage = (int)Math.ceil(totalCount / (double)cri.getOrderPageSize());
		
		if(endPage > tmpEndPage) { // 글이 없음 부족함
			endPage = tmpEndPage;
		}
		
		// prev
		prev = startPage != 1;
		
		// next
		next = endPage * cri.getOrderPageSize() < totalCount;		
	}
	
	
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public ErgOrderCriteria getCri() {
		return cri;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	@Override
	public String toString() {
		return "PageVO [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", pageBlock=" + pageBlock + ", cri=" + cri + "]";
	}

	
	
	
	
	
	
} // PageVO
