<%@page import="net.board.action.BoardListAction"%>
<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<%@ page import = "net.board.db.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	BoardBean board = (BoardBean)request.getAttribute("Boarddata");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>MVC �Խ���</title>
</head>
<body>
<!-- �Խ��� ���� -->
	<table cellpadding = "1" cellspacing = "0" >
		<tr align = "center" valign = "middle">
			<td colspan = "5">MVC �Խ���</td>
		</tr>
		<tr bgcolor = "cccccc">
			<td style = "font-family:����; font-size:12pt;" height="16">
				<div align = "center">�۹�ȣ&nbsp;&nbsp;</div>
			</td>
			<td>
				<%=board.getBOARD_NUM() %>
			</td>
		</tr>
		<tr>
			<td style = "font-family:����; font-size:12pt;" height="16">
				<div align = "center">����&nbsp;&nbsp;</div>
			</td>
			<td style = "font-family:����; font-size:12pt;">
				<%=board.getBOARD_SUBJECT() %>&nbsp;&nbsp;
			</td>
		</tr>
		<tr bgcolor = "cccccc">
			<td colspan = "2" style = "height = 1px;">
			</td>
		</tr>
		<tr bgcolor = "cccccc">
			<td style = "font-family:����; font-size:12pt;">
				<div align = "center">����</div>
			</td>
			<td style = "font-family:����; font-size:12pt;">
				<table border = "0" width = "490" height = "250" style = "table-layout:fixed">
					<tr>
							<td valign = top style = "font-family:����; font-size:12pt;"><%=board.getBOARD_CONTENT() %></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style = "font-family:����; font-size:12pt;">
				<div align = "center">÷������</div>
			</td>
			<td style = "font-family:����; font-size:12pt;">
				<%if((board.getBOARD_FILE() != null)){ %>
					<a href="./boardupload/<%=board.getBOARD_FILE()%>">
						<%=board.getBOARD_FILE() %>
					</a>
				<%} %>
			</td>
		</tr>
		<tr bgcolor = "cccccc">
			<td colspan = "2" style = "height:1px;"></td>
		</tr>
		<tr>
			<td colspan = "2">&nbsp;</td>
		</tr>
		<tr align = "center" valign = "middle">
			<td colspan = "5">
				<font size = "2">
					<a href = "./BoardReplyView.do?num=<%=board.getBOARD_NUM()%>">[�亯]</a>&nbsp;&nbsp;
					<a href = "./BoardModify.do?num=<%=board.getBOARD_NUM()%>">[����]</a>&nbsp;&nbsp;
					<a href = "./BoardDelete.do?num=<%=board.getBOARD_NUM()%>">[����]</a>&nbsp;&nbsp;
					<a href = "./BoardList.do">[���]</a>&nbsp;&nbsp;
				</font>
			</td>
		</tr>
	</table>
	<!-- �Խ��� ���� -->
</body>
</html>