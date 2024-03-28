<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<link href="<c:url value='/resources/bootstrap/css/style.css' />" rel="stylesheet">

<h1>inspectionRead.jsp</h1>
${sessionScope.id }
<form action="/inspec/inspectionRead" method="post">

<table class="styled-table">
    <tr>
        <td>제품 번호:</td>
        <td><input type="text" name="pno" required readonly value="${vo.pno }"></td>
    </tr>
    <tr>
        <td>제품명:</td>
        <td><input type="text" name="pname" required readonly value="${vo.pname }"></td>
    </tr>
    <tr>
        <td>담당자명:</td>
        <td><input type="text" name="id" required readonly value="${sessionScope.id }"></td>
    </tr>
    <tr>
        <td>전체 수량:</td>
        <td><input type="number" name="count" required readonly value="${vo.count }"></td>
    </tr>
     <tr>
        <td>검수 수량:</td>
        <td><input type="number" name="finish_count" required 
        		   min ="0" max="${vo.remain_count }" value="0">
  		</td>
    </tr>
    <tr>
        <td>남은 수량:</td>
        <td><input type="number" name="remain_count" required readonly="readonly" value="${vo.remain_count }"></td>
    </tr>
    <tr>
        <td>검수 여부:</td>
        <td>
            <select name="divcode" id="divcode" >
           		<option value="3">입고완료</option>
                <option value="7">입고검수불량</option>
            </select>
        </td>
    </tr>
     <tr>
        <td>창고위치:</td>
        <td>
            <select name="warehouse_code" id="warehouse_code" >
            	<c:forEach var="warehouseList" items="${warehouseList}">
            		<option value="${warehouseList.warehouse_code }">${warehouseList.location }</option>
            	</c:forEach>
            </select>
        </td>
    </tr>
   
</table>
	<c:choose>
		<c:when test="${vo.remain_count == 0}">
			<input type="text" value="수정할 것 없음" readonly>
		</c:when>
		<c:otherwise>
			<input type="submit" value="수정 완료">
		</c:otherwise>
	</c:choose>
</form>

<script>
    // 페이지 로드 시 실행되는 함수
    window.onload = function() {
        updateWarehouseOptions();
    };

    // 검수 여부 선택 시 이벤트 처리
    document.getElementById('divcode').addEventListener('change', function() {
        updateWarehouseOptions();
    });

    // 창고 옵션 업데이트 함수
    function updateWarehouseOptions() {
        var divcode = document.getElementById('divcode').value;
        var warehouseSelect = document.getElementById('warehouse_code');

        // 모든 옵션 제거
        warehouseSelect.innerHTML = '';

        // divcode가 7인 경우 'C01' 창고를 추가하고 선택
        if (divcode === '7') {
            addOptionAndSelect(warehouseSelect, 'C01', '불량창고');
        }
        // divcode가 3인 경우 'A01'과 'B01' 창고를 추가하고 선택
        else if (divcode === '3') {
            addOptionAndSelect(warehouseSelect, 'A01', '창고A');
            addOptionAndSelect(warehouseSelect, 'B01', '창고B');
        }
    }

    // 옵션 추가 및 선택 함수
    function addOptionAndSelect(selectElement, value, text) {
        var option = document.createElement('option');
        option.value = value;
        option.text = text;
        selectElement.add(option);

        // 선택된 옵션 설정
       	if (selectElement.value === '') {
            selectElement.value = value;
        }
    }
</script>



<%@ include file="../include/footer.jsp"%>