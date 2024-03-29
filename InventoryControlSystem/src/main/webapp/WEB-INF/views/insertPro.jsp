<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ include file="include/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">제품 생산</h3>
		</div>
		
		<form id="productForm" role="form" method="post">
			<div class="box-body">
				<input type="hidden" name="id" value="${authVO.id }">
				<div class="form-group">
	            	<label>PNO</label>
		            <input type="text" class="form-control" name="pno" id="pno" placeholder="자동 생성됨" readonly>
		        </div>
		        	<button type="submit" class="btn btn-primary">pno 생산</button>
				<div class="form-group">
					<label>제품명</label>
					<input type="text" class="form-control" name="pname" placeholder="제품명">
				</div>
				<div class="form-group">
					<label>카테고리_코드</label>
					<select name="category_code" id="category_code" aria-controls="example1" class="form-control input-sm">
						<c:forEach var="cList" items="${cList }">
							<option value="${cList.category_code }">${cList.category_code }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label>개수</label>
					<input type="text" class="form-control" name="count" placeholder=개수>
				</div>
				<div class="form-group">
					<label>가격</label>
					<input type="text" class="form-control" name="unit_price" placeholder="원가">
				</div>
				<div class="form-group">
					<label>판매가격</label>
					<input type="text" class="form-control" name="sales_price" placeholder="판매가격">
				</div>
				
				<div class="form-group">
			    <label>회사명</label>
			    <select name="company" id="company" aria-controls="example1" class="form-control input-sm">
			        <c:forEach var="aList" items="${aList}">
			            <option value="${aList.account_name}">${aList.account_name}</option>
			        </c:forEach>
			    </select>
				</div>
				
				<div class="form-group">
				    <label>회사코드</label>
				    <select name="account_code" id="account_code" aria-controls="example1" class="form-control input-sm">
				        <c:forEach var="aList" items="${aList}">
				            <option value="${aList.account_code}" data-company="${aList.account_name}">${aList.account_code}</option>
				        </c:forEach>
				    </select>
				</div>
			</div>
			
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">생산</button>
			</div>
		</form>
	</div>
	
<script>
//이전에 생성된 PNO의 숫자
let lastPnoNumber = 0;

document.getElementById("productForm").addEventListener("submit", function(event) {
    event.preventDefault(); // 기본 제출 방식 방지

    // 오늘 날짜 생성 (YYYYMMDD 형식)
    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth() + 1;
    var day = today.getDate();
    if (month < 10) month = '0' + month;
    if (day < 10) day = '0' + day;
    var formattedDate = year + month + day;

    // 선택한 카테고리 코드 가져오기
    var categoryCode = document.getElementById("category_code").value;

    // 새로운 PNO 생성 (카테고리코드 + 오늘날짜 + 숫자)
    lastPnoNumber++;
    var pno = categoryCode + formattedDate + padNumber(lastPnoNumber, 2);

    // 생성된 PNO를 입력
    document.getElementById("pno").value = pno;

    // 여기서 다른 필요한 작업을 수행할 수 있습니다. 예를 들어 서버로 데이터를 전송하는 등의 작업을 수행할 수 있습니다.
});

// 숫자를 지정된 자릿수로 패딩하는 함수
function padNumber(number, width) {
    number = number + '';
    return number.length >= width ? number : new Array(width - number.length + 1).join('0') + number;
}


    // 회사명과 회사코드를 함께 표시하는 함수
    function showCompanyWithCode() {
        var companySelect = document.getElementById('company');
        var companyName = companySelect.options[companySelect.selectedIndex].value;

        var accountCodeSelect = document.getElementById('account_code');
        var selectedOption = accountCodeSelect.options[accountCodeSelect.selectedIndex];
        var company = selectedOption.getAttribute('data-company');
        var accountCode = selectedOption.value;

        alert("선택한 회사명: " + companyName + "\n선택한 회사코드: " + accountCode);

        // 회사명과 회사코드가 다른 경우 경고창 표시
        if (companyName !== company) {
            alert("경고: 선택한 회사명과 회사코드의 정보가 일치하지 않습니다.");
        }
    }
    // 회사코드 선택 시 이벤트 처리
    document.getElementById('account_code').addEventListener('change', function() {
        showCompanyWithCode();
    });
    
    $(document).ready(function(){
	    function produceProduct() {
	        // 폼 데이터 가져오기
	        var formData = $('#productForm').serialize();
	
	        // AJAX 요청 보내기
	        $.ajax({
	            type: "POST",
	            url: "/insertPro",
	            data: formData,
	            success: function(response) {
	                // 성공 시 처리할 내용
	                alert("제품이 성공적으로 생산되었습니다.");
	                // 페이지 이동
	                window.location.href = "/storeinglist";
	            },
	            error: function(xhr, status, error) {
	                // 실패 시 처리할 내용
	                console.error("AJAX 요청 오류:", error);
	                alert("제품 생산 중 오류가 발생했습니다: " + error);
	            }
            });
	    }
	    $('#productForm').submit(function(event) {
	        event.preventDefault(); // 기본 제출 방지
	        produceProduct(); // produceProduct() 함수 호출
	    });
    });
</script>

<%@ include file="include/footer.jsp" %>