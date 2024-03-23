package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;
import com.itwillbs.persistence.ProductDAO;

@Service
public class ProductServiceIpl implements ProductService {

	@Inject
	private ProductDAO pdao;
	@Override
	public List<ProductVO> productGetList() throws Exception {
		
		return pdao.productList();
	}
	@Override
	public void updateProductCode(ProductVO pvo) throws Exception {
		pdao.productCodeUpdate(pvo);
	}
	@Override
	public ProductVO pRead(String pno) throws Exception {
		
		return pdao.selectProduct(pno);
	}
	@Override
	public void insertInspection(ProductVO pvo) throws Exception {
		
		pdao.insertInspection(pvo);
	}
	

	
	
}
