<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp"%>

	<h1>main.jsp</h1>
	
	${List} <br>
	
	<%-- <form role="form" action="" method="get" class="fm">	
		<input type="hidden" name="divcode" value="${vo.divcode}">
	</form> --%>
	
	<table border="1">
		<tr>
			<td>divcode</td>
			<td>id</td>
			<td>pno</td>
			<td>pname</td>
			<td>release_date</td>
			<td>order_date</td>
			<td>order_count</td>
		</tr>
		
		<c:forEach var="List" items="${List}">
			<tr>
				<td>${List.divcode}</td>
				<td>${List.id}</td>
				<td>
				<a href="/release/information?divcode=${List.divcode}">${List.pno}</a>
				</td>
				<td>${List.pname}</td>
				<td>${List.release_date}</td>
				<td>${List.order_date}</td>
				<td><input type="text" name="order_count"></td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- <script>
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		
		$(".a").click(function(){
			alert(" 상세정보  ! ")
			
			formObj.attr("action","/release/information");
			formObj.submit();
		});
	});
	
	</script> -->
	
<%@ include file="../include/footer.jsp"%>