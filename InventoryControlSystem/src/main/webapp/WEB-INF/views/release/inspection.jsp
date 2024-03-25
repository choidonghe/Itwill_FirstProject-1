<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp"%>

	<h1>inspection.jsp</h1>
	
	${vo} <br>
	
	<input type="button" value="전체" onclick="location.href='/release/main'">
	<input type="button" value="출고" onclick="location.href='/release/release'">
	
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
		
		<c:forEach var="vo" items="${vo}">
		<c:if test="${vo.divcode==5 }">
			<tr>
				<td>
					<form action="" method="post">
					
					<select name="divcode" aria-controls="example1" class="form-control input-sm">
						<c:forEach var="code" items="${code}">
							<c:if test="${code.divcode != 4}">
                                <option value="${code.divcode}">${code.korname}</option>
                            </c:if>
						</c:forEach>
					</select>
					
					<input type="hidden" name="pno" value="${vo.pno}">
					<input type="submit" value="수정">
					
					</form>
				</td>
				<td>${vo.id}</td>
				<td>${vo.pno}</td>
				<td>${vo.pname}</td>
				<td>${vo.release_date}</td>
				<td>${vo.order_date}</td>
				<td>${vo.order_count}</td>

			</tr>
			</c:if>
		</c:forEach>
	</table>


<%@ include file="../include/footer.jsp"%>