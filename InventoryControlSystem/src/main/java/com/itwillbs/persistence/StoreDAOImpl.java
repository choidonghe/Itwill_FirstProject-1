package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.StoreVO;

@Repository
public class StoreDAOImpl implements StoreDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.StoreMapper";
	
	@Override
	public List<StoreVO> storeIngListSelect() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectStoreIngList");
	}
	
	
}
