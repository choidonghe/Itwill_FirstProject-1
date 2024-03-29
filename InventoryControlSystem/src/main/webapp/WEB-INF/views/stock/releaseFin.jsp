<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
// 페이지 로드 시 SweetAlert 알람 띄우기
window.onload = function() {
    swal({
        title: "출고 신청 완료",
        text: "재고 리스트로 나가셔서 새로고침 해주세요.",
        icon: "success",
        button: "나가기"
    }).then(function() {
        window.close();
        
        // 팝업 창 종료 시 부모창 새로고침
        if (window.opener) {
        	window.opener.location.reload();
        }
    });
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
</body>
</html>
