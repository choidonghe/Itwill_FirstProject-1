package com.itwillbs.persistence;

import java.util.List;


import com.itwillbs.domain.CodeVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.ReleaseVO;

public interface ReleaseDAO {

	public List<ReleaseVO> listRelease() throws Exception;

	public ReleaseVO listInfoRelease(String pno) throws Exception;
	
	public ReleaseVO mainInspectionRelease(ReleaseVO rvo) throws Exception;
	
	public ReleaseVO modifyRelease(ReleaseVO rvo) throws Exception;
	
	public void deleteRelease(String pno) throws Exception;

	public List<CodeVO> listCode() throws Exception;
	
	public ReleaseVO inspectionRelease(ReleaseVO rvo) throws Exception;
	
	// 글 목록 조회(페이징-Cri)
	public List<ReleaseVO> boardListCriSelect(Criteria cri) throws Exception;
		
	public List<ReleaseVO> releaseCriDiv5(Criteria cri) throws Exception;
	
	public List<ReleaseVO> releaseCriDiv6(Criteria cri) throws Exception;
	
	public List<ReleaseVO> releaseCriDiv8(Criteria cri) throws Exception;
	
	// 총 글의 개수 계산
	public int releaseListCount() throws Exception;
	
	public int releaseDiv5Count() throws Exception;
	
	public int releaseDiv6Count() throws Exception;
	
	public int releaseDiv8Count() throws Exception;
	
	public ReleaseVO subtractRelease(ReleaseVO rvo) throws Exception;
	
	public void errorInsert(ReleaseVO rvo) throws Exception;
	
	public void errorUpdate(ReleaseVO rvo) throws Exception;
	
	public void releaseError(ReleaseVO rvo) throws Exception;
	
}