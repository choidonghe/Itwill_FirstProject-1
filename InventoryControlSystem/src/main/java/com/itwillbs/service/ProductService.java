package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;

public interface ProductService {

	public List<ProductVO> productGetList() throws Exception;
	
	public void updateProductCode(ProductVO pvo) throws Exception;
	
	public ProductVO pRead(String pno) throws Exception;
	
	public void insertInspection(ProductVO pvo) throws Exception;
	
	
	
}
