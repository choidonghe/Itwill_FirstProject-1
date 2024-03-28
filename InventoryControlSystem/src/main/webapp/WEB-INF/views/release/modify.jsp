<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

	
	
<%-- ${modifyList} <br>
${code} <br> 
<h1>modify.jsp</h1> --%>
	
	<form action="" method="post">
		<input type="hidden" name="page" value=${cri.page }>
		<input type="hidden" name="pageSize" value=${cri.pageSize }>
		
		<div class="content">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">제품 수정</h3>
				</div>
	
				<div class="box-body">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>상태</th> 
								<th>제품번호</th> 
								<th>제품명</th> 
								<th>수량</th> 
								<th>입고자</th>
							</tr>
	
							<tr>
								<td>
<%-- 								<c:if test="${id eq 'admin}"> --%>
										<select name="divcode">
												<c:forEach var="code" items="${code}">
													<option value="${code.divcode}">${code.korname}</option>
												</c:forEach>
										</select>
<%-- 								</c:if> --%>
								</td>
								<td><input type="text" value="${modifyList.pno}" readonly="readonly"></td>
								<td><input type="text" name="pname" value="${modifyList.pname}" readonly="readonly"></td>
<%-- 								<td><input type="number" min="0" name="order_count" value="${modifyList.order_count}"></td> --%>
																																	<!--     숫자만 입력, 마이너스 불가, 소수점 불가, 콤마처리 -->
								<td><input type="number" min="0" name="order_count" value="${modifyList.order_count}" onkeyup="this.value=numberFormat(this.value, false, false, false)"></td>
								<td><input type="text" name="id" value="${modifyList.id}" readonly="readonly" ></td>
								
							</tr>
						</tbody>
					</table>
					<input type="hidden" value="${modifyList.pno}">
					<input type="submit" value="수정" class="btn btn-danger">
	
				</div>
				<div class="box-footer clearfix">
					<button onclick="location.href='/release/main'">메인으로</button>
					<ul class="pagination pagination-sm no-margin pull-right">
					</ul>
				</div>
			</div>
		</div>
	</form>
	
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

