package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.InspectionVO;

@Repository
public class InspectionDAOImpl implements InspectionDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(InspectionDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.InspectionMapper";
	
	@Override
	public List<InspectionVO> inspectionList() throws Exception {
		logger.debug(" List<InspectionVO> inspectionList() 호출 ");
		return sqlSession.selectList(NAMESPACE+".selectInspection");
	}

	@Override
	public InspectionVO inspectionRead(String pno) throws Exception {
		logger.debug(" inspectionRead(String pno) 호출 ");
		return sqlSession.selectOne(NAMESPACE+".inspectionRead",pno);
	}

	@Override
	public void inspectionUpdate(InspectionVO vo) throws Exception {
		logger.debug(" inspectionUpdate(InspectionVO vo) 호출 ");
		sqlSession.update(NAMESPACE+".updateInspection", vo);
	}

	
	
	
}
