<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<link href="<c:url value='/resources/bootstrap/css/style.css' />" rel="stylesheet">
<style>
    .delete-button {
        background-color: #ff0000;
        color: #ffffff;
        border: none;
        padding: 8px 16px; 
        border-radius: 8px; 
        cursor: pointer; 
    }
   
    table.styled-table {
        border-collapse: collapse;
        width: 100%;
        margin-bottom: 20px;
    }

    table.styled-table td,
    table.styled-table th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    table.styled-table tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    table.styled-table th {
        background-color: #4CAF50;
        color: white;
    }
       
    form {
        max-width: 600px; 
        margin: 0 auto; 
    }
</style>
<form action="/account/accountAdd" method="post">

<h2>거래처 추가</h2>
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
        <td><input type="text" name="account_addr" id="account_addr" required >
         <button type="button" onclick="sample6_execDaumPostcode()">주소 찾기</button>
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

<script>
    window.addEventListener('DOMContentLoaded', function() {
        var accountCodeInput = document.querySelector('input[name="account_code"]');
        accountCodeInput.addEventListener('input', function() {
            var inputValue = this.value.trim();
            var regex = /^[A-Za-z0-9]{1,12}$/; // 영문자와 숫자로 이루어진 1자 이상 12자 이하인지 확인하는 정규식
            if (!regex.test(inputValue)) {
                // 올바르지 않은 입력값일 경우 경고 메시지를 표시하고 입력값을 지웁니다.
                alert('거래처 코드는 앞 영문자와 숫자로 이루어진 12자 이내여야 합니다.');
                this.value = ''; // 입력값을 지움
            }
        });

        var accountNameInput = document.querySelector('input[name="aaccount_name"]');
        accountNameInput.addEventListener('input', function() {
            // 여기에 거래처 명에 대한 유효성 검사 로직을 추가할 수 있습니다.
            // 예를 들어, 특정 패턴에 맞지 않는 경우 값을 지우거나 경고 메시지를 표시할 수 있습니다.
        });

        // 다른 입력 필드들에 대한 유효성 검사 로직을 추가할 수 있습니다.
    });
</script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 주소 설정
                var addr = '';
                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }

                // 입력 필드에 주소 설정
                document.getElementById("account_addr").value = addr;
            }
        }).open();
    }
</script>

<%@ include file="../include/footer.jsp"%>