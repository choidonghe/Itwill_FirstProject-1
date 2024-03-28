<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>


<%--  ${infoList}<br> 

<h1>informatin.jsp</h1>  --%>




	<div class="content">
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">제품 상세 정보</h3>
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
							<th>입고자</th>
							<th>입고날짜</th>
							<th>수정자</th>
							<th>수정날짜</th> 
							<th>출고자</th>
							<th>출고날짜</th> 
							<th>출고 수량</th>
							<th>불량 수량</th>
							<th>배송 업체</th>
							<th>전화번호</th>
							<th>배송자</th>
							<th>관리</th>
						</tr>
	
						<tr>
							<td>${infoList.divcode}</td>
							<td>${infoList.pno}</td>
							<td>${infoList.pname}</td>
							<td>${infoList.order_count}</td>
							<td>${infoList.price}</td>
							<td>${infoList.id}</td>
							<td>${infoList.order_date}</td>
							<td>${infoList.modify_id}
							<td>${infoList.update_date}</td>
							<td>${infoList.release_id}
							<td>${infoList.release_date}</td>
							<td>${infoList.release_count}</td>
							<td>${infoList.count}</td>
							<td>${infoList.delivery_company}</td>
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
				<button onclick="location.href='/release/main'">메인으로</button>
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

