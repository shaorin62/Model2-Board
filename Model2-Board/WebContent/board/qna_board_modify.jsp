<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
 <%@ page import = "net.board.db.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	BoardBean board = (BoardBean)request.getAttribute("boarddata");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>MVC �Խ���</title>
	<script type="text/javascript">
		function modifyboard(){
			modifyform.submit();
		}
	</script>
</head>
<body>
<!-- �Խ��� ���� -->
	<form action = "BoardModifyAction.do" method = "post" name = "modifyform">
		<input type = "hidden" name = "BOARD_NUM" value = <%= board.getBOARD_NUM()%>>
			<table cellpadding = "0" cellspacing = "0">
				<tr align = "center" valign="middle">
					<td colspan="5">MVC �Խ���</td>
				</tr>
				<tr>
					<td height="16" style = "font-family:����; font-size:12pt;">
						<div align = "center">����</div>
					</td>
					<td>
						<input name = "BOARD_SUBJECT" size = "50" maxlength="100"  value="<%=board.getBOARD_SUBJECT()%>"/>
					</td>
				</tr>
				<tr>
					<td style = "font-family:����; font-size:12pt;">
						<div align = "center">����</div>
					</td>
					<td>
						<textarea name = "BOARD_CONTENT" rows="15" cols="67"  >
							<%=board.getBOARD_CONTENT()%>
						</textarea>
					</td>
				</tr>
				<%if((board.getBOARD_FILE()==null)){ %>
					<tr>
						<td style = "font-family:����; font-size:12pt;">
							<div align= "center">���� ÷��</div>
						</td>
						<td>
								&nbsp;&nbsp;<%=board.getBOARD_FILE() %>
						</td>
					</tr>
				<%} %>
				<tr>
					<td style = "font-family:����; font-size:12pt;">
						<div align = "center">��й�ȣ</div>
					</td>
					<td>
						<input type = "password" name = "BOARD_PASS"/>
					</td>
				</tr>
				<tr bgcolor = "cccccc">
					<td colspan = "2" style = "height: 1px;">
					</td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr align = "center" valign = "middle">
					<td colspan="5">
						<font size = "2">
							<a href = "javascript:modifyboard()">[����]</a>&nbsp;&nbsp;
							<a href = "javascript:history.go(-1)">[�ڷ�]</a>&nbsp;&nbsp;
						</font>
					</td>
				</tr>
			</table>
	</form>
</body>
</html>