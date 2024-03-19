<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>customLogin.jsp</h1>
    
    <h2> 아이티윌 로그인 페이지 </h2>
    
    
   	<fieldset>
   		<form action="/login" method="post">
			아이디 : <input type="text" name="username"> <br>
			비밀번호 : <input type="password" name="password"> <br>
			<input type="submit" value="로그인">   	
			
			<!-- csrf 토큰값 생성(필수) , POST방식 처리-->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
   		</form>
   	</fieldset>
    
    
    
    

</body>
</html>