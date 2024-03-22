<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./include/header.jsp"%>


<div class="box">
<div class="box-header">
<h3 class="box-title"><공지사항 작성>

</h3>

<div class="pull-right box-tools">
<button type="button" class="btn btn-default btn-sm" data-widget="collapse" data-toggle="tooltip" title="" data-original-title="Collapse">
<i class="fa fa-minus"></i></button>
<button type="button" class="btn btn-default btn-sm" data-widget="remove" data-toggle="tooltip" title="" data-original-title="Remove">
<i class="fa fa-times"></i></button>
</div>

</div>

<div class="box-body pad">
<form action="/notice" method="post">
<input type="text" name="title" placeholder="공지사항 제목" style="width: 100%; height: 50px; font-size: 30px; border: 1px solid rgb(221, 221, 221); padding: 10px;">
<textarea name="content" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px; " placeholder="Place some text here"></textarea>
<button type="submit" class="btn btn-block btn-primary btn-lg" style="width: 200px; ">작성완료</button>

</form>
</div>
</div>


<%@ include file="./include/footer.jsp"%>