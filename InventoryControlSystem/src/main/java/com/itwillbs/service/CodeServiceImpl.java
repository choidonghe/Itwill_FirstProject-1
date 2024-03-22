package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.CodeVO;
import com.itwillbs.persistence.CodeDAO;

@Service
public class CodeServiceImpl implements CodeService {
	
	@Inject
	private CodeDAO cdao;
	
	@Override
	public List<CodeVO> codeList() throws Exception {
		
		return cdao.codeVOList();
	}

	@Override
	public List<CodeVO> allCodeList() throws Exception {
		
		return cdao.codeVOAllList();
	}
	
	
}
