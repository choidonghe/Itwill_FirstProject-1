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
	public List<ReleaseVO> listRelease(ReleaseVO vo) {
		logger.debug("listRelease(ReleaseVO vo) 호출");
		
		return sqlSession.selectList(NAMESPACE+".getReleaseList", vo);
	}
	
	
	
}
