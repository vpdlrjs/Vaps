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

				alert(document.forms[0][i].name + "(을/를) 입력하세요.");
				document.forms[0][i].focus();
				return false;
			}
		}
		
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/top/title.jsp"%>
	<%@include file="/WEB-INF/views/top/menu.jsp"%>
		<br/>
	<%-- 
	DIV 영역 안쪽 여백 설정 
	http://xxwony.egloos.com/55671
	-padding [패딩] : 여백의 순서는 윗쪽, 오른쪽, 아랫쪽, 왼쪽입니다. 
	각각의 여백을 지정하지 않고, 하나만 쓰면 사방에 동일한 여백이 적용됩니다.
 --%>
	<div style="padding: 1px 20px 30px 60px;">
		<h1>Login</h1>
		<form action="access" name="LogFrm" method="post"
			onsubmit="return formCheck();">
			<table>
				<tr>
					<td>아이디:</td>
					<td><input class="intxt" type="text" name="id" /></td>
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><input class="intxt" type="password" name="pwd" /></td>
				</tr>
				<tr>
					<td colspan=2><input class="button" type="submit" value="로그인">
						<a href="javascript:location.href='/join'" class="button">회원가입</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
