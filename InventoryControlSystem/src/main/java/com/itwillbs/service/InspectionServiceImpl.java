package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.ProductVO;
import com.itwillbs.persistence.InspectionDAO;

@Service
public class InspectionServiceImpl implements InspectionService{
	
	private static final Logger logger = LoggerFactory.getLogger(InspectionServiceImpl.class);
	@Inject
	private InspectionDAO idao;
	

	@Override
	public ProductVO productRead(String pno) throws Exception {
		
		return idao.productInspectionRead(pno);
	}

	@Override
	public void productModify(ProductVO pvo) throws Exception {
		idao.productInspectionUpdate(pvo);
		idao.productMoveToStock();
	}

	@Override
	public void productUpdateRemain(ProductVO pvo) throws Exception {
		
		idao.productInspectionRemainUpdate(pvo);
	}

	@Override
	public List<ProductVO> productGetInspectionList() throws Exception {
		
		return idao.productInspectionList();
	}
	
	@Override
	public List<ProductVO> productGetInspectionDiv2() throws Exception {
		
		return idao.productDiv2();
	}

	@Override
	public List<ProductVO> productGetInspectionDiv3() throws Exception {
		
		return idao.productDiv3();
	}


}
