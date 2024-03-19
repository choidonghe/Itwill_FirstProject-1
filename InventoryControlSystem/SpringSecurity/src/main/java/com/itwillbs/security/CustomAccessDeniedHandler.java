package com.itwillbs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

// 접근권한이 없을경우 처리하는(페이지 리다이렉트) 객체
public class CustomAccessDeniedHandler implements AccessDeniedHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		logger.info(" CustomAccessDeniedHandler_handle() 실행 ");
		logger.info(" 접근권한이 없음! ");
		
		// 에러페이지로 이동(redirect)
		response.sendRedirect("/accessErr");
		
	}
		
	
}
