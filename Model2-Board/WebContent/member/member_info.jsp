<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "net.board.db.*" %>
<%
	MemberBean member = (MemberBean)request.getAttribute("member");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>ȸ������ �ý��� �����ڸ�� [ȸ����������] </title>
</head>
<body>
<center>
	<table border = "1" width = "300">
		<tr align = "center">
			<td>���̵� : </td>
			<td><%=member.getID() %></td>
		</tr>
		<tr align = "center">
			<td>�̸� : </td>
			<td><%=member.getNAME() %></td>
		</tr>
		<tr align = "center">
			<td>���� : </td>
			<td><%=member.getAGE() %></td>
		</tr>
		<tr align = "center">
			<td>���� : </td>
			<td><%=member.getGENDER() %></td>
		</tr>
		<tr align = "center">
			<td>�̸��� �ּ� : </td>
			<td><%=member.getEMAIL() %></td>
		</tr>
		<tr align = "center">
			<td colspan = "2">
				<a href = "./MemberListAction.me">����Ʈ�� ���ư���</a>
			</td>
		</tr>
	</table>
</center>
</body>
</html>