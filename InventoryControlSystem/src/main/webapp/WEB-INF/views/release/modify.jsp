<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<%@ include file="../include/header.jsp"%>
	
	<h1>modify.jsp</h1>
	
	${modifyList} <br>
	${code} <br>
	
	<form action="" method="post">
	
		<table border="1">
			<tr>
				<td>divcode</td>
				<td>id</td>
				<td>pno</td>
				<td>pname</td>
				<td>order_count</td>
			</tr>
			<tr>
	
				<td>
					<select name="divcode">
						<c:forEach var="code" items="${code}">
							<option value="${code.divcode}">${code.korname}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type="text" name="id" value="${modifyList.id}" readonly="readonly">
				</td>
				<td>
					<input type="text" value="${modifyList.pno}" readonly="readonly">
				</td>
				<td>
					<input type="text" name="pname" value="${modifyList.pname}" readonly="readonly">
				</td>
				<td>
					<input type="text" name="order_count" value="${modifyList.order_count}">
				</td>
			</tr>
		</table>
	
		<input type="hidden" value="${modifyList.pno}"> 
		<input type="submit" value="수정">
		<button onclick="history.back()">뒤로가기</button>
	
	</form>
	
	<%@ include file="../include/footer.jsp"%>
	
