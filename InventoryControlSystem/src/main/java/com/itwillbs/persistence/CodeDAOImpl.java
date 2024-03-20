package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.CodeVO;

@Repository
public class CodeDAOImpl implements CodeDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.StoreMapper";
	
	@Override
	public List<CodeVO> codeVOList() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectStoreIngList");
	}

	@Override
	public List<CodeVO> codeVOAllList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".selectCodeList");
	}
	
	
}
