<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

<h1>inspection.jsp</h1>

<%-- ${vo} <br> --%>

<input type="button" value="전체" onclick="location.href='/release/main'">
<input type="button" value="출고" onclick="location.href='/release/release'">

<div class="content">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">출고 검수</h3>
		</div>

		<div class="box-body">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>divcode</th>
						<th>id</th>
						<th>pno</th>
						<th>pname</th>
						<th>release_date</th>
						<th>order_date</th>
						<th>order_count</th>
						<th>code_div</th>
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
										<input type="submit" value="수정" class="btn btn-danger">
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



<%@ include file="../include/footer.jsp"%>