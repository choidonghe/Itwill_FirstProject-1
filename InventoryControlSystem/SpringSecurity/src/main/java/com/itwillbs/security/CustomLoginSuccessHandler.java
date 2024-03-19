package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		logger.info(" CustomLoginSuccessHandler_onAuthenticationSuccess() 호출 ");
		logger.info(" 인증성공(로그인 성공,토큰정보O) 후 처리 수행");
		
		// 권한정보를 저장하는 리스트
		List<String> roleNames = new ArrayList<String>();
		
		// * 이클립스 기능 : 익명클래스 -> 람다표현식  해당영역 블럭 + ctrl + 1
//		auth.getAuthorities().forEach(new Consumer<GrantedAuthority>() {
//			@Override
//			public void accept(GrantedAuthority authority) {
//				roleNames.add(authority.getAuthority());
//			}
//		});
		
		auth.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
		
		logger.info(" roleNames : "+roleNames);
		
		
		// 권한별로 이동가능한 페이지 호출
		if(roleNames.contains("ROLE_ADMIN")) {//관리자 권한
			logger.info(" 관리자 권한 아이디 로그인! ");
			response.sendRedirect("/admin");
			return;			
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {//회원 권한
			logger.info(" 회원 권한 아이디 로그인! ");
			response.sendRedirect("/member");
			return;			
		}
		
		
		// 권한이 없는 일반로그인/접근
		logger.info(" 권한이 없는 (비회원) 로그인! ");
		response.sendRedirect("/all");
		
		
		
	}
	
	
}
