<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<div class="box">
	<div class="box-header">
		<h3 class="box-title">현재 재고</h3>
	</div>

	<div class="box-body">
		<div id="example1_wrapper"
			class="dataTables_wrapper form-inline dt-bootstrap">
			<div class="row">
				<div class="col-sm-6">
					<div class="dataTables_length" id="example1_length">
						<label>Show <select name="example1_length"
							aria-controls="example1" class="form-control input-sm">
							<option value="10">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
								<option value="100">100</option></select> entries
						</label>
					</div>
				</div>
				<div class="col-sm-6">
					<div id="example1_filter" class="dataTables_filter">
						<label>검색 : <input type="search"
							class="form-control input-sm" placeholder=""
							aria-controls="example1">
						</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<table id="example1"
						class="table table-bordered table-striped dataTable" role="grid"
						aria-describedby="example1_info">
						<thead>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Rendering engine: activate to sort column descending"
									style="width: 297.469px;">
									제품 코드</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="Browser: activate to sort column ascending"
									style="width: 361.984px;">
									제품 카테고리</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="Platform(s): activate to sort column ascending"
									style="width: 322.266px;">
									품목명</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="Engine version: activate to sort column ascending"
									style="width: 257.094px;">
									제조회사</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="CSS grade: activate to sort column ascending"
									style="width: 188.188px;">
									수량</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="CSS grade: activate to sort column ascending"
									style="width: 188.188px;">
									바코드 번호</th>
							</tr>
						</thead>
						<!-------------------------- 제품 내용 넣는 곳 -------------------------->
						<tbody>
						<c:forEach var="i" begin="1" end="10" >
							<tr>
								<th>아</th>
								<th>잉</th>
								<th>ㅇ</th>
								<th>ㅍ</th>
								<th>ㅇ</th>
								<th>33</th>							
							</tr>
						</c:forEach>
						</tbody>
						<!-------------------------- 제품 내용 넣는 곳 -------------------------->
						<tfoot>
							<tr>
								<th rowspan="1" colspan="1">제품 코드</th>
								<th rowspan="1" colspan="1">제품 카테고리</th>
								<th rowspan="1" colspan="1">품목명</th>
								<th rowspan="1" colspan="1">제조회사</th>
								<th rowspan="1" colspan="1">수량</th>
								<th rowspan="1" colspan="1">바코드 번호</th>								
							</tr>
						</tfoot>
					</table>
				</div>
			</div>

		</div>
	</div>

</div>



<%@ include file="../include/footer.jsp"%>
