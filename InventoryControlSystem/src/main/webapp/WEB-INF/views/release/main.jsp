<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp"%>

	<h1>main.jsp</h1>
	
	${List} <br>
	
	<form role="form" action="" method="get" class="fm">	
		<input type="hidden" name="divcode" value="${List[0].divcode}">
	</form>
	
	<input type="button" name="q" value="전체">
	<input type="button" name="w" value="출고">
	<input type="button" name="e" value="미출고">
	
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
				<td>${List.order_count}</td>
				
				<td>
				<!-- code_div -->
				</td>
				
				<td>
				<a href="/release/modify?divcode=${List.divcode}"><input type="button" name="modify" value="수정"></a>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	
	<input type="submit" value="출고" class="release">
	

	
	<script>
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		
		$(".release").click(function(){
			
			formObj.attr("action","/release/release");
			formObj.submit();
		});
	});
	
	</script>
	
<%@ include file="../include/footer.jsp"%>