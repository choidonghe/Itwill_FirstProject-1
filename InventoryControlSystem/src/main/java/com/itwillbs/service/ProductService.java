package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;

public interface ProductService {

	public List<ProductVO> productGetList() throws Exception;
	
	// 제품 페이지
	public List<ProductVO> productListPaget(int page) throws Exception;
	
	// 페이징 처리
	public List<ProductVO> productGetListCri(Criteria cri) throws Exception;
	
	public void updateProductCode(ProductVO pvo) throws Exception;
	
	public ProductVO pRead(String pno) throws Exception;
	
	public void insertInspection(ProductVO pvo) throws Exception;
	
	// 총 제품의 개수
	public int getProductListCount() throws Exception;
	
	// product 생산
	public void insertProduct(ProductVO pvo) throws Exception;
}
