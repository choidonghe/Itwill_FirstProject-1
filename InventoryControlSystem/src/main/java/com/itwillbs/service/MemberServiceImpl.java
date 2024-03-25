package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Override
	public void memberInsert(MemberVO vo) throws Exception{
		logger.debug(" memberInsert() 실행");
		
		vo.setSalt(dao.createSalt());
		
		vo.setPass(dao.hashPass(vo.getPass(), vo.getSalt()));
		
		dao.insertMember(vo);
		
		logger.debug(" 회원가입 완료!");
		
	}
	
	@Override
	public void memberKakaoInsert(MemberVO vo) throws Exception{
		logger.debug(" memberInsert() 실행");
		
		vo.setSalt(dao.createSalt());
		
		vo.setPass(dao.hashPass(vo.getPass(), vo.getSalt()));
		
		dao.insertKakaoMember(vo);
		
		logger.debug(" 회원가입 완료!");
		
	}

	@Override
	public String memberLogin(MemberVO vo) throws Exception {
		logger.debug(" memberLogin() 실행");
		
		vo.setSalt(dao.getSalt(vo));
		logger.debug(" salt정보 : "+ vo.getSalt());		
		
		// 받은 비밀번호로 솔트 추가후 해싱처리
		String pass = dao.hashPass(vo);
		logger.debug(" 입력한 비밀번호 해싱값 : "+ pass);
		// 기존 디비에 저장된 비밀번호 가져와서 비교
		vo = dao.getMember(vo);
		if(pass.equals(vo.getPass())) {
			logger.debug(" 비밀번호 일치 ");
			return vo.getId();
			
		}else logger.debug(" 비밀번호 불일치");
		
		return "";
	}

	@Override
	public MemberVO kakaoInfo(String code) throws Exception {
		logger.debug(" kakaoInsert(String code) 실행");
		
		String token = dao.getToken(code);
		logger.debug(" token : "+token ); 
		
		return dao.getUserInfo(token);
		
	}

	@Override
	public int checkUser(MemberVO vo) throws Exception {
		logger.debug(" checkUser(MemberVO vo) 실행");
		
		logger.debug("checkvo : "+vo);
		MemberVO cvo = dao.getMember(vo);
		logger.debug(" cvo : "+cvo);
		

		if(cvo == null) { // 회원가입 필요
			return 0;
		}
			
		return 1;
	}

	@Override
	public MemberVO getMember(MemberVO vo) throws Exception {
		return dao.getMember(vo);
	}

	
	


	
	
	
	
	
	
	

} // serviceImpl