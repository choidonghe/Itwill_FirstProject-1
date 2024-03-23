package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.domain.WarehouseVO;

public interface InspectionService {

	// 검수 리스트 조회 동작 - product
	public List<ProductVO> productGetInspectionList() throws Exception;
	
	// 검수 본문 조회 동작 - product
	public ProductVO productRead(String pno) throws Exception;
	
	// 검수 업데이트 동작 - product
	public void productModify(ProductVO pvo) throws Exception;
	
	// 검수 remain_quantity 동작 - product
	public void productUpdateRemain(ProductVO pvo) throws Exception;
	
	// 검수 리스트 입고검수 동작 - product
	public List<ProductVO> productGetInspectionDiv2() throws Exception;
	
	// 검수 리스트 입고 완료 동작 - product
	public List<ProductVO> productGetInspectionDiv3() throws Exception;
	
	// 창고 목록 조회
	public List<WarehouseVO> warehouseList() throws Exception;
	// 에러제품 넘기기
	public void insertError(ProductVO pvo) throws Exception;
	
	
	// 불량품 목록
	public List<ErrorVO> errorList() throws Exception;
	
	
	
}
