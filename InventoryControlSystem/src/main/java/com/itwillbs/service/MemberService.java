package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.AuthVO;
import com.itwillbs.domain.MemberVO;
import com.itwillbs.domain.NoticeVO;

public interface MemberService {

	public int idCheck(String id) throws Exception;

	public void memberInsert(MemberVO vo) throws Exception;
	
	public void memberKakaoInsert(MemberVO vo) throws Exception;
	
	public AuthVO memberLogin(MemberVO vo) throws Exception;
	
	public MemberVO kakaoInfo(String code) throws Exception;
	
	public int checkUser(MemberVO vo) throws Exception;
	
	public List<MemberVO> memberListGet()throws Exception;

	public void updateMember(MemberVO vo) throws Exception;

	
	

} //service