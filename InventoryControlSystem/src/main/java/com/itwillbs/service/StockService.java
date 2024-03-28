package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.StockDetailVO;
import com.itwillbs.domain.StockVO;

public interface StockService {
	
	// 글 목록 조회 동작
	public List<StockVO> getList() throws Exception;
	
	// 글 목록 조회 동작 (페이징처리 - cri)
	public List<StockVO> getListCri(Criteria cri) throws Exception;
	
	// 총 글의 개수
	public int getBoardListCount(Criteria cri) throws Exception;
	
	// 제품 상세보기 조회
	public List<StockDetailVO> getDetailList(String pno) throws Exception;
	
	// 출고 테이블로 정보 이동
	public void moveRelease(StockDetailVO sdVO) throws Exception;
	
	// 출고 리스트 업데이트
	public void updRelease(StockDetailVO sdVO) throws Exception;
	
	// 재고 count 업데이트
	public void stockCountUpdate(StockDetailVO sdVO) throws Exception;
	


}
