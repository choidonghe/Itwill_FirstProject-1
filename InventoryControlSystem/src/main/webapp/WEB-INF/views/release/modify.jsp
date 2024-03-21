<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ include file="../include/header.jsp"%>

	<h1>modify.jsp</h1>
	
	${modify} <br>
	
	<fieldset>
		<form action="" method="post">
			
			주문품번 : <input type="text" name="divcode" value="${modify[0].divcode}"> <br>
			주문품명 : <input type="text" name="pno" value="${modify[0].pno}"> <br>
			일반주문개수 : <input type="text" name="order_count" value="${modify[0].order_count}"> <br>
			<input type="text" name="" value="${modify[0].release_date}"> <br>
			<input type="text" name="" value="${modify[0].update_date}"> <br>
<%-- 			<input type="" name="" value="${modify[0].code_div}"> --%>
			
			<input type="submit" value="수정">
		</form>
	</fieldset>
	
	<%-- <table border="1">
		<tr>
			<td>주문품번</td>
			<td>주문품명</td>
			<td>일반주문개수</td>
			<td>출고일자</td>
			<td>수정일자</td>
			<td>상태코드</td>
			
		</tr>
		
		<c:forEach var="modify" items="${modify}">
			<tr>
				<td>${modify.divcode}</td>
				<td>${modify.pno}</td>
				<td>${modify.order_count}</td>
				<td>${modify.release_date}</td>
				<td>${modify.update_date}</td>
				<td>${modify.code_div}</td>
				
			</tr>
		</c:forEach>
	</table> --%>
	

	
<%@ include file="../include/footer.jsp"%>
			
	
			
	

	

