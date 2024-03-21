package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.ReleaseVO;

public interface ReleaseDAO {

	public List<ReleaseVO> listRelease() throws Exception;

	public List<ReleaseVO> listInfoRelease(ReleaseVO vo) throws Exception;
	
	public void modifyRelease(ReleaseVO vo) throws Exception;

	public String checkRelease(ReleaseVO vo) throws Exception;


}