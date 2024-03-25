package com.itwillbs.persistence;

import java.util.List;


import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ReleaseVO;

public interface ReleaseDAO {

	public List<ReleaseVO> listRelease() throws Exception;

	public ReleaseVO listInfoRelease(String pno) throws Exception;
	
	public void modifyRelease(ReleaseVO vo) throws Exception;

	public void subtractRelease(String pno) throws Exception;
	
	public void deleteRelease(String pno) throws Exception;

	public List<CodeVO> listCode() throws Exception;
	
	public ReleaseVO inspectionMain(String pno, int divcode) throws Exception;
	
	public ReleaseVO modifyInspection(String pno, int divcdoe) throws Exception;
	
	// 글 목록 조회(페이징-Cri)
		public List<ReleaseVO> boardListCriSelect(Criteria cri) throws Exception;
		
		// 총 글의 개수 계산
		public int releaseListCount() throws Exception;
	
}