package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.StoreVO;

public interface StoreDAO {
	// 입고예정 리스트 조회
	public List<StoreVO> storeIngListSelect() throws Exception;
	
}
