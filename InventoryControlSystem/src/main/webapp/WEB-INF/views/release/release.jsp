<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<%@ include file="../include/header.jsp"%>

	<h1>release.jsp</h1>
	
	${release}
	
	<fieldset>
		<form action="" method="post">
			주문번호 : <input type="text" name="pno" value="${release[0].pno}" readonly="readonly">
			제품명 : <input type="text" name="pname" value="${release[0].pname}" readonly="readonly">
			출고 수량 : <input type="text" name="order_count" value="${release[0].order_count}" readonly="readonly"> <br>
			
			<input type="submit" value="출고 확인">
			<button onclick="history.back()">뒤로가기</button>
		</form>
	</fieldset>
	

<%@ include file="../include/footer.jsp"%>