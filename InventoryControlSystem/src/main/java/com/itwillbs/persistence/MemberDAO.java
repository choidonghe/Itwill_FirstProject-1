package com.itwillbs.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	public int checkId(String id) throws Exception;
	
	public String createSalt() throws Exception;
	
	public String hashPass(String pass, String salt) throws Exception;
	
	public String hashPass(MemberVO vo) throws Exception;
	
	public void insertMember(MemberVO vo) throws Exception;
	
	public void insertKakaoMember(MemberVO vo) throws Exception;
	
	public String getSalt(MemberVO vo) throws Exception;
	
	public MemberVO getMember(MemberVO vo) throws Exception;
	
	public String getToken(String code) throws Exception;
	
	public MemberVO getUserInfo(String token) throws Exception;
	

	 

}