<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp"%>

	<h1>main.jsp</h1>
	
	${mainList} <br>
	${code} <br>
	
	<input type="button" value="전체" onclick="location.href='/release/main'">
	<input type="button" value="검수" onclick="location.href='/release/inspection'">
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
		
		<c:forEach var="mainList" items="${mainList}">
		
			<tr>
				<td>
					<form action="" method="post">
					<c:choose>
					<c:when test="${mainList.divcode==4 }">
					<select name="divcode" aria-controls="example1" class="form-control input-sm">
						<c:forEach var="code" items="${code}">
							<c:if test="${code.divcode != 6}">
                                <option value="${code.divcode}">${code.korname}</option>
                            </c:if>
						</c:forEach>
					</select>
					<input type="hidden" name="pno" value="${mainList.pno}">
					<input type="submit" value="수정">
					</c:when>
					
					<c:when test="${mainList.divcode==5 }">
						<input type="text" value="출고검수" readonly="readonly">
						</c:when>
						
					<c:when test="${mainList.divcode==6 }">
						<input type="text" value="출고완료" readonly="readonly">
					</c:when>
					</c:choose>
					</form>
					
				</td>
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