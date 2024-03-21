package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ReleaseVO;


@Repository
public class ReleaseDAOImpl implements ReleaseDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ReleaseDAOImpl.class);
	
	private static final String NAMESPACE =("com.itwillbs.mapper.ReleaseMapper");

	@Override
	public List<ReleaseVO> listRelease() throws Exception {
		logger.debug("listRelease(ReleaseVO vo) 호출");
		
		return sqlSession.selectList(NAMESPACE+".getReleaseList");
	}

	@Override
	public List<ReleaseVO> listInfoRelease(ReleaseVO vo) throws Exception {
		logger.debug("listInfoRelease(ReleaseVO vo) 호출");
		
		return sqlSession.selectList(NAMESPACE+".getReleaseInfoList", vo);
	}

	@Override
	public void modifyRelease(ReleaseVO vo) throws Exception {
		logger.debug("modifyRelease(ReleaseVO vo) 호출");
		
		sqlSession.selectOne(NAMESPACE+".upReleaseModify", vo);
		
	}

	@Override
	public String checkRelease(ReleaseVO vo) throws Exception {
		logger.debug(" checkRelease(ReleaseVO vo) 호출");
		
		return sqlSession.selectOne(NAMESPACE+".upCheckRelease", vo);
	}
	
	

	
	
	
	
	
}
