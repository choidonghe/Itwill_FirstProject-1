package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ReleaseVO;
import com.itwillbs.persistence.ReleaseDAO;

@Service
public class ReleaseServiceImpl implements ReleaseService{

	@Inject
	private ReleaseDAO rdao;
	
	private static final Logger logger = LoggerFactory.getLogger(ReleaseServiceImpl.class);

	@Override
	public List<ReleaseVO> releaseList() throws Exception{
		logger.debug("releaseList(ReleaseVO vo) 호출");
		
		return rdao.listRelease();
	}

	@Override
	public ReleaseVO releaseInfoList(String pno) throws Exception {
		logger.debug("releaseInfoList(ReleaseVO vo) 호출");
		
		return rdao.listInfoRelease(pno);
	}

	@Override
	public void releaseModify(ReleaseVO vo) throws Exception {
		logger.debug("releaseModify() 호출");
		
		rdao.modifyRelease(vo);
		
	}


	@Override
	public void releaseDelete(String pno) throws Exception {
		logger.debug("releaseDelete(ReleaseVO vo) 호출");
		
		rdao.deleteRelease(pno);
		
		
	}

	@Override
	public List<CodeVO> codeList() throws Exception {
		logger.debug("codeList() 호출");
		
		
		return rdao.listCode();
	}

	@Override
	public ReleaseVO mainInspection(String pno,int divcode) throws Exception {
		logger.debug("mainInspection(String pno) 호출");
		
		return rdao.inspectionMain(pno, divcode);
	}

	@Override
	public ReleaseVO inspectionModify(String pno, int divcode) throws Exception {
		// TODO Auto-generated method stub
		return rdao.modifyInspection(pno, divcode);
	}
	
	
	@Override
	public List<ReleaseVO> getListCri(Criteria cri) throws Exception {
		logger.debug("getListCri(Criteria cri) 호출");
		
		return rdao.boardListCriSelect(cri);
	}

	@Override
	public int getReleaseListCount() throws Exception {
		logger.debug(" getBoardListCount() 호출 ");
		return rdao.releaseListCount();
	}
	
	@Override
	public ReleaseVO releaseSubtract(String pno,int release_count) throws Exception {
		logger.debug("releaseSubtract(ReleaseVO vo) 호출");
		
		 return rdao.subtractRelease(pno, release_count);
	}

	@Override
	public ReleaseVO releaseError(String pno,int release_count, int error_count) throws Exception {
		logger.debug("releaseError(String pno) 호출");
		
		return rdao.errorRelease(pno, release_count, error_count);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
