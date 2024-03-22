<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ include file="../include/header.jsp"%>

	<h1>modify.jsp</h1>
	
	${modifyList} <br>
	
	<fieldset>
		<form action="" method="post">
			
			주문품번 : <input type="text" name="pno" value="${modifyList.pno}"> <br>
			주문품명 : <input type="text" name="pname" value="${modifyList.pname}"> <br>
			일반주문개수 : <input type="text" name="order_count" value="${modifyList.order_count}"> <br>

			<input type="submit" value="수정">
			<button onclick="history.back()">뒤로가기</button>
		</form>
	</fieldset>

<%@ include file="../include/footer.jsp"%>
			
