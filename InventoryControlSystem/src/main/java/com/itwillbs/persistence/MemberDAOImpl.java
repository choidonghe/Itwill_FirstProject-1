package com.itwillbs.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.itwillbs.domain.AuthVO;
import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";


	@Override
	public int checkId(String id) throws Exception {
		logger.debug(" checkId(String id) 실행");
		
		return sql.selectOne(NAMESPACE+".checkId", id);
	}
	
	
	@Override
	public String createSalt() throws Exception {
		// 랜덤 값 생성
		SecureRandom ran = new SecureRandom();
		
		byte[] temp = new byte[10];
		ran.nextBytes(temp);
		
		StringBuilder sb = new StringBuilder();
		for(byte a : temp) {
			sb.append(String.format("%02x", a));
		}
		
		return sb.toString();
	}


	
	@Override
	public String hashPass(String pass, String salt) throws Exception{
		logger.debug(" hashPass() 실행");
		
		byte[] bPass = pass.getBytes();
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		for(int i = 0; i<1000; i++) {
			
			String Spass = salt+pass;
			md.update(Spass.getBytes());
			
			bPass = md.digest();
		}
		
		StringBuilder sb = new StringBuilder();
		for(byte a : bPass) {
			sb.append(String.format("%02x", a));
		}
		
		return sb.toString();
	}


	@Override
	public String hashPass(MemberVO vo) throws Exception {
		logger.debug(" hashPass(MemberVO vo) 실행");
		
		byte[] bPass = vo.getPass().getBytes();
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		for(int i = 0; i<1000; i++) {
			
			String Spass = vo.getSalt()+vo.getPass();
			md.update(Spass.getBytes());
			
			bPass = md.digest();
		}
		
		StringBuilder sb = new StringBuilder();
		for(byte a : bPass) {
			sb.append(String.format("%02x", a));
		}
		
		return sb.toString();
	}
	
	
	@Override
	public void insertMember(MemberVO vo) throws Exception{
		logger.debug(" insertMember() 실행");
		
		sql.insert(NAMESPACE+".insertMember", vo);
		sql.insert(NAMESPACE+".authMember", vo);
		
	}
	
	@Override
	public void insertKakaoMember(MemberVO vo) throws Exception{
		logger.debug(" insertMember() 실행");
		
		sql.insert(NAMESPACE+".authMember", vo);
		
	}


	@Override
	public String getSalt(MemberVO vo) throws Exception {
		logger.debug(" loginMember(MemberVO vo) 실행");
		
		return  sql.selectOne(NAMESPACE+".getSalt", vo);
		
	}


	@Override
	public MemberVO getMember(MemberVO vo) throws Exception {
		logger.debug(" getMember(MemberVO vo) 실행");
		
		return sql.selectOne(NAMESPACE+".getMember", vo);
		
	}
	

	@Override
	public AuthVO getAuth(String id) throws Exception {
		logger.debug(" getAuth(String id) 실행");
		
		return sql.selectOne(NAMESPACE+".getAuth", id);
	}


	@Override
	public String getToken(String code) throws Exception {
		logger.debug(" getToken() 실행");
		
		String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=519552de35c6233367d12dde932a05c8"); // 개인 REST IP
            sb.append("&redirect_uri=http://c6d2311t1.itwillbs.com/wms/registerkakao");
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            int responseCode = conn.getResponseCode();
            logger.debug("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
                
            }
            logger.debug("response body : " + result);

            //Gson으로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
           
            
            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            //refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            logger.debug("access_token : " + access_Token);
            logger.debug("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
	}

	@Override
	public MemberVO getUserInfo(String token) throws Exception {
		logger.debug(" getUserInfo(String token)  실행");
		
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		MemberVO vo = new MemberVO();
		
		vo.setPass("aaa");

	    // access_token을 이용하여 사용자 정보 조회
	    try {
	       URL url = new URL(reqURL);
	       HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	       conn.setRequestMethod("POST");
	       conn.setDoOutput(true);
	       conn.setRequestProperty("Authorization", "Bearer " + token);

	       int responseCode = conn.getResponseCode();
	       logger.debug("responseCode : " + responseCode);

	       // 요청을 통해 얻은 JSON 메세지 읽어오기
	       BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	       String line = "";
	       String result = "";

	       while ((line = br.readLine()) != null) {
	           result += line;
	       }
	       logger.debug("response body : " + result);
	       
	       //Gson 라이브러리로 JSON파싱
	       JsonParser parser = new JsonParser();
	       JsonElement element = parser.parse(result);
	  
	       vo.setId(Integer.toString(element.getAsJsonObject().get("id").getAsInt()));
	       
	       vo.setName(element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("name").getAsString());
	       
	       boolean hasEmail = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
	       if(hasEmail){
	    	   vo.setEmail(element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString());
	    	   vo.setSns_email(element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString());
	       }
	       
	       boolean hasPhoneNumber = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_phone_number").getAsBoolean();
	       if(hasPhoneNumber){
	    	   vo.setPhone(element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("phone_number").getAsString());
	       }

	       br.close();

	       } catch (IOException e) {
	            e.printStackTrace();
	       }
	    
		return vo;
	}
	
	@Override
	public List<MemberVO> getMemberListGet() throws Exception {
		logger.debug(" getMemberListGet() 실행 ");

		return sql.selectList(NAMESPACE+".memberListGet");
	}


	@Override
	public void updateMember(MemberVO vo) throws Exception {
		logger.debug(" updateMember(MemberVO vo) 실행 ");

		sql.update(NAMESPACE+".updateMember", vo);
	}



	
	
	

	
	
	
	
	
	
	
	
	
	
}// DAOImpl
