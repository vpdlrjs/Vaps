<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaps shopping mall</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bt.css" />
<script>
	function formCheck() {
		var length = document.forms[0].length - 1;

		for ( var i = 0; i < length - 1; i++) {
			if (document.forms[0][i].value == null
					|| document.forms[0][i].value == "") {

				alert(document.forms[0][i].name + "을/를 입력하세요.");
				document.forms[0][i].focus();
				return false;
			}
		}
	}
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/top/title.jsp"%>
	<%@include file="/WEB-INF/views/top/menu.jsp"%>
		<br/>
	<div style="padding: 1px 20px 30px 60px;">
		<form action="/board" name="writeFrm" method="post"
			onsubmit="return formCheck();">
			<table>
				<tr>
					<td>제목:</td>
					<td><input class="inSub" type="text" name="sub" class="button" value="${blist.b_sub}"/></td>
				</tr>
				<tr>
					<td>내용:</td>
					<td><textarea cols="67" rows="10"  name="contents" class="inArea">${blist.b_contents}</textarea></td>
				</tr>
				<tr>
					<td colspan=2 align="right"><input class="button" type="submit" value="수정" />
					<a href="/board" class="button">취소</a></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
