package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {

	public int idCheck(String id) throws Exception;

	public void memberInsert(MemberVO vo) throws Exception;
	
	public void memberKakaoInsert(MemberVO vo) throws Exception;
	
	public String memberLogin(MemberVO vo) throws Exception;
	
	public MemberVO kakaoInfo(String code) throws Exception;
	
	public int checkUser(MemberVO vo) throws Exception;

} //service