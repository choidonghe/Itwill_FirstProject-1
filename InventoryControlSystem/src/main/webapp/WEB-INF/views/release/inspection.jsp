<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

<%-- cri=${cri } <br>
pageVO=${pageVO } <br>
${vo} <br> 


	<h1>inspection.jsp</h1> --%>
	
	
	<input type="button" value="전체" onclick="location.href='/release/main'">
	<input type="button" value="출고" onclick="location.href='/release/release'">
	<input type="button" value="불량" onclick="location.href='/release/error'">
	
	
	
	
	<div class="content">
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">출고 검수</h3>
			</div>
	
			<div class="box-body">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<th>상태</th> 
							<th>제품번호</th> 
							<th>제품명</th> 
							<th>수량</th> 
							<th>가격</th> 
							<th>입고날짜</th> 						
						</tr>
						
						<c:forEach var="vo" items="${vo}">
							<c:if test="${vo.divcode == 5 && vo.order_count > 0 }">
							<tr>
								<td>
<%-- 								<c:if test="${vo.id == 'admin' }"> --%>
									<form action="" method="post" onsubmit="return test()">
											<select name="divcode" aria-controls="example1" class="form-control input-sm">
												<c:forEach var="code" items="${code}">
													<c:if test="${code.divcode != 4 && code.divcode != 5 && code.divcode != 8}">
														<option value="${code.divcode}">${code.korname}</option>
													</c:if>
												</c:forEach>
											</select>
											<input type="number" min="0" max="${vo.order_count}" name="release_count" placeholder="수량을 적으세요." required="required" onkeyup="this.value=numberFormat(this.value, false, false, false)">
											<input type="hidden" name="id" value="${vo.id}">
											<input type="hidden" name="pno" value="${vo.pno}">
											<input type="submit" value="출고하기" class="btn btn-danger">
									</form>
<%-- 									</c:if> --%>
								</td>
								<td>${vo.pno}</td>
								<td>${vo.pname}</td>
								<td>${vo.order_count}</td>
								<td>${vo.price}</td>
								<td>${vo.order_date}</td>
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
				
			<div class="box-footer clearfix">
				<ul class="pagination pagination-sm no-margin pull-right">
					<c:if test="${pageVO.prev}">
						<li><a href="/release/inspection?page=${pageVO.startPage-1}">«</a></li>
					</c:if>
	
					<c:forEach var="idx" begin="${pageVO.startPage}" end="${pageVO.endPage}" step="1">
						<li ${pageVO.cri.page == idx? "class=active":""}><a href="/release/inspection?page=${idx}">${idx}</a></li>
					</c:forEach>
	
					<c:if test="${pageVO.next}">
						<li><a href="/release/inspection?page=${pageVO.endPage+1}">»</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	
	<script>
//숫자 입력 (마이너스, 소수점, 콤마)
function numberFormat(val, isMinus, isFloat, isComma){
  var str = val;
  //일단 마이너스, 소수점을 제외한 문자열 모두 제거
  str = str.replace(/[^-\.0-9]/g, '');
  //마이너스
  if(isMinus){
     str = chgMinusFormat(str);   
  } else {
     str = str.replace('-','');
  }
  
  //소수점
  if(isFloat){
     str = chgFloatFormat(str);       
  } else {
     if(!isMinus ){
        str = str.replace('-','');
     }
     str = str.replace('.','');
     if(str.length>1){
        str = Math.floor(str);
        str = String(str);
     }
  }
  
  //콤마처리
  if(isComma){
     var parts = str.toString().split('.');
     if(str.substring(str.length - 1, str.length)=='.'){
        str = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g,",") +".";
     } else {
        str = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g,",") + (parts[1] ? "." + parts[1] : "");
     }
  }

  return str;
}

function chgFloatFormat(str){
  var idx = str.indexOf('.');  
  if(idx<0){  
     return str;
  } else if(idx>0){
     var tmpStr = str.substr(idx+1);    
     if(tmpStr.length>1){             
        if(tmpStr.indexOf('.')>=0){        
           tmpStr =  tmpStr.replace(/[^\d]+/g, '');                  
           str = str.substr(0,idx+1) + tmpStr;
        }
     }    
  } else if(idx==0){
        str = '0'+str;
  }
  return str;  
}
  
function chgMinusFormat(str){
  var idx = str.indexOf('-');
  if(idx==0){
  var tmpStr = str.substr(idx+1);
     //뒤에 마이너스가 또 있는지 확인
     if(tmpStr.indexOf('-')>=0){
           tmpStr = tmpStr.replace('-','');
        str = str.substr(0,idx+1) + tmpStr;  
     }
  } else if(idx>0){
        str = str.replace('-','');
  } else if(idx<0){
        return str;
  }
     return str;
}

</script>





<%@ include file="../include/footer.jsp"%>