<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

<h1>release.jsp</h1>

cri=${cri } <br>
pageVO=${pageVO } <br>
${vo} <br>

<%-- ${vo} <br>
${code} <br> --%>

<input type="button" value="전체" onclick="location.href='/release/main'">
<input type="button" value="검수" onclick="location.href='/release/inspection'">

<div class="content">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">출고 검수완료</h3>
		</div>

		<div class="box-body">
			<table class="table table-bordered">
				<tbody>
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
						<c:forEach var="vo" items="${vo}">
							<c:if test="${vo.divcode==6}">
								<tr>
								<td><input type="text" value="출고완료" readonly="readonly"></td>
								<td>${vo.id}</td>
								<td>${vo.pno}</td>
								<td>${vo.pname}</td>
								<td>${vo.category}</td>
								<td>${vo.release_date}</td>
								<td>${vo.update_date}</td>
								<td>${vo.price}</td>
								<td>${vo.order_date}</td>
								<td>${vo.order_count}</td>
								<td>${vo.delivery_phone}</td>
								<td>${vo.delivery_manager}</td>
								</tr>
							</c:if>
						</c:forEach>
			</table>
		</div>

		<div class="box-footer clearfix">
		
			<button onclick="history.back()">뒤로가기</button>
			
			<ul class="pagination pagination-sm no-margin pull-right">
				<c:if test="${pageVO.prev}">
					<li><a href="/release/release?page=${pageVO.startPage-1}">«</a></li>
				</c:if>
				
				<c:forEach var="idx" begin="${pageVO.startPage}" end="${pageVO.endPage}" step="1">
					<li ${pageVO.cri.page == idx? "class=active":""}>
					<a href="/release/release?page=${idx}">${idx}</a></li>
				</c:forEach>
				
				<c:if test="${pageVO.next}">
					<li><a href="/release/release?page=${pageVO.endPage+1}">»</a></li>
				</c:if>
			</ul>
	</div>
</div>




<%@ include file="../include/footer.jsp"%>