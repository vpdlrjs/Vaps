<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="dao" class="com.vaps.dao.MembersDAO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script>
function windowclose(){
	close(this);
}
	

</script>
</head>
<body>

<c:if test="${xx == 1}">
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr align="center">
	<td height="30">
		<font size="2">이미 사용 중인 아이디입니다.</font>
	</td>
	</tr>
</table>

<form action="./MemberIDCheckAction" method="post" name="joinFrm" >
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
	<td align="center">
		<font size="2">다른 아이디를 선택하세요.</font><p>
		<input type="text" size="10" maxlength="12" name="id"/>
		<input type="submit" value="중복확인" onclick="MemberIDCheckAction()"/>
	</td>					
	</tr>
</table>
</form>
</c:if>
<c:if test="${xx == 0}">
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
		<font size="2">사용할 수 있는 아이디입니다.</font>
		<br/><br/>
		<input type="button" value="닫기" onclick="windowclose()" />
		</td>
	</tr>
</table>
</c:if>

</body>
</html>





