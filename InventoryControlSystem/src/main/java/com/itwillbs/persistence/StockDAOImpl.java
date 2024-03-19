package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.StockVO;

@Repository
public class StockDAOImpl implements StockDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(StockDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.StockMapper";

	@Override
	public List<StockVO> stockListSelect() throws Exception {
		logger.debug(" stockListSelect() 호출 ");

		return sqlSession.selectList(NAMESPACE + ".selectStockList");
	}
}