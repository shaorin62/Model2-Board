<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>ȸ������ ������</title>
</head>
<body>
<form name = "joinform" action = "MemberJoinAction.me" method = "post">
<center>
	<table border = "1">
		<tr>
			<td colspan = "2" align = "center">
				<b><font size = "5">ȸ������ ������</font></b>
			</td>
		</tr>
		<tr>
			<td>���̵� : </td>
			<td><input type = "text" name = "ID"></td>
		</tr>
		<tr>
			<td>��й�ȣ : </td>
			<td><input type = "password" name = "PASSWORD"></td>
		</tr>
		<tr>
			<td>�̸� : </td>
			<td><input type = "text" name = "NAME"></td>
		</tr>
		<tr>
			<td>���� : </td>
			<td><input type = "text" name = "AGE" maxlength="5" size = "5"></td>
		</tr>
		<tr>
			<td>���� : </td>
			<td>
				<input type = "radio" name = "GENDER" value="��" checked="checked">��
				<input type = "radio" name = "GENDER" value="��" >��
			</td>
		</tr>
		<tr>
			<td>�̸��� �ּ� : </td>
			<td>
				<input type = "text" name = "EMAIL" size = "30">
			</td>
		</tr>
		<tr>
			<td colspan = "4" align = "center">
				<a href = "javascript:joinform.submit();">ȸ������</a>
				<a href = "javascript:joinform.reset();">�ٽ��ۼ�</a>
			</td>
		</tr>
	</table>
</center>
</form>
</body>
</html>