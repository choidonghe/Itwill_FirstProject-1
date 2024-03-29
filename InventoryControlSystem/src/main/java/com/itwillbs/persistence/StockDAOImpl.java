package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.StockDetailVO;
import com.itwillbs.domain.StockVO;

@Repository
public class StockDAOImpl implements StockDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(StockDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.stockMapper";

	@Override
	public List<StockVO> stockListSelect() throws Exception {
		logger.debug(" stockListSelect() 호출 ");

		return sqlSession.selectList(NAMESPACE + ".selectStockList");
	}
	
	// 재고 리스트 조회 (페이징)
	@Override
	public List<StockVO> stockListPageSelect(int page) throws Exception {
		logger.debug(" stockListPageSelect(int page) 호출 ");
		logger.debug(" 페이징처리 번호 : " + page);
		
		page = (page - 1) * 10;
		
		return sqlSession.selectList(NAMESPACE + ".selectStockListPage", page);
	}
	
	// 재고 리스트 조회 (Cri - 페이징)
	@Override
	public List<StockVO> stockListCriSelect(Criteria cri) throws Exception {
		logger.debug(" stockListCriSelect(Criteria cri) 호출 ");
		return sqlSession.selectList(NAMESPACE + ".selectStockListCri", cri);
	}

	// 총 글 개수 계산
	@Override
	public int stockListCount(Criteria cri) throws Exception {
		logger.debug(" boardListCount() 호출 ");
		logger.debug(" keyword : " + cri.getKeyword());
		return sqlSession.selectOne(NAMESPACE+".totalCount", cri);
	}

	
	// 제품 상세보기 조회
	@Override
	public List<StockDetailVO> stockDetailList(String pno) throws Exception {
		logger.debug(" stockDetailList() 호출 ");
		return sqlSession.selectList(NAMESPACE + ".detailView",pno);
	}

	@Override
	public void moveReleaseUpdate(StockDetailVO sdVO) throws Exception {
		logger.debug(" moveReleaseUpdate(stockVO) 호출 ");
		
		sqlSession.insert(NAMESPACE+".moveRelease", sdVO);
		
	}


	@Override
	public void updateRelease(StockDetailVO sdVO) throws Exception {
		logger.debug(" updateRelease(sdVO) 호출 ");
		
		sqlSession.update(NAMESPACE+".updateRelease", sdVO);
	}


	@Override
	public void updateStockCount(StockDetailVO sdVO) throws Exception {
		logger.debug(" updateStockCount(sdVO) ");
		
		sqlSession.update(NAMESPACE+".updateStockCount", sdVO);
	}
}