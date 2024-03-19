package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.StockVO;

public interface StockService {
	
	// 글 목록 조회 동작
	public List<StockVO> getList() throws Exception;
	
	// 글 목록 조회 동작 (페이징처리 - cri)
	public List<StockVO> getListCri(Criteria cri) throws Exception;
	
	// 총 글의 개수
	public int getBoardListCount() throws Exception;

}
