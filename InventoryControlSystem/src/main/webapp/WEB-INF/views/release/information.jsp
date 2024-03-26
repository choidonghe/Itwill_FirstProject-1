<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

<h1>informatin.jsp</h1>

<%-- ${infoList}<br> --%>


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
						<th>pname</th>
						<th>category</th>
						<th>release_date</th>
						<th>update_date</th>
						<th>price</td>
						<th>order_date</th>
						<th>order_count</th>
						<th>delivery_company</th>
						<th>delivery_phone</th>
						<th>delivery_manager</th>
					</tr>

					<tr>
						<td>${infoList.divcode}</td>
						<td>${infoList.id}</td>
						<td>${infoList.pno}</td>
						<td>${infoList.pname}</td>
						<td>${infoList.category}</td>
						<td>${infoList.release_date}</td>
						<td>${infoList.update_date}</td>
						<td>${infoList.price}</td>
						<td>${infoList.order_date}</td>
						<td>${infoList.order_count}</td>
						<td>${infoList.delivery_phone}</td>
						<td>${infoList.delivery_manager}</td>
						<td>
							<input type="button" name="pno" value="수정" class="btn btn-success" onclick="location.href='/release/modify?pno=${infoList.pno}&page=${cri.page}&pageSize=${cri.pageSize}'">
								<form role="form" action="" method="POST">
								<input type="hidden" name="page" value=${cri.page }>
								<input type="hidden" name="pageSize" value=${cri.pageSize }>
									<input type="hidden" value="${infoList.pno}">
									<input type="button" value="삭제" class="btn btn-danger">
								</form>
						</td>
					</tr>
				</tbody>
			</table>

		</div>
		<div class="box-footer clearfix">
			<button onclick="history.back()">뒤로가기</button>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {

		$(".btn-danger").click(function() {
			var formObj = $("form[role='form']");

			var deleteInfo = confirm('삭제하시겠습니까?');
			if (deleteInfo) {
				
				formObj.submit();
			} else {
				location.href = "/release/main";
			}
		});
	});
</script>





<%@ include file="../include/footer.jsp"%>

