package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.CodeVO;

public interface CodeService {

	public List<CodeVO> codeList() throws Exception;
	
	public List<CodeVO> allCodeList() throws Exception;
}
