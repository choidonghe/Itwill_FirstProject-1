<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./include/header.jsp"%>
release : ${releaseList }
<br>
store : ${storeList }
<br>
order : ${ergList }
<br>
notice : ${noList }
<br>
oCri : ${oCri }
<br>
nCri : ${nCri }
<br>
orderPageVO : ${orderPageVO }
<br>
noticePageVO : ${noticePageVO }
<br>
mvo : ${mvo }
<div id="parent">
	<!-- calendar 태그 -->
	<div id='calendar-container'>
		<div id='calendar'></div>
	</div>
	<script>
		
		(function() {
			$(function() {
				// calendar element 취득
				var calendarEl = $('#calendar')[0];
				// full-calendar 생성하기
				var calendar = new FullCalendar.Calendar(
						calendarEl,
						{
							height : '450px', // calendar 높이 설정
							expandRows : true, // 화면에 맞게 높이 재설정
							slotMinTime : '08:00', // Day 캘린더에서 시작 시간
							slotMaxTime : '20:00', // Day 캘린더에서 종료 시간
							// 해더에 표시할 툴바
							headerToolbar : {
								left : 'prev,next today',
								center : 'title',
								right : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
							},
							initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
							navLinks : false, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
							editable : true, // 수정 가능?
							selectable : true, // 달력 일자 드래그 설정가능
							nowIndicator : true, // 현재 시간 마크
							dayMaxEvents : true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
							locale : 'ko', // 한국어 설정
							eventAdd : function(obj) { // 이벤트가 추가되면 발생하는 이벤트
								console.log(obj);
							},
							eventChange : function(obj) { // 이벤트가 수정되면 발생하는 이벤트
								console.log(obj);
							},
							eventRemove : function(obj) { // 이벤트가 삭제되면 발생하는 이벤트
								console.log(obj);
							},
							select : function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
								var title = prompt('Event Title:');
								if (title) {
									calendar.addEvent({
										title : title,
										start : arg.start,
										end : arg.end,
										allDay : arg.allDay
									})
								}
								calendar.unselect()
							},
							
							
							events: getList()
						});
				// 캘린더 랜더링
				calendar.render();
			});
		})();
		
		var releaseList = ${releaseList};
		var storeList = ${storeList};
		
		function getList(){
		    var events = [];
		    for(let i = 0; i < releaseList.length; i++){
		        events.push({
		            title: '출고',
		            start: releaseList[i],
		            color: 'orange'
		         
		        });
		    }
		    for(let i = 0; i < storeList.length; i++){
		        events.push({
		            title: '입고',
		            start: storeList[i],
		        });
		    }
		    return events;
		};
		
		console.log(getList())
	</script>

	<!-- 차트 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
	<div id="chartSize">
		<canvas id="bar-chart" width="300" height="245"></canvas>
	</div>
	<script>
		new Chart(document.getElementById("bar-chart"), {
			type : 'bar',
			data : {
				labels : [ "${dayList[4]}", "${dayList[3]}", "${dayList[2]}", "${dayList[1]}",
					"${dayList[0]}" ],
				datasets : [ {
					label : "Population (millions)",
					backgroundColor : [ "#3e95cd", "#8e5ea2", "#3cba9f",
							"#e8c3b9", "#c45850" ],
					data : [ ${sellList[4]}, ${sellList[3]}, ${sellList[2]}, ${sellList[1]}, ${sellList[0]} ]
				} ]
			},
			options : {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : '매출금액현황'
				}
			}
		});
		</script>


	<!-- 긴급발주 -->
	<div id="stock" class="box" style="margin-top: 30px">
		<div class="box-header">
			<h3 class="box-title">긴급발주목록</h3>
			<div class="box-tools">
				<ul class="pagination pagination-sm no-margin pull-right">
					<c:if test="${orderPageVO.prev }">
						<li><a href="/main?page=${orderPageVO.startPage - 1}">«</a></li>
					</c:if>
					
					<c:forEach var="idx" begin="${orderPageVO.startPage }" end="${orderPageVO.endPage }" step="1">
						<li ${orderPageVO.cri.orderPage == idx? "class='active'" : "" }><a href="/main?orderPage=${idx }">${idx }</a></li>
					</c:forEach>
					
					<c:if test="${orderPageVO.next }">
						<li><a href="/main?orderPage=${orderPageVO.endPage + 1 }">»</a></li>
					</c:if>
				</ul>
			</div>
		</div>


		<div class="box-body no-padding">
			<table class="table">
				<tbody>
					<tr>
						<th style="width: 100px">코드번호</th>
						<th style="width: 200px">품목</th>
						<th>잔여수량</th>
					</tr>

					<c:forEach var="list" items="${ergList }">
						<tr>
							<td>${list.pno }</td>
							<td>${list.pname }</td>
							<td>${list.count }</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>

	</div>

</div>


<div class="box-body" style="width: 1400px;">
	<div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
		<div class="row">
			<div class="col-sm-6"></div>
			<div class="col-sm-6"></div>
		</div>
		<div class="row" style="background-color: white;">
			<div class="col-sm-12">
				<table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
					<thead>
					<tr role="row">
							<th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="2" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending" >공지사항</th>
							<th>
								
								<form action="/main" method="post">
								<div class="input-group">
										<input name="search" id="new-event" type="text" class="form-control" placeholder="검색키워드" >
									
									<div class="input-group-btn">
										<button id="new-event" type="submit" class="btn btn-primary btn-flat">검색</button>
									</div>
								</div>
								</form>
							
							
							</th>
					</tr>
						<tr role="row">
							<th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending">번호</th>
							<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending">제목</th>
							<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending">날짜</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="list" items="${noList }">
						<tr>
							<td style="width: 50px;"> ${list.bno }</td>
							<td style="width: 1000px;"><a href="/main"> ${list.title } </a></td>
							<td>${list.regdate }</td>

						</tr>
					</c:forEach>
						
					</tbody>
					
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-5">
				<div class="dataTables_info" id="example2_info" role="status" aria-live="polite"></div>
			</div>
			<div class="col-sm-7">
				<div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
					<ul class="pagination">
						<c:if test="${noticePageVO.prev }">
							<li><a href="/main?page=${noticePageVO.startPage - 1}">«</a></li>
						</c:if>
					
						<c:forEach var="idx" begin="${noticePageVO.startPage }" end="${noticePageVO.endPage }" step="1">
							<li ${noticePageVO.cri.noticePage == idx? "class='active'" : "" }><a href="/main?noticePage=${idx }">${idx }</a></li>
						</c:forEach>
					
						<c:if test="${noticePageVO.next }">
							<li><a href="/main?orderPage=${noticePageVO.endPage + 1 }">»</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="./include/footer.jsp"%>