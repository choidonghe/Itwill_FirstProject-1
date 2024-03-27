package com.itwillbs.service;

import java.util.List;


import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ReleaseVO;

public interface ReleaseService {

	public List<ReleaseVO> releaseList() throws Exception;
	
	public ReleaseVO releaseInfoList(String pno) throws Exception;
	
	public void releaseModify(ReleaseVO vo) throws Exception;
	
	public void releaseDelete(String pno) throws Exception;
	
	public List<CodeVO> codeList() throws Exception;
	
	public ReleaseVO mainInspection(String pno,int divcode) throws Exception;
	
	public ReleaseVO inspectionModify(String pno,int divcode) throws Exception;
	
	// 글 목록 조회 동작(페이징처리 - cri)
	public List<ReleaseVO> getListCri(Criteria cri) throws Exception;
		
	// 총 글의 개수
	public int getReleaseListCount() throws Exception;
	
	// 검수완료
	public ReleaseVO releaseSubtract(String pno,int release_count) throws Exception;
	
	public ReleaseVO releaseError(String pno, int error_count) throws Exception;
	
	
}
