package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.StockVO;

public interface StockDAO {
	
	// 재고 리스트 조회
	public List<StockVO> stockListSelect() throws Exception;
	
	

}
