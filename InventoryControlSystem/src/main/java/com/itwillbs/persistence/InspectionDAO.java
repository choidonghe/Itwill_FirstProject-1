package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.InspectionVO;

public interface InspectionDAO {
	
	// 검수 목록 조회
	public List<InspectionVO> inspectionList() throws Exception;
	
	// 검수 본문 조회
	public InspectionVO inspectionRead(String pno) throws Exception;
	
	// 검수 업데이트 
	public void inspectionUpdate(InspectionVO vo) throws Exception;
	
}
