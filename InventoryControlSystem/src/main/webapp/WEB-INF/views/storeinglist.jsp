<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>

<div class="content">
	<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">입고예정</h3>
		${spageVO }
	</div>
	
	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
			<tr>
				<th>상태</th>
				<th>제품번호</th>
				<th>제품명</th>
				<th>수량</th>
				<th>가격</th>
				<th>판매가격</th>
				<th>계좌코드</th>
				
			</tr>
			<c:forEach var="store" items="${productList}">
			<tr>
				<td>
					<form action="update" method="post">
					<c:if test="${store.divcode==1 }">
					<select name="divcode" aria-controls="example1" class="form-control input-sm">
						<c:forEach var="code" items="${codeList }">
							<option value="${code.divcode }">${code.korname }</option>
						</c:forEach>
					</select>
					</c:if>
					<input type="hidden" name="pno" value="${store.pno }">
					<input type="hidden" name="pname" value="${store.pname }">
					<input type="hidden" name="count" value="${store.count }">
					<input type="hidden" name="remain_count" value="${store.remain_count }">
					<input type="hidden" name="regdate" value="${store.regdate }">
					<input type="hidden" name="warehouse_code" value="${store.warehouse_code }">
					<input type="hidden" name="category_code" value="${store.category_code }">
					
					<input type="submit" value="수정">
					</form>
				</td>
				<td>${store.pno }</td>
				<td>${store.pname }</td>
				<td>${store.count }</td>
				<td>${store.price }</td>
				<td>${store.sales_price }</td>
				<td>${store.account_code }</td>
				
			</tr>
			</c:forEach>
			</tbody>
		</table>
<!-- 		<div class="box-footer"> -->
<!-- 			<button type="submit" class="btn btn-danger">수정하기</button> -->
<!-- 		</div> -->
	</div>
		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
			<c:if test="${spageVO.prev }">
				<li><a href="/storeinglist?page=${spageVO.startPage - 1 }">«</a></li>
			</c:if>
			<c:forEach var="idx" begin="${spageVO.startPage }" end="${spageVO.endPage }" step="1">
				<li ${spageVO.cri.page == idx? "class=active": ""}><a href="/storeinglist?page=${idx }">${idx }</a></li>
			</c:forEach>
			<c:if test="${spageVO.next }">
				<li><a href="/storeinglist?page=${spageVO.endPage + 1 }">»</a></li>
			</c:if>
			</ul>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp" %>