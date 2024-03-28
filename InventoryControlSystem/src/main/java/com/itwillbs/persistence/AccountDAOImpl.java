package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.AccountVO;
import com.itwillbs.domain.Criteria;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	private static final String NAMESPACE = "com.itwillbs.mapper.AccountMapper";
	
	@Override
	public List<AccountVO> accountList(int page) throws Exception {
		logger.debug(" AccountVO 페이징 처리 번호 : " + page);
		page = (page-1) * 10;
		return sqlSession.selectList(NAMESPACE + ".accountList");
	}

	@Override
	public List<AccountVO> accountListCri(Criteria cri) throws Exception {
		logger.debug(" List<AccountVO> accountListCri(Criteria cri) 호출 ");
		return sqlSession.selectList(NAMESPACE + ".accountListCri", cri);
	}

	@Override
	public int accountCount() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + ".totalCountAccount");
	}

	@Override
	public AccountVO accountRead(String account_code) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + ".accountRead", account_code);
	}

	@Override
	public void updateAccount(AccountVO avo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateAccount", avo);
	}

	@Override
	public void deleteAccount(String account_code) throws Exception {
		
		sqlSession.delete(NAMESPACE + ".deleteAccount", account_code);
	}

	@Override
	public void addAccount(AccountVO avo) throws Exception {
		
		sqlSession.insert(NAMESPACE + ".addAccount", avo);
	}

	// 거래처리스트
	@Override
	public List<AccountVO> aLit(AccountVO avo) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".aList", avo);
	}

	
	
	
	
}
