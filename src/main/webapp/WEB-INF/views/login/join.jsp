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
		function openConfirmId(joinFrm){			
			var id=joinFrm.id.value;
			var url="./MemberIDCheckAction?id="+joinFrm.id.value;
			
			if(id.length == 0){
				alert("아이디를 입력하세요.");
				joinFrm.id.focus();
				return false;
			}
			 open(url, "confirm", "width=400,height=200,location=no" );
		
		}  
		
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/top/title.jsp"%>
	<%@include file="/WEB-INF/views/top/menu.jsp"%>
		<br/>
	<div style="padding: 1px 20px 30px 60px;">
		<h1>Register</h1>
		<form action="memJoin" name="joinFrm" method="post"
			onsubmit="return formCheck();">
			<table>
				<tr>
					<td>아이디:</td>
					<td><input class="intxt" type="text" name="id" />
					<input type="button" name="confirm_id" value="중복확인" 
								onclick="openConfirmId(this.form)" />
					</td>
				</tr>
				<tr>
					<td>닉네임:</td>
					<td><input class="intxt" type="text" name="nick" /></td>
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><input class="intxt" type="password" name="pwd" /></td>
				</tr>
				<tr>
					<td>전화번호:</td>
					<td><input class="intxt" type="text" name="phone" /></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td><input class="intxt" type="text" name="addr" /></td>
				</tr>
				<tr>
					<td colspan=2><input class="button" type="submit" value="회원가입" />
						<a href="javascript:location.href='/'" class="button">되돌아가기</a></td>
				</tr>
			</table>
		</form>
	</div>




</body>
</html>

<%-- 
	버튼 CSS 관련 사용법을 얻을 수 있다.
	http://www.red-team-design.com/wp-content/uploads/2011/09/awesome-css3-buttons.html
 --%>