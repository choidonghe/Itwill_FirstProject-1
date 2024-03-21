package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
	public List<ReleaseVO> releaseInfoList(ReleaseVO vo) throws Exception {
		logger.debug("releaseInfoList(ReleaseVO vo) 호출");
		
		return rdao.listInfoRelease(vo);
	}

	@Override
	public void releaseModify(ReleaseVO vo) throws Exception {
		logger.debug("releaseModify() 호출");
		
		rdao.modifyRelease(vo);
		
	}

	@Override
	public String releaseCheck(ReleaseVO vo) throws Exception {
		logger.debug("releaseRelease(ReleaseVO vo) 호출");
		
		return rdao.checkRelease(vo);
	}
	
	
	
	
	
	
	
	
	
}
