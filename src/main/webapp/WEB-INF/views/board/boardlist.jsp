<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<br />
	<div style="padding: 1px 20px 30px 60px;">
		<table id="two_table">
			<tr bgcolor="cyan" align="center" height="35">
				<td width="100">번호</td>
				<td width="400">제목</td>
				<td width="150">작성자</td>
				<td width="200">작성일</td>
				<td width="100">조회수</td>
			</tr>
			<c:forEach var="blist" items="${blist}">
				<tr height="25">
					<td width="100" align="center">${blist.b_num}</td>
					<td width="400"><a href="contents?idx=${blist.b_num}">${blist.b_sub} </a></td>
					<%--
					<td width="400"><a href='contents?idx=${blist.b_num}'>${blist.b_sub} </a></td>
					<td width="400"><a href="contents"
						onclick="articleView('${blist.b_num}')">${blist.b_sub}</a></td>
					 --%>
					<td width="150" align="center">${blist.b_id}</td>
					<td width="200" align="center">${blist.b_date}</td>
					<td width="100" align="center">${blist.b_readcount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=5>
					<center>${paging }<p>
					</center>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
