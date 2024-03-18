package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.StoreVO;


public interface StoreService {
	// 입고 예정 목록 조회
	public List<StoreVO> storeIngGetList() throws Exception;
}
