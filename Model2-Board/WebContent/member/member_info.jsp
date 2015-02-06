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
<title>회원관리 시스템 관리자모드 [회원정보보기] </title>
</head>
<body>
<center>
	<table border = "1" width = "300">
		<tr align = "center">
			<td>아이디 : </td>
			<td><%=member.getID() %></td>
		</tr>
		<tr align = "center">
			<td>이름 : </td>
			<td><%=member.getNAME() %></td>
		</tr>
		<tr align = "center">
			<td>나이 : </td>
			<td><%=member.getAGE() %></td>
		</tr>
		<tr align = "center">
			<td>성별 : </td>
			<td><%=member.getGENDER() %></td>
		</tr>
		<tr align = "center">
			<td>이메일 주소 : </td>
			<td><%=member.getEMAIL() %></td>
		</tr>
		<tr align = "center">
			<td colspan = "2">
				<a href = "./MemberListAction.me">리스트로 돌아가기</a>
			</td>
		</tr>
	</table>
</center>
</body>
</html>