package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.domain.WarehouseVO;

public interface InspectionService {

	// 검수 리스트 조회 동작 - product
	public List<ProductVO> productGetInspectionList(int page) throws Exception;
	
	// 페이징 처리
	public List<ProductVO> inspecGetListCri(Criteria cri) throws Exception;
	
	// 검수 본문 조회 동작 - product
	public ProductVO productRead(String pno) throws Exception;
	
	// 검수 업데이트 동작 - product
	public void productModify(ProductVO pvo) throws Exception;
	// 검수에서 재고 수량 넘기면 업데이트
	public void updateStock(ProductVO pvo) throws Exception; 
	
	// 검수 remain_quantity 동작 - product
	public void productUpdateRemain(ProductVO pvo) throws Exception;
	
	// 검수 리스트 입고검수 동작 - product
	public List<ProductVO> productGetInspectionDiv2(int page) throws Exception;
	public List<ProductVO> productGetInspectionCri2(Criteria cri) throws Exception;
	
	
	// 검수 리스트 입고 완료 동작 - product
	public List<ProductVO> productGetInspectionDiv3() throws Exception;
	
	// 창고 목록 조회
	public List<WarehouseVO> warehouseList() throws Exception;
	// 에러제품 넘기기
	public void insertError(ProductVO pvo) throws Exception;
	// 에러 제품 업데이트
	public void updateError(ProductVO pvo) throws Exception;
	
	// 불량품 목록
	public List<ErrorVO> errorList(int page) throws Exception;
	public List<ErrorVO> errorCri(Criteria cri) throws Exception;
	
}
