<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<head>
    <meta charset="UTF-8">
    <style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}

.button-container {
	display: flex; /* 가로 정렬을 위해 flexbox 사용 */
}

.button-container button {
	margin-right: 10px; /* 버튼 사이 간격을 조절 */
}
.add-button {
     background-color: #4CAF50; /* 초록색 배경 */
     border: none; /* 테두리 없음 */
     color: white; /* 흰색 텍스트 */
     padding: 8px 16px; /* 내부 여백 설정 */
     text-align: center; /* 가운데 정렬 */
     text-decoration: none; /* 텍스트에 밑줄 없음 */
     display: inline-block; /* 인라인 요소로 설정 */
     font-size: 16px; /* 폰트 크기 설정 */
     margin: 4px 2px; /* 버튼 주변 여백 설정 */
     cursor: pointer; /* 커서를 포인터로 변경하여 클릭 가능한 모양으로 설정 */
        }
</style>
</head>
<div class="box">
	<div class="box-header">
</div>
	<fieldset>
		<legend>거래처 관리</legend>

	    <table>
	        <thead>
	            <tr>
	                <th>거래처 코드</th>
	                <th>거래처명</th>
	                <th>거래처 담당자</th>
	                <th>T E L</th>
	                <th>거래처 주소</th>
	                <th>기타 설명</th>
	            </tr>
	       		<c:forEach var="accountList" items="${accountList }">
	            <tr>
	                <td><a href="/account/accountRead?account_code=${accountList.account_code}">${accountList.account_code }</a></td>
	                <td>${accountList.account_name }</td>
	                <td>${accountList.account_manager }</td>
	                <td>${accountList.account_phone }</td>
	                <td>${accountList.account_addr }</td>
	                <td>${accountList.account_explain }</td>
	            </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	</fieldset>
	<br>
	
    <div class="button-container">
        <button class="add-button" onclick="location.href='/account/accountAdd'">거래처 추가</button>
    </div>	

	<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
			<c:if test="${spageVO.prev }">
				<li><a href="accountMain?page=${spageVO.startPage - 1 }">«</a></li>
			</c:if>
			<c:forEach var="idx" begin="${spageVO.startPage }" end="${spageVO.endPage }" step="1">
				<li ${spageVO.cri.page == idx? "class=active": ""}><a href="accountMain?page?page=${idx }">${idx }</a></li>
			</c:forEach>
			<c:if test="${spageVO.next }">
				<li><a href="accountMain?page?page=${spageVO.endPage + 1 }">»</a></li>
			</c:if>
			</ul>
		</div>
	
</div>


<%@ include file="../include/footer.jsp"%>