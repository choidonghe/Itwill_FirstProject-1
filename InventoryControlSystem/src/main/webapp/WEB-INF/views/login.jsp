<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>로그인 / 회원가입 폼 템플릿</title>
<link rel="stylesheet" href="style.css">

<style>
* {
    margin: 0;
    padding: 0;
    font-family: sans-serif;
}
.wrap {
    height: 100%;
    width: 100%;
    background-image: url(img/background.jpg);
    background-position: center;
    background-size: cover;
    position: absolute;
}
.form-wrap {
    width: 380px;
    height: 650px;
    position: relative;
    margin: 6% auto;
    background: #fff;
    padding: 5px;
    overflow: hidden;
}
.button-wrap {
    width: 230px;
    margin: 35px auto;
    position: relative;
    box-shadow: 0 0 600px 9px #fcae8f;
    border-radius: 30px;
}
.togglebtn {
    padding: 10px 30px;
    cursor: pointer;
    background: transparent;
    border: 0;
    outline: none;
    position: relative;
    font-weight: bold;
}
#btn {
    top: 0;
    left: 0;
    position: absolute;
    width: 110px;
    height: 100%;
    background: linear-gradient(to right, #3c8dbc, #ffffff);
    border-radius: 30px;
    transition: .5s;

}
.social-icons {
    margin: 30px auto;
    text-align: center;
}
.social-icons img {
    width: 50px ;
    cursor: pointer;
}
.input-group {
    top: 180px;
    position: absolute;
    width: 280px;
    transition: .5s;
}
.input-field {
    width: 100%;
    padding: 10px 0;
    margin: 5px 0;
    border: none;
    border-bottom: 1px solid #999;
    outline: none;
    background: transparent;
}
.submit {
    width: 85%;
    padding: 10px 30px;
    cursor: pointer;
    display: block;
    margin: auto;
    background: linear-gradient(to right, #3c8dbc, #ffffff);
    border: 0;
    outline: none;
    border-radius: 30px;
    font-weight: bold;
}
.checkbox {
    margin: 30px 10px 30px 0;
}
span {
    color: #777;
    font-size: 12px;
    bottom: 68px;
    position: absolute;
}
#login {
    left: 50px;
}
#register {
    left: 450px;
} 

.form-wrap{
	background-color: rgb(234,223,247); 
	border-radius: 50px;
}

</style>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
</head>
<body style="background-color: rgb(60,141,188);">
<c:if test="${not empty error}">
	<script>
	alert("회원정보를 확인해 주세요.");
	</script>
</c:if>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.0/kakao.min.js"
  integrity="sha384-l+xbElFSnPZ2rOaPrU//2FF5B4LB8FiX5q4fXYTlfcG4PGpMkE1vcL7kNXI6Cci0" crossorigin="anonymous"></script>
  
<script>
 	 Kakao.init('548b10d7782a89ded8a479adc1d32d91'); // 사용하려는 앱의 JavaScript 키 입력
 	 
 	function loginWithKakao() {
 	    Kakao.Auth.authorize({
 	      redirectUri: 'http://c6d2311t1.itwillbs.com/wms/registerkakao',
 	    });
 	  }
 	 
 	$(document).ready(function(){
   	 $("#pass2").on("focusout",function(){
   		 let pass1 = $("#pass").val();
   		 let pass2 = $("#pass2").val();
   		 console.log(pass1, pass2);
   		 
   		 if(pass1 == pass2){
   			 $("#label2").css("color", "black").text("비밀번호가 같습니다.");
   		 }else{
   			 $("#label2").css("color", "red").text("비밀번호가 다릅니다");
 				 $("#pass").val('');
 				 $("#pass2").val('');
   		 }
   		 
   	 });
   	 
    });

 	 $(document).ready(function() {
     
     	$("#id").on("focusout", function() {
     		
     		var id = $("#id").val();
     		
     		
 
         	$.ajax({
         		url : './confirmid',
         		data : {
         			id : id
         		},
         		type : 'POST',
         		dataType : 'json',
         		success : function(result) {
         			if (result == 1) {
         				$("#label1").css("color", "black").text("사용 가능한 ID 입니다.");
         			} else{
         				$("#label1").css("color", "red").text("사용 불가능한 ID 입니다.");
         				$("#id").val('');
         			}
         		}
         	}); //End Ajax
     	});
     })
 	 
</script>
 	 
 	 



	<div class="wrap">
	<h1 style="text-align: center; margin-top: 100px;, margin-bottom: 10px;">InventoryControlSystem</h1>
		<div class="form-wrap" >
			<div class="button-wrap">
				<div id="btn"></div>
				<button type="button" class="togglebtn" onclick="login()">로그인</button>
				<button type="button" class="togglebtn" onclick="register()">회원가입</button>
			</div>
			
			<div class="social-icons" style="height: 100px;">
				<a id="kakao-login-btn" href="javascript:loginWithKakao()"><img src="https://cs.kakao.com/img/cskakaocom/pc/thumb/thumb_kakaotalk.png" alt="kakao"></a> 
			</div>
			
			<form id="login" action="" class="input-group" method="post">
				<input type="text" class="input-field" placeholder="User ID" name="id" required> 
				<input type="password" class="input-field" placeholder="Enter Password" name="pass" required> 
				<!-- <input type="checkbox" class="checkbox"> -->
				<button class="submit">Login</button>
			</form>
			<form id="register" action="/register" class="input-group" method="post">
				<input id="id" type="text" class="input-field" placeholder="User ID" name="id" required> 
				<label id="label1"></label>
				<input type="password" class="input-field" placeholder="Enter Password" name="pass" required>
				<input type="text" class="input-field" placeholder="Enter Name" name="name" required>
				<input type="email" class="input-field" placeholder="Your Email" name="email" required> 
				<input type="number" class="input-field" placeholder="Your PhoneNumber" name="phone" required> 
				<input type="text" list="position" class="input-field" placeholder="position" name="position" required> 
				<datalist id="position">
					<option value="부장" />
        			<option value="과장"/>
        			<option value="대리"/>
        			<option value="사원"/>
				</datalist>
				<button class="submit">회원가입하기</button>
			</form>
		</div>
	</div>
	<script>
		var x = document.getElementById("login");
		var y = document.getElementById("register");
		var z = document.getElementById("btn");
		function login() {
			x.style.left = "50px";
			y.style.left = "450px";
			z.style.left = "0";
		}
		function register() {
			x.style.left = "-400px";
			y.style.left = "50px";
			z.style.left = "110px";
		}
	</script>
</body>
</html>