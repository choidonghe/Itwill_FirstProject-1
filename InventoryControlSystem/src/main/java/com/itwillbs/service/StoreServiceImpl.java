package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.StoreVO;
import com.itwillbs.persistence.StoreDAO;

@Service
public class StoreServiceImpl implements StoreService {

	@Inject
	private StoreDAO sdao;
	
	@Override
	public List<StoreVO> storeIngGetList() throws Exception {
		
		return sdao.storeIngListSelect();
	}

}
