package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.StockVO;
import com.itwillbs.persistence.StockDAO;

@Service
public class StockServiceImpl implements StockService {
	
	@Inject
	private StockDAO sdao;
	
	private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
	
	
	// 글 목록 조회
	
	public List<StockVO> getList() throws Exception {
		logger.debug(" getList() 실행 ");
		return sdao.stockListSelect();
	}


	@Override
	public List<StockVO> getListCri(Criteria cri) throws Exception {
		logger.debug(" Service - getListCri(Criteria cri) 호출 ");
		return sdao.stockListCriSelect(cri);
	}


	@Override
	public int getBoardListCount(Criteria cri) throws Exception {
		logger.debug(" service - getBoardListCount() 호출 ");
		return sdao.stockListCount(cri);
	}



	
	

}
