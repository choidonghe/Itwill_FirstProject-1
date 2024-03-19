<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${empty param.id}">
		<c:redirect url="/login"/>
	</c:if>


<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.0/kakao.min.js"
 integrity="sha384-l+xbElFSnPZ2rOaPrU//2FF5B4LB8FiX5q4fXYTlfcG4PGpMkE1vcL7kNXI6Cci0" crossorigin="anonymous"></script>
<script>
  Kakao.init('548b10d7782a89ded8a479adc1d32d91'); // 사용하려는 앱의 JavaScript 키 입력
</script>

${param.id }<br>


<button class="api-btn" onclick="kakaoLogout()">로그아웃</button>

<script>
  function kakaoLogout() {
    Kakao.Auth.logout()
      .then(function() {
        alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken());
        deleteCookie();
      })
      .catch(function() {
        alert('Not logged in');
      });
  }


</script>
	

</body>
</html>