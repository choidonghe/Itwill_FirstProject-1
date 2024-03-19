<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp"%>

	<h1>main.jsp</h1>
	
	${List}
	
	<table border="1">
		<tr>
			<td>divcode</td>
			<td>id</td>
			<td>pno</td>
			<td>pname</td>
			<td>category</td>
			<td>release_date</td>
			<td>update_date</td>
			<td>price</td>
			<td>order_date</td>
			<td>order_count</td>
			<td>delivery_company</td>
			<td>delivery_phone</td>
			<td>delivery_manager</td>
		</tr>
		
		<c:forEach var="List" items="${List}">
			<tr>
				<td>${List.divcode}</td>
				<td>${List.id}</td>
				<td>${List.pno}</td>
				<td>${List.pname}</td>
				<td>${List.category}</td>
				<td>${List.release_date}</td>
				<td>${List.update_date}</td>
				<td>${List.price}</td>
				<td>${List.order_date}</td>
				<td>${List.order_count}</td>
				<td>${List.delivery_phone}</td>
				<td>${List.delivery_manager}</td>
			</tr>
		</c:forEach>
	</table>
	
<%@ include file="../include/footer.jsp"%>