<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

<%-- cri=${cri } <br>
pageVO=${pageVO } <br>--%>
${vo} <br> 


<h1>inspection.jsp</h1>


<input type="button" value="전체" onclick="location.href='/release/main'">
<input type="button" value="출고" onclick="location.href='/release/release'">
<input type="button" value="에러" onclick="location.href='/release/error'">



<div class="content">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">출고 검수</h3>
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
					</tr>
					
					<c:forEach var="vo" items="${vo}">
<%-- 					<c:if test="${vo.divcode==5 || vo.divcode == 8}"> --%>
						<c:if test="${vo.order_count > 0 }">
						<tr>
							<td>
								<form action="" method="post" onsubmit="return test()">
										<select name="divcode" aria-controls="example1" class="form-control input-sm">
											<c:forEach var="code" items="${code}">
												<c:if test="${code.divcode != 4 && code.divcode != 5 && code.divcode != 8}">
													<option value="${code.divcode}">${code.korname}</option>
												</c:if>
											</c:forEach>
										</select>
										<input type="text" name="release_count" placeholder="수량을 적으세요." required="required">
										<input type="hidden" name="pno" value="${vo.pno}">
										<input type="submit" value="수정" class="btn btn-danger">
								</form>
							</td>
							<td>${vo.pno}</td>
							<td>${vo.pname}</td>
							<td>${vo.order_count}</td>
							<td>${vo.order_date}</td>
							<td>${vo.release_date}</td>
						</tr>
<%-- 						</c:if> --%>
</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
			
		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				<c:if test="${pageVO.prev}">
					<li><a href="/release/inspection?page=${pageVO.startPage-1}">«</a></li>
				</c:if>

				<c:forEach var="idx" begin="${pageVO.startPage}" end="${pageVO.endPage}" step="1">
					<li ${pageVO.cri.page == idx? "class=active":""}><a href="/release/inspection?page=${idx}">${idx}</a></li>
				</c:forEach>

				<c:if test="${pageVO.next}">
					<li><a href="/release/inspection?page=${pageVO.endPage+1}">»</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>





<%@ include file="../include/footer.jsp"%>