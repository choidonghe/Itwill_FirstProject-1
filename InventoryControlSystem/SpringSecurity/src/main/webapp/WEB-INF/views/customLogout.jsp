<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>customLogout.jsp</h1>
		
		<form action="/customLogout" method="post">
			<!-- 폼태그정보를 post방식으로 전달할때 csrf토큰정보 필요  -->
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
			<input type="submit" value="로그아웃">
		</form>
		
</body>
</html>