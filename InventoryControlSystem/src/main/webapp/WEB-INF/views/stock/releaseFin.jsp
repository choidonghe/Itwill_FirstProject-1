<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
// 페이지 로드 시 화면 크기를 조정하는 함수
function adjustWindowSize() {
    // 원하는 가로, 세로 크기 지정
    var desiredWidth = 500;
    var desiredHeight = 350;
    
    // 현재 창의 크기와 위치 계산
    var left = (window.screen.width - desiredWidth) / 2;
    var top = (window.screen.height - desiredHeight) / 2;
    
    // 창의 크기와 위치 설정
    window.resizeTo(desiredWidth, desiredHeight);
    window.moveTo(left, top);
}

// 페이지 로드 시 화면 크기 조정 함수 호출
window.onload = function() {
    adjustWindowSize();
};
</script>

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
<title>출고 신청 완료</title>
<style>
/* 중앙 정렬을 위한 스타일 */
.center-content {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh; /* 화면의 높이를 화면 전체 높이로 설정 */
}
</style>
</head>
<body class="center-content">
<h3>출고 신청이 완료되었습니다.</h3>
<h3>재고 리스트로 나가셔서 새로고침 해주세요.</h3>
<div class="box-footer">
<button type="button" class="btn btn-primary" id="releaseButton">재고 리스트로 나가기</button>
</div>
<script>
// 버튼 클릭 시 창 닫기
document.getElementById("releaseButton").addEventListener("click", function() {
    window.close(); // 현재 창 닫기
});
</script>
</body>
</html>
