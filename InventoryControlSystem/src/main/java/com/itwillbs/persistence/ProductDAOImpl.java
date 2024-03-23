package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ErrorVO;
import com.itwillbs.domain.ProductVO;
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.StoreMapper";
	@Override
	public List<ProductVO> productList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".productList");
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
	
	
	
	
}
