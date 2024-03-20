<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<link href="<c:url value='/resources/bootstrap/css/style.css' />" rel="stylesheet">

<h1>inspectionRead.jsp</h1>
<form action="/inspec/inspectionRead" method="post">

<table class="styled-table">
    <tr>
        <td>제품 번호:</td>
        <td><input type="text" name="pno" required readonly value="${vo.pno }"></td>
    </tr>
    <tr>
        <td>담당자명:</td>
        <td><input type="text" name="id" required value="${vo.id }"></td>
    </tr>
    <tr>
        <td>전체 수량:</td>
        <td><input type="number" name="quantity" required readonly value="${vo.quantity }"></td>
    </tr>
     <tr>
        <td>검수 수량:</td>
        <td><input type="number" name="finish_quantity" required value="${vo.finish_quantity }"></td>
    </tr>
    <tr>
        <td>남은 수량:</td>
        <td><input type="number" name="remain_quantity" required readonly="readonly" value="${vo.remain_quantity }"></td>
    </tr>
    <tr>
        <td>검수 여부:</td>
        <td>
            <select name="divcode" required>
                <option value="7">입고검수불량</option>
                <option value="8">입고검수양호</option>
                <option value="3">입고완료</option>
            </select>
        </td>
    </tr>
     <tr>
        <td>창고위치:</td>
        <td>
            <select name="warehouse_code" required>
                <option value="A01">A01</option>
                <option value="A02">A02</option>
                <option value="A03">A03</option>
                <option value="A04">A04</option>
            </select>
        </td>
    </tr>
   
</table>

<input type="submit" value="수정 완료">
</form>







<%@ include file="../include/footer.jsp"%>