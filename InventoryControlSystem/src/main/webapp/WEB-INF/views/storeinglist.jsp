<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입고예정</h1>
	${storeIngList }
	<table border="1">
		<tr>
			<th>상태</th>
			<th>제품번호</th>
			<th>제품명</th>
			<th>수량</th>
			<th>카테고리</th>
			<th>가격</th>
			<th>입고일</th>
			<th>수정일</th>
			<th>계좌코드</th>
		</tr>
		<c:forEach var="store" items="${storeIngList}">
		<tr>
			<td>${store.divcode }</td>
			<td>${store.pno }</td>
			<td>${store.pname }</td>
			<td>${store.count }</td>
			<td>${store.category }</td>
			<td>${store.price }</td>
			<td>${store.store_date }</td>
			<td>${store.update_date }</td>
			<td>${store.account_code }</td>
		</tr>
		</c:forEach>
		
		
	</table>
	
</body>
</html>