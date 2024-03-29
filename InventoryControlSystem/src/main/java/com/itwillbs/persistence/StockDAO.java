package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.StockDetailVO;
import com.itwillbs.domain.StockVO;

public interface StockDAO {
	
	// 재고 리스트 조회
	public List<StockVO> stockListSelect() throws Exception;
	
	// 재고 리스트 조회 (페이징)
	public List<StockVO> stockListPageSelect(int page) throws Exception;
	
	// 재고 리스트 조회 (페이징 - Cri)
	public List<StockVO> stockListCriSelect(Criteria cri) throws Exception;
	
	// 총 글의 개수 계산
	public int stockListCount(Criteria cri) throws Exception;
	
	// 제품 상세보기 조회
	public List<StockDetailVO> stockDetailList(String pno) throws Exception;
	
	// 재고에서 출고로~
	public void moveReleaseUpdate(StockDetailVO sdVO) throws Exception;
	
	// 출고 리스트 업데이트
	public void updateRelease(StockDetailVO sdVO) throws Exception;
	
	// 재고 count 업데이트
	public void updateStockCount(StockDetailVO sdVO) throws Exception;

}