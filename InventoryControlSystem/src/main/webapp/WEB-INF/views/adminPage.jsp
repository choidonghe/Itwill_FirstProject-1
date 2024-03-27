<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./include/header.jsp"%>

<c:if test="${authVO.auth != 'ROLE_ADMIN' }">
	<script>
	alert('권한이 없습니다!');
	history.back();
	</script>
</c:if>


<div class="col-xs-12">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">회원정보</h3>
			<div class="box-tools">
				<div class="input-group input-group-sm hidden-xs" style="width: 150px;">
					<input type="text" name="table_search" class="form-control pull-right" placeholder="Search">
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="box-body table-responsive no-padding">
			<table class="table table-hover">
				<tbody>
					<tr>
						<th>사번</th>
						<th>ID</th>
						<th>이름</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>직급</th>
						<th>권한</th>
						<th>회원가입일</th>
						<th>수정</th>
					</tr>

					<c:forEach var="list" items="${mList }" >
					<tr>
						<form action="" method="post">
							<td><input type="text" name="eno" value="${list.eno }" readonly></td>
							<td><input type="text" name="id" value="${list.id }" readonly></td>
							<td><input type="text" name="name" value="${list.name }" ></td>
							<td><input type="text" name="email" value="${list.email }" ></td>
							<td><input type="text" name="phone" value="${list.phone }" ></td>
							<td>
								<select name="position" >
									<option value="${list.position }" selected hidden>${list.position }</option>
									<option value="사원" >사원</option>
        							<option value="대리">대리</option>
        							<option value="과장">과장</option>
        							<option value="부장">부장</option>
								</select>							
							</td>
							<td>
								<select name="auth" >
									<option value="${list.auth }" selected hidden>${list.auth }</option>
									<option value="ROLE_USER" >ROLE_USER</option>
        							<option value="ROLE_MANAGER">ROLE_MANAGER</option>
        							<option value="ROLE_ADMIN">ROLE_ADMIN</option>
								</select>
							</td>
							<td><input type="text" name="regdate" value="${list.regdate }"  readonly></td>
							<td><button class="updateBtn" type="submit">수정하기</button> </td>
						</form>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

</div>

<script>
	
	$('.updateBtn').on('click',function(){
		console.log("dddd");
		alert("회원정보 수정완료!");
	});
</script>

<%@ include file="./include/footer.jsp"%>