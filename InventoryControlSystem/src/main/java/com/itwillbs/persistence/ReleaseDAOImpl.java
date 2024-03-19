package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class ReleaseDAOImpl implements ReleaseDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ReleaseDAOImpl.class);
	
	private static final String NAMESPACE =("com.itwillbs.mapper.ReleaseMapper");
	
}
