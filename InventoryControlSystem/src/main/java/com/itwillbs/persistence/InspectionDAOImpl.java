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
import com.itwillbs.domain.WarehouseVO;

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
	public List<ProductVO> productDiv2(int page) throws Exception {
		page = (page-1)*10;
		return sqlSession.selectList(NAMESPACE + ".selectInspection2");
	}

	@Override
	public ProductVO productInspectionRead(String pno) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + ".productInspectionRead", pno);
	}


	@Override
	public List<ProductVO> productDiv3() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".productInspectionDiv3");
	}

	// 창고 코드 조회
	@Override
	public List<WarehouseVO> warehouseList() throws Exception {

		return sqlSession.selectList(NAMESPACE + ".selectWarehouse");
	}

	@Override
	public void insertError(ProductVO pvo) throws Exception {
		sqlSession.insert(NAMESPACE + ".insertError", pvo);
	}
	

	// 불량품 목록 조회
	@Override
	public List<ErrorVO> errorList(int page) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".errorList");
	}

	@Override
	public List<ProductVO> productInspectionList(int page) throws Exception {
		logger.debug(" 페이징처리 번호 : " + page);
		page = (page-1) * 10;
		return sqlSession.selectList(NAMESPACE + ".selectInspection");
	}

	@Override
	public List<ProductVO> productInspectionListCri(Criteria cri) throws Exception {
		logger.debug(" productInspectionListCri(Criteria cri) 호출 ");
		return sqlSession.selectList(NAMESPACE+".inspecListCri", cri);
	}

	@Override
	public List<ProductVO> productDiv2Cri(Criteria cri) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".inspecListCri2", cri);
	}

	@Override
	public List<ErrorVO> errorCri(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".errorCri", cri);
	}
	
}
