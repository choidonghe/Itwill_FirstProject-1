package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.CategoryVO;
import com.itwillbs.domain.Criteria;
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
	 

	// 제품 페이지
	@Override
	public List<ProductVO> productListPaget(int page) throws Exception {
		
		return pdao.productListPage(page);
	}
	
	// 페이징처리
	@Override
	public List<ProductVO> productGetListCri(Criteria  cri) throws Exception {
		
		return pdao.productListCri(cri);
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

	// 총 제품의 개수
	@Override
	public int getProductListCount() throws Exception {
		return pdao.productListCount();
	}


	@Override
	public void insertProduct(ProductVO pvo) throws Exception {
		pdao.insertProduct(pvo);
	}


	@Override
	public List<CategoryVO> cList(CategoryVO cvo) throws Exception {
		return pdao.cList(cvo);
	}

	

	
	
	
}
