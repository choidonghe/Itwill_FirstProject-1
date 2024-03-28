package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ProductVO;

public interface ProductDAO {
	
	public List<ProductVO> productList() throws Exception;
	
	
	// 제품 목록 조회
	public List<ProductVO> productListPage(int page) throws Exception;
	
	// 제품 목록 조회 페이징 처리 - Cri
	public List<ProductVO> productListCri(Criteria cri) throws Exception;
	
	public void productCodeUpdate(ProductVO pvo) throws Exception;
	
	public ProductVO selectProduct(String pno) throws Exception;
	
	public void insertInspection(ProductVO pvo) throws Exception;
	
	// 총 제품 개수 계산
	public int productListCount() throws Exception;
	
	
	// product 생산
	public void insertProduct(ProductVO pvo) throws Exception;
}
