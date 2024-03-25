package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.ReleaseVO;

public interface ReleaseService {

	public List<ReleaseVO> releaseList() throws Exception;
	
	public ReleaseVO releaseInfoList(String pno) throws Exception;
	
	public void releaseModify(ReleaseVO vo) throws Exception;
	
	public void releaseSubtract(String pno) throws Exception;
	
	public void releaseDelete(String pno) throws Exception;
	
	public List<CodeVO> codeList() throws Exception;
	
	public ReleaseVO mainInspection(String pno,int divcode) throws Exception;
	
	public ReleaseVO inspectionModify(String pno,int divcode) throws Exception;
	
}
