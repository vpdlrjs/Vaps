<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaps shopping mall</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bt.css" />
</head>
<body>
	<%@include file="/WEB-INF/views/top/title.jsp"%>
	<%@include file="/WEB-INF/views/top/menu.jsp"%>
	<br />
	<div style="padding: 1px 20px 30px 60px;">
	<table>
		<tr height="30">
			<td width="100" bgcolor="pink" align="center">NUM</td>
			<td colspan="5">${blist.b_num}</td>
		</tr>
		<tr height="30">
			<td bgcolor="pink" align="center">WRITER</td>
			<td width="150">${blist.b_id}</td>
			<td bgcolor="pink" align="center" width="90">DATE</td>
			<td width="100" align="center">${blist.b_date}</td>
			<td bgcolor="pink" align="center" width="80">COUNT</td>
			<td align="center" width="20">${blist.b_readcount}</td>
		</tr>
		<tr height="30">
			<td bgcolor="pink" align="center">TITLE</td>
			<td colspan="5">${blist.b_sub}</td>
		</tr>
		<tr height="200">
			<td bgcolor="pink" align="center">CONTENTS</td>
			<td colspan="5">${blist.b_contents}</td>
		</tr>
		<tr>
			<td colspan="6">
			<a href="/board" class="button">목록</a>
			<%--
			<a href="/boardModiContentForm?idx=${blist.b_num}&con=${blist.b_contents}" class="button">수정</a>
			 --%>
			<a href="/boardModiContentForm?idx=${blist.b_num}" class="button">수정</a>
			<a href="/boardDelContent?id=${blist.b_id}" class="button">삭제</a>
			</td>
		</tr>
	</table>
	<br>
</div>
</body>
</html>