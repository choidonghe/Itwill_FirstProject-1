<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp"%>

	<h1>main.jsp</h1>
	
	${mainList} <br>

	<table border="1">
		<tr>
			<td>divcode</td>
			<td>id</td>
			<td>pno</td>
			<td>pname</td>
			<td>release_date</td>
			<td>order_date</td>
			<td>order_count</td>
			<td>code_div</td>
		</tr>
		
		<c:forEach var="mainList" items="${mainList}">
		
			<tr>
				<td>${mainList.divcode}</td>
				<td>${mainList.id}</td>
				<td>
				<a href="/release/information?pno=${mainList.pno}">${mainList.pno}</a>
				</td>
				<td>${mainList.pname}</td>
				<td>${mainList.release_date}</td>
				<td>${mainList.order_date}</td>
				<td>${mainList.order_count}</td>

			</tr>
		</c:forEach>
	</table>

<%@ include file="../include/footer.jsp"%>