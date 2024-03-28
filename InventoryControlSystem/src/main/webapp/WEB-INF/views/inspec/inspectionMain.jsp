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
</style>
</head>
<div class="box">
	<div class="box-header">
</div>
	<fieldset>
	${spageVO }
	${cri } <br>
		<legend>입고 검수 현황</legend>
		<div class="button-container">
			<form action="/inspec/inspectionMain" method="GET">
				<button type="submit">전체</button>
			</form>
			<form action="/inspec/inspectionDiv2" method="post">
				<button type="submit" value="div2">미검수</button>
			</form>
			<form action="/inspec/inspectionDiv3" method="post">
				<button type="submit" value="div3">검수완료</button>
			</form>
			<form action="/inspec/inspectionDiv4" method="post">
				<button type="submit" value="div4">불량제품</button>
			</form>
			
		</div>
	    <table>
	        <thead>
	            <tr>
	                <th>제품번호</th>
	                <th>제품명</th>
	                <th>담당자 아이디</th>
	                <th>상태</th>
	                <th>총 검수량</th>
	                <th>남은 검수량</th>
	                <th>입고날짜</th>
	                <th>검수날짜</th>
	            </tr>
	       		<c:forEach var="inspectionList" items="${inspectionList }">
	            <tr>
	                <td><a href="/inspec/inspectionRead?pno=${inspectionList.pno}">${inspectionList.pno }</a></td>
	                <td>${inspectionList.pname }</td>
	                <td>${sessionScope.id }</td>
	                <td>${inspectionList.codeVO[0].korname }</td>
	                <td>${inspectionList.count }</td>
	                <td>${inspectionList.remain_count }</td>
	                <td>${inspectionList.regdate }</td>
	                <td>${inspectionList.update_date }</td>
	            </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	</fieldset>
	<br>
	<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
			<c:if test="${spageVO.prev }">
				<li><a href="inspectionMain?page=${spageVO.startPage - 1 }">«</a></li>
			</c:if>
			<c:forEach var="idx" begin="${spageVO.startPage }" end="${spageVO.endPage }" step="1">
				<li ${spageVO.cri.page == idx? "class=active": ""}><a href="inspectionMain?page=${idx }">${idx }</a></li>
			</c:forEach>
			<c:if test="${spageVO.next }">
				<li><a href="inspectionMain?page=${spageVO.endPage + 1 }">»</a></li>
			</c:if>
			</ul>
		</div>
</div>


<%@ include file="../include/footer.jsp"%>