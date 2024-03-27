package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.domain.WarehouseVO;
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
	public List<ProductVO> productGetInspectionList(int page) throws Exception {
		
		return idao.productInspectionList(page);
	}
	
	@Override
	public List<ProductVO> productGetInspectionDiv2(int page) throws Exception {
		
		return idao.productDiv2(page);
	}

	@Override
	public List<ProductVO> productGetInspectionDiv3() throws Exception {
		
		return idao.productDiv3();
	}

	// 창고목록 조회
	@Override
	public List<WarehouseVO> warehouseList() throws Exception {

		return idao.warehouseList();
	}
	// 에러제품 넘기기
	@Override
	public void insertError(ProductVO pvo) throws Exception {
		idao.productInspectionUpdate(pvo);
		idao.insertError(pvo);
	}
	// 에러제품 업데이트
	@Override
	public void updateError(ProductVO pvo) throws Exception {
		idao.updateError(pvo);
	}

	// 불량품 목록 조회
	@Override
	public List<ErrorVO> errorList(int page) throws Exception {
		return idao.errorList(page);
	}

	@Override
	public List<ProductVO> inspecGetListCri(Criteria cri) throws Exception {
		return idao.productInspectionListCri(cri);
	}

	@Override
	public List<ProductVO> productGetInspectionCri2(Criteria cri) throws Exception {
		return idao.productDiv2Cri(cri);
	}

	@Override
	public List<ErrorVO> errorCri(Criteria cri) throws Exception {
		return idao.errorCri(cri);
	}

	@Override
	public void updateStock(ProductVO pvo) throws Exception {
		idao.stockUpdate(pvo);
	}

	
	
}
