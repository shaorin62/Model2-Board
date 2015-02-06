<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
 
	
	<script language = "javascript">
		function moveFocus(){
			if(event.keyCode ==13){
				
				loginform.submit()
				//alert("엔터를 눌렀습니다.");
			}
		}
	
	</script>

<title>Login Page Start</title>
</head>
<body>
<form name = "loginform" action = "./MemberLoginAction.me" method = "post">
	<center>
		<table border = "1">
			<tr>
				<td colspan = "2" align = "center">
					<b><font size = "5">로그인 페이지</font></b>
				</td>
			</tr>
			<tr>
				<td>아이디 : </td>
				<td><input type= "text" name = "ID" >
				</td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type= "password" name = "PASSWORD" onkeydown="moveFocus()"></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<a href = "javascript:loginform.submit()">로그인</a>&nbsp;&nbsp;
					<a href = "./MemberJoin.me">회원가입</a>
				</td>
			</tr>
		</table>
	</center>
</form>

</body>
</html>