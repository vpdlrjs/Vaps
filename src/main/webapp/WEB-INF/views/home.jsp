<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaps shopping mall</title>
</head>
<body>
	<%@include file="/WEB-INF/views/top/title.jsp"%>
	<%@include file="/WEB-INF/views/top/menu.jsp"%>
		<br/>
	<div style="padding: 1px 20px 30px 60px;">
		<h1>Vaps Shop!</h1>
		<table>
			<tr>
				<td colspan=2>Session Info</td>
			</tr>
			<tr>
				<td>id</td>
				<td>${members.m_id }</td>
			</tr>
			<tr>
				<td>nick</td>
				<td>${members.m_nick }</td>
			</tr>
			<tr>
				<td>pwd</td>
				<td>${members.m_pwd }</td>
			</tr>
			<tr>
				<td>phone</td>
				<td>${members.m_phone }</td>
			</tr>
			<tr>
				<td>addr</td>
				<td>${members.m_addr }</td>
			</tr>
			<tr>
				<td>point</td>
				<td>${members.m_point }</td>
			</tr>
			<tr>
				<td>auth</td>
				<td>${members.m_auth }</td>
			</tr>
			</table>
	</div>

</body>
</html>
