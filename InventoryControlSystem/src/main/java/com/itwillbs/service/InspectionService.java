package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.InspectionVO;

public interface InspectionService {

	// 검수 리스트 조회 동작
	public List<InspectionVO> getInspectionList() throws Exception;
	
	// 검수 본문 조회 동작
	public InspectionVO read(String pno) throws Exception;
	
	// 검수 업데이트 동작
	public void modify(InspectionVO vo) throws Exception;
	
	
	
	
}
