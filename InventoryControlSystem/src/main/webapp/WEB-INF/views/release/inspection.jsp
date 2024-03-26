<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

<%-- cri=${cri } <br>
pageVO=${pageVO } <br>
${vo} <br> --%>


<script type="text/javascript">

	$(document).ready(function(){
		
		$(".btn-danger").click(function(){
			
			var order_count= document.getElementById("order_count").value;
			consol.log(order_count);
			alert('ㅇㅇ');
			return false;
		});
	});

</script>
<h1>inspection.jsp</h1>


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
						<th>order_count</th>
					</tr>

					<c:forEach var="vo" items="${vo}">
					<c:if test="${vo.divcode==5 || vo.divcode == 8}">
						<tr>
							<td>
								<form action="" method="post" onsubmit="return test()">
										<select name="divcode" aria-controls="example1" class="form-control input-sm">
											<c:forEach var="code" items="${code}">
												<c:if test="${code.divcode != 4}">
													<option value="${code.divcode}">${code.korname}</option>
												</c:if>
											</c:forEach>
										</select>
										<input type="text" name="order_count" placeholder="출고 수량을 적으세요.">
										<input type="hidden" name="pno" value="${vo.pno}">
										<input type="button" value="수정" class="btn btn-danger">
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