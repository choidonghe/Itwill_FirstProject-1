package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;

public interface ProductDAO {
	public List<ProductVO> productList() throws Exception;
	
	public void productCodeUpdate(ProductVO pvo) throws Exception;
	
	public ProductVO selectProduct(String pno) throws Exception;
	
	public void insertInspection(ProductVO pvo) throws Exception;
	
	
	
}
