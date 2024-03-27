<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

	<h1>modify.jsp</h1>
	
	<%-- ${modifyList} <br>
	${code} <br> --%>
	
	<form action="" method="post">
		<input type="hidden" name="page" value=${cri.page }>
		<input type="hidden" name="pageSize" value=${cri.pageSize }>
		
		<div class="content">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">제품 수정</h3>
				</div>
	
				<div class="box-body">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>상태</th> 
								<th>제품번호</th> 
								<th>제품명</th> 
								<th>수량</th> 
							</tr>
	
							<tr>
								<td>
<%-- 								<c:if test="${id eq 'admin}"> --%>
										<select name="divcode">
												<c:forEach var="code" items="${code}">
													<option value="${code.divcode}">${code.korname}</option>
												</c:forEach>
										</select>
<%-- 									</c:if> --%>
								</td>
								<td><input type="text" value="${modifyList.pno}" readonly="readonly"></td>
								<td><input type="text" name="pname" value="${modifyList.pname}" readonly="readonly"></td>
								<td><input type="text" name="order_count" value="${modifyList.order_count}"></td>
							</tr>
						</tbody>
					</table>
					<input type="hidden" value="${modifyList.pno}">
					<input type="submit" value="수정" class="btn btn-danger">
	
				</div>
				<div class="box-footer clearfix">
					<button onclick="history.back()">메인으로</button>
					<ul class="pagination pagination-sm no-margin pull-right">
					</ul>
				</div>
			</div>
		</div>
	</form>




<%@ include file="../include/footer.jsp"%>

