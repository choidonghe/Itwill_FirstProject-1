package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.CodeVO;
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

	@Override
	public void updateCode(StoreVO vo) throws Exception {
		
		sdao.codeUpdate(vo);
	}

	@Override
	public StoreVO read(String pno) throws Exception {
		
		return sdao.selectStore(pno);
	}

	
	

	
}
