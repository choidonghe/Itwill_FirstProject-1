<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>


<button class = "upButton">
	<i class = "glyphicon glyphicon-menu-up" style = "margin : auto;"></i>
</button>
<script>
    document.querySelector('.upButton').addEventListener('click', function() {
        window.scrollTo({ top: 0, behavior: 'smooth' });
    });
</script>


	<input type="button" value="전체" onclick="location.href='/release/main'">
	<input type="button" value="검수" onclick="location.href='/release/inspection'">
	<input type="button" value="불량" onclick="location.href='/release/error'">
	
	
	<div class="content">
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">출고 검수완료</h3>
			</div>
	
			<div class="box-body">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<th>상태</th> 
							<th>제품번호</th> 
							<th>제품명</th> 
							<th>출고 수량</th>
							<th>가격</th> 
							<th>입고날짜</th> 
							<th>수정날짜</th> 
							<th>출고날짜</th> 
							<th>배송 업체</th>
							<th>전화번호</th>
							<th>배송자</th>
						</tr>
	
	
						<c:forEach var="vo" items="${vo}">
	<%-- 					<c:if test="${vo.divcode==6 }"> --%>
<%-- 							<c:if test="${vo.release_count > 0 }"> --%>
							<tr>
								<td>
									<c:forEach var="code" items="${code}">
										<c:if test="${code.divcode != 4 && code.divcode != 5 && code.divcode != 8}">
											<input type="text" value="${code.korname}" readonly="readonly">
										</c:if>
									</c:forEach>
								</td>
								<td>${vo.pno}</td>
								<td>${vo.pname}</td>
								<td>${vo.release_count}</td>
								<td>${vo.price}</td>
								<td>${vo.order_date}</td>
								<td>${vo.update_date}</td>
								<td>${vo.release_date}</td>
								<td>${vo.delivery_company}</td>
								<td>${vo.delivery_phone}</td>
								<td>${vo.delivery_manager}</td>
							</tr>
	<%-- 						</c:if> --%>
<%-- 	</c:if> --%>
						</c:forEach>
					</tbody>
				</table>
	
			</div>
			<div class="box-footer clearfix">
	
				<button onclick="location.href='/release/main'">메인으로</button>
	
				<ul class="pagination pagination-sm no-margin pull-right">
					<c:if test="${pageVO.prev}">
						<li><a href="/release/release?page=${pageVO.startPage-1}">«</a></li>
					</c:if>
	
					<c:forEach var="idx" begin="${pageVO.startPage}" end="${pageVO.endPage}" step="1">
						<li ${pageVO.cri.page == idx? "class=active":""}><a href="/release/release?page=${idx}">${idx}</a></li>
					</c:forEach>
	
					<c:if test="${pageVO.next}">
						<li><a href="/release/release?page=${pageVO.endPage+1}">»</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>







<%@ include file="../include/footer.jsp"%>