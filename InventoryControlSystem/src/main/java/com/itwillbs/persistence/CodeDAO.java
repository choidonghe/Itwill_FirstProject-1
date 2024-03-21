package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.CodeVO;

public interface CodeDAO {

	public List<CodeVO> codeVOList() throws Exception;
	
	public List<CodeVO> codeVOAllList() throws Exception;
}
