<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>


<h1>main.jsp</h1>

<%-- cri : ${cri } <br>

cri.page : ${param.page} <br>
cri.pageSize : ${param.pageSize} <br>

pageVO : ${pageVO} <br>

${mainList} <br>
	${code} <br> --%>

<input type="button" value="전체" onclick="location.href='/release/main'">
<input type="button" value="검수" onclick="location.href='/release/inspection'">
<input type="button" value="출고" onclick="location.href='/release/release'">
<input type="button" value="에러" onclick="location.href='/release/error'">

<div class="content">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">출고 메인</h3>
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
						<th>입고날짜</th>
						<th>수정날짜</th>
						<th>출고날짜</th>

					</tr>
					<c:forEach var="mainList" items="${mainList}">
						<tr>
							<td>
								<form action="" method="post">
								<input type="hidden" name="page" value=${cri.page }>
								<input type="hidden" name="pageSize" value=${cri.pageSize }>
									<c:choose>
										<c:when test="${mainList.divcode==4}">
											<select name="divcode" aria-controls="example1" class="form-control input-sm">
												<c:forEach var="code" items="${code}">
													<c:if test="${code.divcode != 4 && code.divcode != 6 && code.divcode != 8}">
														<option value="${code.divcode}">${code.korname}</option>
													</c:if>
												</c:forEach>
											</select>
											<input type="hidden" name="pno" value="${mainList.pno}">
											<div class="box-footer">
												<button type="submit" class="btn btn-danger">수정하기</button>
											</div>
										</c:when>
										<c:when test="${mainList.divcode==5 }">
											<input type="text" value="출고검수" readonly="readonly">
										</c:when>

										<c:when test="${mainList.divcode==6 }">
											<input type="text" value="출고완료" readonly="readonly">
										</c:when>
										
										<c:when test="${mainList.divcode==8 }">
											<input type="text" value="제품 불량" readonly="readonly">
										</c:when>
									</c:choose>
								</form>
							</td>
							<td>${mainList.id}</td>
							<td><a href="/release/information?pno=${mainList.pno}&page=${cri.page}&pageSize=${cri.pageSize}">${mainList.pno}</a></td>
							<td>${mainList.order_count}</td>
							<td>${mainList.price}</td>
							<td>${mainList.order_date}</td>
							<td>${mainList.update_date}</td>
							<td>${mainList.release_date}</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				<c:if test="${pageVO.prev}">
				<li><a href="/release/main?page=${pageVO.startPage-1}">«</a></li>
				</c:if>
				
				<c:forEach var="idx" begin="${pageVO.startPage}" end="${pageVO.endPage}" step="1">
				<li ${pageVO.cri.page == idx? "class=active":""}>
					<a href="/release/main?page=${idx}">${idx}</a></li>
				</c:forEach>
				
				<c:if test="${pageVO.next}">
				<li><a href="/release/main?page=${pageVO.endPage+1}">»</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>