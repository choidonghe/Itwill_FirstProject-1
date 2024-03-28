package com.itwillbs.service;

import java.util.List;


import com.itwillbs.domain.AccountVO;
import com.itwillbs.domain.Criteria;


public interface AccountService {

	// 거래처 리스트 조회 동작
	public List<AccountVO> accountList(int page) throws Exception;
	public List<AccountVO> accountListCri(Criteria cri) throws Exception;
	
	// 거래처 총 개수
	public int accountCount() throws Exception;
	
	// 거래처 본문 조회
	public AccountVO accountRead(String account_code) throws Exception;
	
	// 거래처 수정
	public void accountUpdate(AccountVO avo) throws Exception;
	
	// 거래처 삭제
	public void accountDelete(String account_code) throws Exception;
	
	// 거래처 추가
	public void accountAdd(AccountVO avo) throws Exception;
	
	
	// 거래처리스트
	public List<AccountVO> aList(AccountVO avo) throws Exception;
	
	
	
	
}
