<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>

<div class="content">
	<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">입고예정</h3>
	</div>
	
	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
			<tr>
				<th>상태</th>
				<th>제품번호</th>
				<th>제품명</th>
				<th>수량</th>
				<th>카테고리</th>
				<th>가격</th>
				<th>입고일</th>
				<th>수정일</th>
				<th>계좌코드</th>
			</tr>
			<c:forEach var="store" items="${storeIngList}">
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
					<input type="submit" value="수정">
					</form>
				</td>
				<td>${store.pno }</td>
				<td>${store.pname }</td>
				<td>${store.count }</td>
				<td>${store.category }</td>
				<td>${store.price }</td>
				<td>${store.store_date }</td>
				<td>${store.update_date }</td>
				<td>${store.account_code }</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="box-footer">
			<button type="submit" class="btn btn-danger">수정하기</button>
		</div>
	</div>
		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				<li><a href="#">«</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">»</a></li>
			</ul>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp" %>