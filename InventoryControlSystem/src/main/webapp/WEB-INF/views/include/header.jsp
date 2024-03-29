<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  <style>
  	.popup-container {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: white;
    border: 1px solid #ccc;
    padding: 20px;
    z-index: 9999; /* 팝업창을 다른 요소 위로 올립니다. */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 팝업창에 그림자 효과를 추가합니다. */
	}
	.upButton {
    width: 50px; 
    height: 50px; 
    border-radius: 50%;
    border: none; 
    background-color: #eeeeee;
    color: #616161; 
    font-size: 18px;
    outline: none; 
    box-shadow: 0px 1px 5px rgb(147 141 201 / 25%), 0px 10px 25px rgb(147 141 201 / 20%); 
    transition: all 0.4s;
    overflow: hidden;
    position: fixed;
    display: block;
    bottom: 35px;
    right : 30px;
    z-index: 999;
    cursor: pointer;
	}
	
	.upButton:hover {
	    box-shadow: 1px 1px 5px rgb(147 141 201), -1px -1px 5px #525252;
	}
	.modal {
    display: none; 
    position: fixed;
    z-index: 1; /* 모달을 다른 요소 위에 표시 */
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;	
    overflow: auto; 
    background-color: rgba(0, 0, 0, 0.4); /* 배경을 반투명하게 */
}


.modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 모달이 화면 중앙에 위치하도록 */
    padding: 20px;
    border: 1px solid #888;
    width: 20%; /* 모달의 너비 설정 */
    
}

.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}

  </style>
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath }/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="${pageContext.request.contextPath }/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
<meta charset='utf-8' />
<!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>


<meta charset="UTF-8">
<title>1조 재고관리시스템</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="${pageContext.request.contextPath }/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="${pageContext.request.contextPath }/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
/* body 스타일 */
#chartSize {
	width: 580px;
	height: 600px;
	float: left;
}

#parent {
	margin: 1px;
	padding: 10px;
	height: 200px;
}

/* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
.fc-header-toolbar {
	padding-top: 1em;
	padding-left: 1em;
	padding-right: 1em;
}

#calendar-container {
	float: left;
	margin: 30px;
	width: 360px;
	background-color: white;
	font-size: 9px;
}

#stock {
	float: left;
	width: 400px;
}
</style>



</head>
<!-- jQuery 2.1.4 -->
<script src="${pageContext.request.contextPath }/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<body class="skin-blue sidebar-mini">

<c:if test="${empty authVO.id}">
	<c:redirect url="localhost:8088/login"/>
</c:if>
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="/main" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span class="logo-mini"><b>I</b>CS</span> <!-- logo for regular state and mobile devices --> <span class="logo-lg"><b>Inven 	</b>Control System</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 5 messages</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li>
											<!-- start message --> <a href="#">
												<div class="pull-left">
													<img src="${pageContext.request.contextPath }/resources/dist/img/credit/circle-user-solid.svg" class="img-circle" alt="User Image" />
												</div>	
												<h4>
													출고 관리자 <small><i class="fa fa-clock-o"></i> 5 mins</small>
												</h4>
												<p>긴급 출고검수 요망</p>
										</a>
										</li>
										<!-- end message -->
										<li><a href="#">
												<div class="pull-left">
													<img src="${pageContext.request.contextPath }/resources/dist/img/credit/circle-user-solid.svg" class="img-circle" alt="user image" />
												</div>
												<h4>
													AdminLTE Design Team <small><i class="fa fa-clock-o"></i> 2 hours</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="${pageContext.request.contextPath }/resources/dist/img/credit/circle-user-solid.svg" class="img-circle" alt="user image" />
												</div>
												<h4>
													Developers <small><i class="fa fa-clock-o"></i> Today</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="${pageContext.request.contextPath }/resources/dist/img/credit/circle-user-solid.svg" class="img-circle" alt="user image" />
												</div>
												<h4>
													Sales Department <small><i class="fa fa-clock-o"></i> Yesterday</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="${pageContext.request.contextPath }/resources/dist/img/credit/circle-user-solid.svg" class="img-circle" alt="user image" />
												</div>
												<h4>
													Reviewers <small><i class="fa fa-clock-o"></i> 2 days</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">See All Messages</a></li>
							</ul></li>
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span class="label label-warning">2</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">2개의 공지가 있습니다.</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li><a href="#"> <i class="fa fa-users text-aqua"></i> 제품2024032689 입고 완료 
										</a></li>
										<li><a href="#"> <i class="fa fa-warning text-yellow"></i> 28. 출고 검수 요망 
										</a></li>
									</ul>
								</li>
							</ul></li>
						<!-- Tasks: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="/resources/dist/img/credit/circle-user-solid (1).svg" class="user-image" alt="User Image" /> <span class="hidden-xs">Admin</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img src="${pageContext.request.contextPath }/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
									<p>
										Admin
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-right">
										<a href="#" id="logoutBtn" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>

								<script>
									document
											.getElementById("logoutBtn")
											.addEventListener(
													"click",
													function(event) {
														event.preventDefault(); // 기본 동작(링크 이동) 방지

														// 여기에 로그아웃 동작을 수행하는 코드를 작성합니다.
														// 예를 들어, 로그아웃 API를 호출하거나 세션을 삭제하는 등의 작업을 수행할 수 있습니다.

														// 이 예제에서는 단순히 경고창을 띄우고 페이지를 새로고침하여 로그아웃하는 것으로 가정합니다.
														if (confirm("로그아웃 하시겠습니까?")) {
															window.location.href = "/logout"; // 로그아웃 처리 후 리다이렉트할 경로를 지정합니다.
														}
													});
								</script>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="${pageContext.request.contextPath }/resources/dist/img/credit/circle-user-solid (1).svg" color = "white" class="img-circle" alt="User Image" />
					</div>
					<div class="pull-left info">
						<p>Admin</p>
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				<!-- search form -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control" placeholder="Search..." /> <span class="input-group-btn">
							<button type='submit' name='search' id='search-btn' class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">주요 기능</li>
					<li class="treeview"><a href="#"> <i class="fa fa-check"></i> <span>입고</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="/storeinglist"><i class="fa fa-circle-o"></i> 입고예정</a></li>
							<li><a href="/inspec/inspectionMain"><i class="fa fa-circle-o"></i> 입고검수</a></li>
						</ul></li>
					<li class="treeview"><a href=""> <i class="fa fa-check"></i> <span>재고</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class ="treeview-menu">
							<li><a href="/stock/stockMainCri?page=1&pageSize=10"><i class="fa fa-circle-o"></i>재고 수량</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i>창고 위치</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-check"></i> <span>출고</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="/release/main"><i class="fa fa-circle-o"></i>출고 메인</a></li>
			                <li><a href="/release/inspection"><i class="fa fa-circle-o"></i>출고 검수</a></li>
			                <li><a href="/release/release"><i class="fa fa-circle-o"></i>출고 검수 완료</a></li>
			                <li><a href="/release/error"><i class="fa fa-circle-o"></i>불량 제품</a></li>
						</ul></li>
					<li class="treeview"><a href=""> <i class="fa fa-check"></i> <span>관리</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class ="treeview-menu">
							<li><a href="/account/accountMain"><i class="fa fa-circle-o"></i>거래처 관리</a></li>
							<li><a href="/insertPro"><i class="fa fa-circle-o"></i>제품 생산</a></li>
						</ul></li>
					<li class="treeview active"><a href="/notice"> <i class="fa fa-edit"></i> <span>공지사항 작성</span> <i class="fa fa-angle-left pull-right"></i>
					</a></li>
					
					<c:if test="${authVO.auth == 'ROLE_ADMIN' }">
					<li><a href="./adminPage"> <span>관리자 페이지</span> 
					</a></li>
					</c:if>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					재고관리시스템<small>InventoryControlSystem</small>
				</h1>

			</section>