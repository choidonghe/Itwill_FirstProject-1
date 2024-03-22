package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ProductVO;

@Repository
public class InspectionDAOImpl implements InspectionDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(InspectionDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.InspectionMapper";
	
	@Override
	public void productInspectionUpdate(ProductVO pvo) throws Exception {
		
		sqlSession.update(NAMESPACE + ".productUpdateInspection", pvo);
	}

	@Override
	public void productInspectionRemainUpdate(ProductVO pvo) throws Exception {
		sqlSession.update(NAMESPACE + ".productUpdateRemain", pvo);
	}

	@Override
	public void productMoveToStock() throws Exception {
		sqlSession.insert(NAMESPACE + ".productMoveToStock");
	}

	@Override
	public List<ProductVO> productDiv2() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".productInspectionDiv2");
	}

	@Override
	public ProductVO productInspectionRead(String pno) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + ".productInspectionRead", pno);
	}

	@Override
	public List<ProductVO> productInspectionList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".selectInspection");
	}

	@Override
	public List<ProductVO> productDiv3() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".productInspectionDiv3");
	}
	
	
}
