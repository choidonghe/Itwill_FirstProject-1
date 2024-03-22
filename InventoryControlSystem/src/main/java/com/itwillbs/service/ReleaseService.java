package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.ReleaseVO;

public interface ReleaseService {

	public List<ReleaseVO> releaseList() throws Exception;
	
	public ReleaseVO releaseInfoList(String pno) throws Exception;
	
	public void releaseModify(ReleaseVO vo) throws Exception;
	
	public String releaseCheck(ReleaseVO vo) throws Exception;
	
	public void releaseDelete(String pno) throws Exception; 
	
	
}
