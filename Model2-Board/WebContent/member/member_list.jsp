<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="java.util.*" %>
<%@ page import ="net.board.db.*" %>
<%
	List memberlist = (List)request.getAttribute("memberlist");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
<center>
	<table border = "1" width = "300">
		<tr align = "center">
			<td colspan = "2">회원 목록</td>
		</tr>
		<%
			for(int i=0; i<memberlist.size(); i++){
				MemberBean member = (MemberBean)memberlist.get(i);
		%>
		
		<tr align = "center">
			<td>
				<a href = "MemberViewAction.me?id=<%=member.getID()%>">
					<%=member.getID()%>
				</a>
			</td>
			<td>
				<a href = "MemberDeleteAction.me?id=<%=member.getID()%>">삭제</a>
			</td>
		</tr>
		
		<%} %>
		
		<tr align = "center">
			<td colspan = "2">
				<a href = "./BoardList.do">[게시판 목록 이동]</a>
			</td>
		</tr>
	
	</table>
</center>
</body>
</html>