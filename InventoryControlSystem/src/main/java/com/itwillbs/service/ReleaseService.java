package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.ReleaseVO;

public interface ReleaseService {

	public List<ReleaseVO> releaseList(ReleaseVO vo);
	
	public List<ReleaseVO> releaseInfoList(ReleaseVO vo);
	
	
	
}
