<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>

<!-- 품번 클릭시 제품 상세보기 코드 작성 -->
<script>
document.addEventListener("DOMContentLoaded", function() {
    var productCodes = document.querySelectorAll('td[data-product-code]');
    productCodes.forEach(function(td) {
        td.addEventListener('click', function() {
            var productCode = String(td.dataset.productCode); // 제품 코드를 문자열로 변환
            var popupUrl = '/stock/stockPopUp?pno=' + encodeURIComponent(productCode);
            
            // 팝업창을 가운데에 띄우기 위해 추가한 코드
            var width = 600;
            var height = 600;
            var left = (window.innerWidth - width) / 2;
            var top = (window.innerHeight - height) / 2;
            var popupWindow = window.open(popupUrl, '_blank', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
            
            // 팝업창이 차단되었을 때 대비하여 체크
            if (window.focus) {
                popupWindow.focus();
            }
        });
    });
});
</script>


<!-- 품번 클릭시 제품 상세보기 코드 작성 -->

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
	        				<label>한 페이지에 표시할 항목 수 :
	            				<select name="pageSize" id="pageSizeSelect" onchange="changePageSize()">
					                <option value="10" ${param.pageSize == 10 ? 'selected' : ''}>10</option>
					                <option value="25" ${param.pageSize == 25 ? 'selected' : ''}>25</option>
					                <option value="50" ${param.pageSize == 50 ? 'selected' : ''}>50</option>
					                <option value="100" ${param.pageSize == 100 ? 'selected' : ''}>100</option>
	            				</select>
	        				</label>
					    </div>
					</div>
	
					<!-- 한 페이지에 표시할 항목 수 스크립트 추가 -->	
					<script>
					    function changePageSize() {
					        // 선택된 페이지 크기 가져오기
					        var selectedPageSize = document.getElementById("pageSizeSelect").value;
					        
					        // 검색어와 검색 유형 가져오기
					        var keyword = document.getElementById("searchInput").value.trim();
					        var type = document.getElementById("categorySelect").value;
					        
					        // 검색어가 존재하는 경우에만 URL에 추가
					        var searchParams = "";
					        if (keyword !== "") {
					            searchParams = "&type=" + type + "&keyword=" + encodeURIComponent(keyword);
					        }
					        
					        // 새로운 URL로 이동
					        location.href = "/stock/stockMainCri?page=1&pageSize=" + selectedPageSize + searchParams;
					    }
					</script>
					<!-- 한 페이지에 표시할 항목 수 스크립트 추가 -->

				</div>
				
				
			<!-- 검색창 추가 -->
			<div class="form-group" data-select2-id="37">
			    <form id="searchForm" action="/stock/stockMainCri" method="get"> <!-- 수정된 부분 : 검색을 위한 form 추가 -->
			        <table>
			            <tr>
			                <td>
			                    <select id="categorySelect" name="type" class="form-control select2 select2-hidden-accessible"
			                            style="width: 100%; margin-bottom: 5px;" data-select2-id="1"	 tabindex="-1"
			                            aria-hidden="true">
			                        <option value="all" 
			                        <c:out value = "${pageVO.cri.type eq 'all'?'selected':'' }"/>
			                        selected="selected">전체</option>
			                        <option value="pno"
			                        <c:out value = "${pageVO.cri.type eq 'pno'?'selected':'' }"/>>제품코드</option>
			                        <option value="category"
			                        <c:out value = "${pageVO.cri.type eq 'category'?'selected':'' }"/>>카테고리</option>
			                        <option value="pname"
			                        <c:out value = "${pageVO.cri.type eq 'pname'?'selected':'' }"/>>품목명</option>
			                        <option value="company"
			                        <c:out value = "${pageVO.cri.type eq 'company'?'selected':'' }"/>>제조회사</option>
			                        <option value="warehouse_code"
			                        <c:out value = "${pageVO.cri.type eq 'warehouse_code'?'selected':'' }"/>>창고위치</option>
			                    </select>
			                </td>
			                <td>
			                    <input type="text" id="searchInput" name="keyword" class="form-control" placeholder="검색어 입력"
			                           style="margin-bottom: 5px;" value = "${cri.keyword }"/>
			                </td>
			                
			                <td>
			                    <button id="search-btn" class="btn btn-flat"
			                            style="margin-left: 3px; margin-bottom: 5px;">
			                        <i class="fa fa-search"></i>
			                    </button>
			                </td>
			            </tr>
			        </table>
    				<input type = "hidden" name = "page" value = "${cri.page }">
				<input type = "hidden" name = "pageSize" value = "${cri.pageSize }">
			    </form>
			</div>
			
			<!-- 검색기능 구현 스크립트 추가 -->
			<script>
			    document.addEventListener("DOMContentLoaded", function() {
			        // 폼 요소와 검색 버튼 요소 가져오기
			        var searchForm = document.getElementById("searchForm");
			        var searchBtn = document.getElementById("search-btn");
			
			        // 검색 버튼 클릭 시 이벤트 처리
			        searchBtn.addEventListener("click", function(event) {
			            event.preventDefault(); // 기본 동작 방지 (페이지 새로고침 방지)
			
			            // 검색어 입력 요소 가져오기
			            var searchInput = document.getElementById("searchInput");
			            
			            // 검색어에서 공백 제거
			            var keyword = searchInput.value.trim();
			
			            // 선택된 카테고리 가져오기
			            var type = document.getElementById("categorySelect").value;
			
			            // 페이지 크기 가져오기
			            var pageSize = document.getElementById("pageSizeSelect").value;
			
			            // 새로운 URL로 이동
			            location.href = "/stock/stockMainCri?page=1&pageSize=" + pageSize + "&keyword=" + encodeURIComponent(keyword) + "&type=" + type;
			            
			            searchForm.submit();
			            
			        });
			    });
			</script>
			<!-- 검색기능 구현 스크립트 추가 -->


				
				
			<!-- 재고 차트 -->
			<div class="row">
				<div class="col-sm-12">
					<table id="example1"
						class="table table-bordered table-striped dataTable" role="grid"
						aria-describedby="example1_info" style ="border-collapse: collapse;">
						<thead style = "background-color: #f2f2f2;">
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Rendering engine: activate to sort column descending"
									style="width: 200.469px;">
									제품 코드(클릭 시 상세보기)</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="Browser: activate to sort column ascending"
									style="width: 150.984px;">
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
									style="width: 70.188px;">
									수량</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="CSS grade: activate to sort column ascending"
									style="width: 188.188px;">
									창고위치</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="CSS grade: activate to sort column ascending"
									style="width: 200.188px;">
									출고</th>
							</tr>
						</thead>
						<!-------------------------- 제품 내용 넣는 곳 -------------------------->
						<tbody>
						<c:forEach var="sVO" items="${stockList }" >
							<tr>
								<td data-product-code="${sVO.pno}" style = "vertical-align: middle;">
								${sVO.pno}</td>
								<td style = "vertical-align: middle;">${sVO.category }</td>
								<td style = "vertical-align: middle;">${sVO.pname }</td>
								<td style = "vertical-align: middle;">${sVO.company }</td>
								<td data-available-count="${sVO.count }" style = "vertical-align: middle;">${sVO.count }</td>
								<td style = "vertical-align: middle;">${sVO.warehouse_code }</td>		
								<td>
								<c:if test="${sVO.count eq 0}">
                    			<button type="button" class="btn btn-block btn-danger" style="width: 60px;" disabled>품절</button>
                				</c:if>
                				<c:if test="${sVO.count ne 0}">
                    			<button type="button" class="btn btn-block btn-primary" style="width: 60px;">출고</button>
                				</c:if>
								</td>													
							</tr>
						</c:forEach>
						</tbody>
						<!-------------------------- 제품 내용 넣는 곳 -------------------------->
						<tfoot>
							<tr style = "background-color : #f2f2f2;" >
								<th rowspan="1" colspan="1">제품 코드</th>
								<th rowspan="1" colspan="1">제품 카테고리</th>
								<th rowspan="1" colspan="1">품목명</th>
								<th rowspan="1" colspan="1">제조회사</th>
								<th rowspan="1" colspan="1">수량</th>
								<th rowspan="1" colspan="1">창고위치</th>
								<th rowspan="1" colspan="1">출고</th>
								
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
			
			<!-- 출고 버튼 클릭 시 새로운 팝업 창 열기 -->
			<script>
			    document.addEventListener("DOMContentLoaded", function() {
			        var releaseButtons = document.querySelectorAll('.btn-primary'); // 출고 버튼을 선택합니다.
			        releaseButtons.forEach(function(button) {
			            button.addEventListener('click', function() {
			                var productCode = button.parentNode.parentNode.querySelector('td[data-product-code]').dataset.productCode; // 제품 코드 가져오기
			                var productName = button.parentNode.parentNode.querySelector('td:nth-of-type(3)').textContent.trim(); // 제품 이름 가져오기
			                var productCount = button.parentNode.parentNode.querySelector('td[data-available-count]').dataset.availableCount; // 제품 수량 가져오기
			                
			                // 출고 페이지 URL 생성
			                var popupUrl = '/stock/moveRelease?pno=' + encodeURIComponent(productCode) + '&pname=' + encodeURIComponent(productName) + '&count=' + encodeURIComponent(productCount);
			                
			                // 팝업창 가운데 띄우기 및 크기 조정
			                var width = 500;
			                var height = 600;
			                var left = (window.innerWidth - width) / 2;
			                var top = (window.innerHeight - height) / 2;
			                
			                // 팝업창 띄우기
			                var popupWindow = window.open(popupUrl, '_blank', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
			                
			                if (popupWindow) {
			                    popupWindow.focus();
			                }
			            });
			        });
			    });
			</script>


			<!-- 현재 페이지 총 사이즈와 보고있는 리스트 상태를 보여줌 -->
			<div class="row">
                <div class="col-sm-5">
					<c:choose>
					    <c:when test="${param.page * param.pageSize >= pageVO.totalCount}">
					        총 ${pageVO.totalCount}개의 항목 중 ${(param.page - 1) * param.pageSize + 1}번 부터 ${pageVO.totalCount}번까지 표시 중
					    </c:when>
					    <c:otherwise>
					        총 ${pageVO.totalCount}개의 항목 중 ${(param.page * param.pageSize) - param.pageSize + 1}번 부터 ${param.page * param.pageSize}번까지 표시 중
					    </c:otherwise>
					</c:choose>
                </div>
                <div class="col-sm-7">
                    <div class="dataTables_paginate paging_simple_numbers" id="example1_paginate">
                        <ul class="pagination">
                        <c:if test="${pageVO.prev }">
                            <li class="paginate_button previous" id="example1_previous">
                            <a href="/stock/stockMainCri?page=${pageVO.startPage -1 }&pageSize=${param.pageSize}" 
                            aria-controls="example1" data-dt-idx="0"
                            tabindex="0">이전</a></li>
                        </c:if>

                        <c:forEach var = "idx" begin= "${pageVO.startPage }"
                        end= "${pageVO.endPage}" step="1">
                            <li ${pageVO.cri.page == idx? "class='active'":""}>
                            <a href="/stock/stockMainCri?page=${idx }&pageSize=${param.pageSize}&keyword=${param.keyword}&type=${param.type}" 
                            aria-controls="example1" data-dt-idx="1" tabindex="0">${idx }</a></li>
                        </c:forEach>
                            <c:if test="${pageVO.next }">
                            <li class="paginate_button next" id="example1_next"><a
                                href="/stock/stockMainCri?page=${pageVO.endPage + 1 }&pageSize=${param.pageSize}" 
                                aria-controls="example1" data-dt-idx="7" tabindex="0">다음</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




<%@ include file="../include/footer.jsp"%>
