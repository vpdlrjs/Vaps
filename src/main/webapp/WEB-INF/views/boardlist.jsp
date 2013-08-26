<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>스프링 게시판 목록!</title>

<%--  http://cusmaker.tistory.com/122
	   참고 writeBox를 만들기 위해서~ --%>
	   
<style type="text/css">
	a:link		{text-decoration:none;}
	a:visited	{text-decoration:none;color:#F361DC;}
	a:hover	{text-decoration:none;color:orange;}
	a:active	{text-decoration:none;color:#F361DC;}
	
	/* table, td, th{border:1px solid gray;} */
	th{ background-color:gray; color:green;}
	html, body{height:100%;margin:0}
	.articleView_layer {
		display:none;position:fixed;
		_position:absolute;top:0;left:0;
		z-index:10000;width:100%;height:100%}
	.articleView_layer.open {display:block}
	.articleView_layer .bg_layer {
		   position:absolute;top:0;left:0;
		   width:100%;height:100%;background:#000;
		   opacity:.5;filter:alpha(opacity=50)}
	#view_layer { position:absolute;top:25%;left:40%;
	  	margin:-150px 0 0 -194px;
	   	padding:28px 28px 0 28px;border:3px solid yellow;
	 	   	background:#fff;font-size:12px;
	  	color:#767676;line-height:normal;white-space:normal}

</style>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	
</head>

<body>
	<table>
	<!-- 
		세션 정보는 members테이블이 아닌 minfo라는 뷰에서 얻어옵니다.
	 -->
		<tr>
			<td colspan=2 align="center">Session Info</td>
		</tr>
		<tr>
			<td>id</td>
			<td>${members.id }</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${members.mname }</td>
		</tr>
		<tr>
			<td>grade</td>
			<td>${members.gname }</td>
		</tr>
		<tr>
			<td>point</td>
			<td>${members.point }</td>
		</tr>
	</table>
	
	<br>
</body>
</html>

