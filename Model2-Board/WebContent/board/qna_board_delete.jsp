<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>MVC 게시판</title>
</head>
<body>
<form name = "deleteForm" action = "./BoardDeleteAction.do?num=<%=num%>" method = "post">
	<table border = "1">
		<tr>
			<td>
				<font size = "2">글 비밀번호</font>
			</td>
			<td>
				<input type = "password" name = "BOARD_PASS"/>
			</td>
		</tr>
		<tr>
			<td colspan = "2" align = "center">
				<a href = "javascript:deleteForm.submit()">삭제</a>&nbsp;&nbsp;
				<a href = "javascript:history.go(-1)">돌아가기</a>
			</td>
		</tr>
	</table>
</form>

</body>
</html>