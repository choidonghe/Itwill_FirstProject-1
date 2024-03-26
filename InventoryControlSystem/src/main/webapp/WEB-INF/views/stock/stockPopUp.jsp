<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
  h1 {
  	margin-bottom: 5px;
  }

  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    border-left: 1px solid #444444;
    padding: 10px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
</style>
<meta charset="UTF-8">
<title>${param.pno }번 제품 상세보기</title>

</head>
<body>

<h2> ${param.pno }번 제품 상세보기 </h2>
<table>
    <tr>
        <th>제품번호</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.pno }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>제품이름</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.pname }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>수량</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.count }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>카테고리</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.category }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>입고일자</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.regdate }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>제품회사</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.company }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>입고단가</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.unit_price }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>판매단가</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.sales_price }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>창고위치</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.location }</td>
        </c:forEach>
    </tr>
    <tr>
        <th>입고자</th>
        <c:forEach var="sdVO" items="${detailList}">
            <td>${sdVO.id }</td>
        </c:forEach>
    </tr>
</table>

</body>
</html>