package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.domain.WarehouseVO;

public interface InspectionDAO {
	
	// 검수 목록 조회
	public List<ProductVO> productInspectionList(int page) throws Exception;
	// 검수 목록 조회 페이징 처리 - Cri
	public List<ProductVO> productInspectionListCri(Criteria cri) throws Exception;
	
	// 검수 본문 조회 - product
	public ProductVO productInspectionRead(String pno) throws Exception;
	
	// 검수 업데이트 - product 
	public void productInspectionUpdate(ProductVO pvo) throws Exception;
	
	// 검수 remain_count 업데이트 - product
	public void productInspectionRemainUpdate(ProductVO pvo) throws Exception;
	
	// 검수에서 재고로 넘어가기 - product
	public void productMoveToStock() throws Exception;
	// 검수에서 재고 수량 넘기면 업데이트
	public void stockUpdate(ProductVO pvo) throws Exception;
	
	
	// 검수목록 현황별 페이지 Div2 검수 - product
	public List<ProductVO> productDiv2(int page) throws Exception;
	public List<ProductVO> productDiv2Cri(Criteria cri) throws Exception;
	
	// 검수목록 현황별 페이지 Div3 완료 - product
	public List<ProductVO> productDiv3(int page) throws Exception;
	public List<ProductVO> productDiv3Cri(Criteria cri) throws Exception;
	
	// 창고목록 조회
	public List<WarehouseVO> warehouseList() throws Exception;
	
	// 불량 제품 넘기기
	public void insertError(ProductVO pvo) throws Exception;
	// 불량 제품 업데이트
	public void updateError(ProductVO pvo) throws Exception;
	
	// 불량품 목록
	public List<ErrorVO> errorList(int page) throws Exception;
	public List<ErrorVO> errorCri(Criteria cri) throws Exception;
	
	// 검수 총 개수 계산 
	public int totalInspec() throws Exception;
	
}
