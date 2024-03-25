<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

	<h1>modify.jsp</h1>
	
	<%-- ${modifyList} <br>
	${code} <br> --%>
	
	<form action="" method="post">
		<div class="content">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">제품 상세 정보</h3>
				</div>
	
	
				<div class="box-body">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>divcode</th>
								<th>id</th>
								<th>pno</th>
								<th>pname</v>
								<th>order_count</th>
							</tr>
	
							<tr>
								<td><select name="divcode">
										<c:forEach var="code" items="${code}">
											<option value="${code.divcode}">${code.korname}</option>
										</c:forEach>
								</select></td>
								<td><input type="text" name="id" value="${modifyList.id}" readonly="readonly"></td>
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

