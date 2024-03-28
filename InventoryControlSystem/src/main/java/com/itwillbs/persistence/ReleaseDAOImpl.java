package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.Criteria;
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
	public ReleaseVO listInfoRelease(String pno) throws Exception {
		logger.debug("listInfoRelease(ReleaseVO vo) 호출");
		
		return sqlSession.selectOne(NAMESPACE+".getReleaseInfoList", pno);
		
	}
	

	@Override
	public ReleaseVO mainInspectionRelease(ReleaseVO rvo) throws Exception {
		logger.debug("mainInspectionRelease(ReleaseVO rvo) 호출");
		
		sqlSession.update(NAMESPACE+".upMainInstpection", rvo);
		
		return rvo;
	}

	@Override
	public ReleaseVO modifyRelease(ReleaseVO rvo) throws Exception {
		logger.debug("modifyRelease(ReleaseVO vo) 호출");
		
		sqlSession.update(NAMESPACE+".upReleaseModify", rvo);
		
		return rvo;
	}

	@Override
	public void deleteRelease(String pno) throws Exception {
		logger.debug("deleteRelease(ReleaseVO vo) 호출");
		
		sqlSession.delete(NAMESPACE+".deRelease", pno);
	}

	@Override
	public List<CodeVO> listCode() throws Exception {
		logger.debug(" listCode() 호출");
		
		return sqlSession.selectList(NAMESPACE+".selectCodeList");
	}

	/*
	 * @Override public ReleaseVO inspectionMain(String pno, int divcode) throws
	 * Exception { logger.debug(" inspectionMain(String pno, int divcode) 호출");
	 * 
	 * // 데이터 업데이트 수행 Map<String, Object> parameters = new HashMap<>(); // pno는 문자열,
	 * divcode는 정수 parameters.put("pno", pno); parameters.put("divcode", divcode);
	 * sqlSession.update(NAMESPACE + ".updateCode", parameters);
	 * 
	 * // 업데이트된 데이터 조회 ReleaseVO updatedData = sqlSession.selectOne(NAMESPACE +
	 * ".getUpdatedData", pno);
	 * 
	 * logger.debug("updatedData:" + updatedData);
	 * 
	 * return updatedData; }
	 */
	
	@Override
	public ReleaseVO inspectionRelease(ReleaseVO rvo) throws Exception {
		logger.debug(" inspectionMain(String pno, int divcode) 호출");
		
		sqlSession.update(NAMESPACE+".upReleaseInstpection", rvo);
		
		return rvo;
	}
	
//	@Override
//	public ReleaseVO modifyInspection(String pno, int divcode) throws Exception {
//	    logger.debug(" inspectionMain(String pno, int divcode) 호출");
//	    
//	    // 데이터 업데이트 수행
//	    Map<String, Object> parameters = new HashMap<>(); // pno는 문자열, divcode는 정수
//	    parameters.put("pno", pno);
//	    parameters.put("divcode", divcode);
//	    sqlSession.update(NAMESPACE + ".updateCode", parameters);
//	    
//	    // 업데이트된 데이터 조회
//	    ReleaseVO updatedData = sqlSession.selectOne(NAMESPACE + ".getUpdatedData", pno);
//	    
//	    logger.debug("updatedData:" + updatedData);
//	    
//	    return updatedData;
//	}
	
	@Override
	public List<ReleaseVO> boardListCriSelect(Criteria cri) throws Exception {
		logger.debug(" boardListCriSelect(Criteria cri) 호출 ");
		
		return sqlSession.selectList(NAMESPACE+".releaseMainListCri", cri);
	}
	
	@Override
	public List<ReleaseVO> releaseCriDiv5(Criteria cri) throws Exception {
		logger.debug(" releaseCriDiv5(Criteria cri) 호출 ");
		
		return sqlSession.selectList(NAMESPACE+".criDiv5", cri);
	}
	@Override
	public List<ReleaseVO> releaseCriDiv6(Criteria cri) throws Exception {
		logger.debug(" releaseCriDiv6(Criteria cri) 호출 ");
		
		return sqlSession.selectList(NAMESPACE+".criDiv6", cri);
	}
	@Override
	public List<ReleaseVO> releaseCriDiv8(Criteria cri) throws Exception {
		logger.debug(" releaseCriDiv8(Criteria cri) 호출 ");
		
		return sqlSession.selectList(NAMESPACE+".criDiv8", cri);
	}
	
	@Override
	public int releaseListCount() throws Exception {
		logger.debug(" releaseListCount() 호출");
		return sqlSession.selectOne(NAMESPACE + ".totalCount");
	}
	
	@Override
	public int releaseDiv5Count() throws Exception {
		logger.debug(" releaseDiv5Count() 호출");
		return sqlSession.selectOne(NAMESPACE + ".div5Count");
	}
	
	@Override
	public int releaseDiv6Count() throws Exception {
		logger.debug(" releaseDiv6Count() 호출");
		return sqlSession.selectOne(NAMESPACE + ".div6Count");
	}
	
	@Override
	public int releaseDiv8Count() throws Exception {
		logger.debug(" releaseDiv8Count() 호출");
		return sqlSession.selectOne(NAMESPACE + ".div8Count");
	}
	
	/*
	 * @Override public ReleaseVO subtractRelease(String pno,int release_count)
	 * throws Exception { logger.debug(" subtractRelease() 호출");
	 * logger.debug("release_count:"+release_count);
	 * 
	 * // 데이터 업데이트 수행 Map<String, Object> parameters = new HashMap<>();
	 * parameters.put("pno", pno); parameters.put("release_count", release_count);
	 * 
	 * sqlSession.update(NAMESPACE + ".upSubtractRelease", parameters);
	 * 
	 * // 업데이트된 데이터 조회 ReleaseVO getupSubtractRelease =
	 * sqlSession.selectOne(NAMESPACE + ".getupSubtractRelease", pno);
	 * 
	 * logger.debug("getupSubtractRelease:"+getupSubtractRelease);
	 * 
	 * 
	 * return getupSubtractRelease; }
	 */
	
	@Override
	public ReleaseVO subtractRelease(ReleaseVO rvo) throws Exception {
		
		sqlSession.update(NAMESPACE+".upSubtractRelease", rvo);
		
		return rvo;
	}

	@Override
	public void errorInsert(ReleaseVO rvo) throws Exception {
		logger.debug("errorRelease(ReleaseVO rvo) 호출");
		
		sqlSession.selectOne(NAMESPACE+".insertError", rvo);
	
	}

	@Override
	public void errorUpdate(ReleaseVO rvo) throws Exception {
		logger.debug("errorInsert(ReleaseVO rvo) 호출");
		
		sqlSession.update(NAMESPACE+".updateError", rvo);
		
		logger.debug("rvo ->>>"+ rvo);
		
	}

	@Override
	public void releaseError(ReleaseVO rvo) throws Exception {
		logger.debug("releaseError(ReleaseVO rvo) 호출");
		
		sqlSession.update(NAMESPACE+".upErrorRelease", rvo);
	}
	
	
	
}
