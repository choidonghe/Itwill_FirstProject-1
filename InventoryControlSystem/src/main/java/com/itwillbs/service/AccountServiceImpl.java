package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.AccountVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.AccountDAO;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Inject
	private AccountDAO adao;
	
	@Override
	public List<AccountVO> accountList(int page) throws Exception {
		
		return adao.accountList(page);
	}

	@Override
	public List<AccountVO> accountListCri(Criteria cri) throws Exception {
		
		return adao.accountListCri(cri);
	}

	@Override
	public int accountCount() throws Exception {
		
		return adao.accountCount();
	}

	@Override
	public AccountVO accountRead(String account_code) throws Exception {
		
		return adao.accountRead(account_code);
	}

	@Override
	public void accountUpdate(AccountVO avo) throws Exception {
		adao.updateAccount(avo);
	}

	@Override
	public void accountDelete(String account_code) throws Exception {
		adao.deleteAccount(account_code);
	}

	@Override
	public void accountAdd(AccountVO avo) throws Exception {
		adao.addAccount(avo);
		
	}

	// 거래처리스트
	@Override
	public List<AccountVO> aList(AccountVO avo) throws Exception {
		return adao.aLit(avo);
	}
	
	

}
