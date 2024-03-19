<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>accessErr.jsp</h1>
		
		<h2> 잘못된 접근입니다. 관리자에게 문의하세요.</h2>
		
		<a href="/all">메인페이지로 이동</a>
		
		<input type="button" value="이전페이지로" onclick=" history.back(); ">
		
		
		<%
		    // 새로고침 + 페이지 이동
			//response.addHeader("Refresh", "3, url=/all");
		
		%>
		
		
		
</body>
</html>