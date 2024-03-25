package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.StoreMapper";
	

	 @Override 
	 public List<ProductVO> productList() throws Exception {
		 return sqlSession.selectList(NAMESPACE + ".productList"); 
	 }


	// 제품 개수
	@Override
	public List<ProductVO> productListPage(int page) throws Exception {
		logger.debug("페이징처리 번호 :" + page);
		page = (page - 1) * 10;
		return sqlSession.selectList(NAMESPACE + ".selectProductListPage", page);
	}
	
	// 제품 목록 조회 페이징 처리
	@Override
	public List<ProductVO> productListCri(Criteria cri) throws Exception {
		logger.debug("productList(int page) 호출 ");
		
		return sqlSession.selectList(NAMESPACE + ".productListCri", cri);
	}
	
	@Override
	public void productCodeUpdate(ProductVO pvo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateProductCode", pvo);
	}
	@Override
	public ProductVO selectProduct(String pno) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + ".selectProduct", pno);
	}
	@Override
	public void insertInspection(ProductVO pvo) throws Exception {
		
		sqlSession.insert(NAMESPACE + ".insertInspection", pvo);
	}
	

	// 제품 개수 - cri
	@Override
	public int productListCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".totalCount");
	}
	
	
	
	
}
