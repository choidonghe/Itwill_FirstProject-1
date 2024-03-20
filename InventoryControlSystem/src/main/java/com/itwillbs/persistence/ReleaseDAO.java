package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.ReleaseVO;

public interface ReleaseDAO {

	public List<ReleaseVO> listRelease(ReleaseVO vo);

	public List<ReleaseVO> listInfoRelease(ReleaseVO vo);



}