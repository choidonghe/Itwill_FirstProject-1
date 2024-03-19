package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.StockVO;

public interface StockService {
	
	// 글 목록 조회 동작
	public List<StockVO> getList() throws Exception;

}
