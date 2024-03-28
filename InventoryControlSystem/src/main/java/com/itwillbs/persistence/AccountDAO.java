package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.AccountVO;
import com.itwillbs.domain.Criteria;

public interface AccountDAO {
	
	public List<AccountVO> accountList(int page) throws Exception;
	public List<AccountVO> accountListCri(Criteria cri) throws Exception;
	
	// 거래처 개수 계산
	public int accountCount() throws Exception;
	
	// 거래처 본문 조회 
	public AccountVO accountRead(String account_code) throws Exception;
	
	// 거래처 수정
	public void updateAccount(AccountVO avo) throws Exception;
	
	// 거래처 삭제
	public void deleteAccount(String account_code) throws Exception;
	
	// 거래처 추가 
	public void addAccount(AccountVO avo) throws Exception;

	
	// 거래처 리스트
	public List<AccountVO> aLit(AccountVO avo) throws Exception;
	
}
