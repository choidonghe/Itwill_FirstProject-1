<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ include file="include/header.jsp" %>

	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">제품 생산</h3>
		</div>
		
		<form role="form" method="post">
			<div class="box-body">
				<div class="form-group">
					<label>PNO</label>
					<input type="text" class="form-control" name="pno" placeholder="제품코드">
				</div>
				<div class="form-group">
					<label>제품명</label>
					<input type="text" class="form-control" name="pname" placeholder="제품명">
				</div>
				<div class="form-group">
					<label>카테고리_코드</label>
					<input type="text" class="form-control" name="category_code" placeholder="카테고리">
				</div>
				<div class="form-group">
					<label>개수</label>
					<input type="text" class="form-control" name="count" placeholder=개수>
				</div>
				<div class="form-group">
					<label>가격</label>
					<input type="text" class="form-control" name="price" placeholder="원가">
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
</script>

<%@ include file="include/footer.jsp" %>