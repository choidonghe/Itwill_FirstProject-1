<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp"%>

	<h1>informatin.jsp</h1>
	
	${infoList} <br>

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
		<tr>
			<td>${infoList.divcode}</td>
			<td>${infoList.id}</td>
			<td>${infoList.pno}</td>
			<td>${infoList.pname}</td>
			<td>${infoList.category}</td>
			<td>${infoList.release_date}</td>
			<td>${infoList.update_date}</td>
			<td>${infoList.price}</td>
			<td>${infoList.order_date}</td>
			<td>${infoList.order_count}</td>
			<td>${infoList.delivery_phone}</td>
			<td>${infoList.delivery_manager}</td>
			<td>
			<input type="button" name="pno" value="수정" onclick="location.href='/release/modify?pno=${infoList.pno}';">
			<form action="" method="POST">
				<input type="hidden" value="${infoList.pno}">
				<input type="submit" value="삭제">
			</form>
			</td>
		</tr>
	</table>

	<button onclick="history.back()">뒤로가기</button>

<%@ include file="../include/footer.jsp"%>

			