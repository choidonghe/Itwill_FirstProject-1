<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<link href="<c:url value='/resources/bootstrap/css/style.css' />" rel="stylesheet">
<style>
    .delete-button {
        background-color: #ff0000; /* 빨간색 배경색 */
        color: #ffffff; /* 흰색 텍스트 */
        border: none; /* 테두리 없음 */
        padding: 8px 16px; /* 내부 여백 설정 */
        border-radius: 8px; /* 네모를 둥글게 만들기 */
        cursor: pointer; /* 커서를 포인터로 변경하여 클릭 가능한 모양으로 설정 */
    }
</style>
<h1>AccountAdd.jsp</h1>
${sessionScope.id }
<form action="/account/accountAdd" method="post">

<table class="styled-table">
    <tr>
        <td>거래처 코드 :</td>
        <td><input type="text" name="account_code" ></td>
    </tr>
    <tr>
        <td>거래처 명 :</td>
        <td><input type="text" name="account_name" ></td>
    </tr>
    <tr>
        <td>거래처 담당자명:</td>
        <td><input type="text" name="account_manager" ></td>
    </tr>
     <tr>
        <td>거래처 전화번호 :</td>
        <td><input type="text" name="account_phone" >
  		</td>
    </tr>
     <tr>
        <td>거래처 주소 :</td>
        <td><input type="text" name="account_addr" required >
  		</td>
    </tr>   
     <tr>
        <td>설명 :</td>
        <td><input type="text" name="account_explain" required  value="${avo.account_explain }">
  		</td>
    </tr>   
   
</table>
	<input type="submit" value="거래처 추가">
</form>



<%@ include file="../include/footer.jsp"%>