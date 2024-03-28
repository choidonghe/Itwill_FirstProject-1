package com.itwillbs.service;

import java.util.List;


import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ReleaseVO;

public interface ReleaseService {

	public List<ReleaseVO> releaseList() throws Exception;
	
	public ReleaseVO releaseInfoList(String pno) throws Exception;
	
	public ReleaseVO releaseMainInspection(ReleaseVO rvo) throws Exception;
	
	public ReleaseVO releaseModify(ReleaseVO rvo) throws Exception;
	
	public void releaseDelete(String pno) throws Exception;
	
	public List<CodeVO> codeList() throws Exception;
	
//	public ReleaseVO mainInspection(String pno,int divcode) throws Exception;
	public ReleaseVO releaseInspection(ReleaseVO rvo) throws Exception;
	
//	public ReleaseVO inspectionModify(String pno,int divcode) throws Exception;
	
	// 글 목록 조회 동작(페이징처리 - cri)
	public List<ReleaseVO> getListCri(Criteria cri) throws Exception;
	
	// 글 목록 조회 동작(페이징처리 - cri)
	public List<ReleaseVO> CriDiv5(Criteria cri) throws Exception;
		
	public List<ReleaseVO> CriDiv6(Criteria cri) throws Exception;
	
	public List<ReleaseVO> CriDiv8(Criteria cri) throws Exception;
	
	// 총 글의 개수
	public int getReleaseListCount() throws Exception;
	
	public int cri5Count() throws Exception;
	
	public int cri6Count() throws Exception;
	
	public int cri8Count() throws Exception;
	
	// 검수완료
	//public ReleaseVO releaseSubtract(String pno,int release_count) throws Exception;
	
	public ReleaseVO releaseSubtract(ReleaseVO rvo) throws Exception;
	
	public void insertError(ReleaseVO rvo) throws Exception;
	
	public void updateError(ReleaseVO rvo) throws Exception;
	
	public void errorRelease(ReleaseVO rvo) throws Exception;
}
