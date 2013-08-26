<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="styleSheet" type="text/css" href="${pageContext.request.contextPath}/css/bt.css" />
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
	<h1>Login page!</h1>

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
				<td colspan=2>
				<input class="button" type="submit" value="로그인">
				<a href="javascript:location.href='/join'" class="button">회원가입</a>				
				</td>
			</tr>
		</table>
<!-- 
	버튼 CSS 관련 사용법을 얻을 수 있다.
	http://www.red-team-design.com/wp-content/uploads/2011/09/awesome-css3-buttons.html
 -->
	</form>
</body>
</html>
<!--
유효성 체크 코드를 넣었음. 하나라도 입력이 안됐다면 다음으로 넘어가지 않는다.
/SpringBoard/src/main/java/com/school/board/HomeController.java
으로가서 /join에 대한 처리를 작성한다.
-->