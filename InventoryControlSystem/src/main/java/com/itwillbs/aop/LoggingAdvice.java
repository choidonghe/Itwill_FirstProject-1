package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 로그출력객체 - Advice
public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println(" 보조기능 : LoggingAdvice 실행");
		System.out.println(" 주기능 "+invocation.getMethod()+" 실행 전");
		
		// 주기능 호출
		Object obj = invocation.proceed();
		
		System.out.println(" 주기능 "+invocation.getMethod()+" 실행 후");
		System.out.println(" 보조기능 : LoggingAdvice 실행끝 ");
		
		return obj;
	}

}
