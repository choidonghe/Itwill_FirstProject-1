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
    </style>
</head>
<div class="box">
	<div class="box-header">
	</div>
	
	 <h1>검수 현황</h1>
    <table>
        <thead>
            <tr>
                <th>PNO</th>
                <th>담당자 아이디</th>
                <th>상태</th>
                <th>총 검수량</th>
                <th>남은 검수량</th>
                <th>등록날짜</th>
                <th>수정날짜</th>
            </tr>
       		<c:forEach var="inspectionList" items="${inspectionList }">
            <tr>
                <td><a href="/inspec/inspectionRead?pno=${inspectionList.pno}">${inspectionList.pno }</td>
                <td>${inspectionList.id }</td>
                <td>${inspectionList.divcode}</td>
                <td>${inspectionList.quantity }</td>
                <td>${inspectionList.remain_quantity }</td>
                <td>${inspectionList.regdate }</td>
                <td>${inspectionList.update_date }</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
	
	
	
	
	
	
</div>


















<%@ include file="../include/footer.jsp"%>