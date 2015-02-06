<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>회원가입 페이지</title>
</head>
<body>
<form name = "joinform" action = "MemberJoinAction.me" method = "post">
<center>
	<table border = "1">
		<tr>
			<td colspan = "2" align = "center">
				<b><font size = "5">회원가입 페이지</font></b>
			</td>
		</tr>
		<tr>
			<td>아이디 : </td>
			<td><input type = "text" name = "ID"></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type = "password" name = "PASSWORD"></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><input type = "text" name = "NAME"></td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td><input type = "text" name = "AGE" maxlength="5" size = "5"></td>
		</tr>
		<tr>
			<td>성별 : </td>
			<td>
				<input type = "radio" name = "GENDER" value="남" checked="checked">남
				<input type = "radio" name = "GENDER" value="여" >여
			</td>
		</tr>
		<tr>
			<td>이메일 주소 : </td>
			<td>
				<input type = "text" name = "EMAIL" size = "30">
			</td>
		</tr>
		<tr>
			<td colspan = "4" align = "center">
				<a href = "javascript:joinform.submit();">회원가입</a>
				<a href = "javascript:joinform.reset();">다시작성</a>
			</td>
		</tr>
	</table>
</center>
</form>
</body>
</html>