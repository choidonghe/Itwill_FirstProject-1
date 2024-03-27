<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>${param.pno }번 ${param.pname } 출고하기</title>
</head>
<body>
	<h3>출고하실 수량을 입력하세요</h3>
	<form role="form" method="post" action="/stock/moveRelease" id="releaseForm">
    <div class="box-body">
        <div class="form-group">
            <label for="exampleInputEmail1">제품 번호</label>
            <c:forEach var="sdVO" items="${detailList}">
                <input type="text" class="form-control" readonly id="exampleInputEmail1" name="pno" value="${sdVO.pno}" placeholder="${sdVO.pno}">
            </c:forEach>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">제품 품명</label>
            <c:forEach var="sdVO" items="${detailList}">
                <input type="text" class="form-control" readonly id="exampleInputEmail1" placeholder="${sdVO.pname}">
            </c:forEach>
        </div>
        <div class="form-group">
            <label for="stockCount">재고 수량</label>
            <c:forEach var="sdVO" items="${detailList}">
                <input type="text" class="form-control" readonly id="stockCount" value="${sdVO.count}">
            </c:forEach>
        </div>

        <div class="form-group">
            <label>출고 수량</label>
            <input type="number" class="form-control" id="count" name="count" placeholder="출고 수량을 입력하세요">
        </div>
    </div>
    <div class="box-footer">
        <button type="button" class="btn btn-primary" id="releaseButton">출고 하기</button>
    </div>
</form>

<script>
document.getElementById("releaseButton").addEventListener("click", function(event) {
    var stockCount = parseInt(document.getElementById("stockCount").value);
    var releaseCount = parseInt(document.getElementById("count").value);
    
    // 출고 수량이 0 이하인 경우 경고 메시지를 띄우고 폼 제출을 막습니다.
    if (releaseCount <= 0) {
        alert("출고 수량을 1 이상 입력해 주세요.");
        event.preventDefault(); // 폼 제출 막기
        return;
    }
    
    // 출고 수량이 재고 수량보다 많은 경우 경고 메시지를 띄우고 폼 제출을 막습니다.
    if (releaseCount > stockCount) {
        alert("출고 수량이 재고 수량보다 많습니다.");
        event.preventDefault(); // 폼 제출 막기
        return;
    }
    
    // 출고 수량이 재고 수량보다 같거나 작으면 출고 동작을 수행합니다.
    if (confirm("출고하시겠습니까?")) {
        document.getElementById("releaseForm").submit();
    }
});
</script>





</body>
</html>
