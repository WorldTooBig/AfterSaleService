<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userAction_userLogin" method="post">
		<input name="user.unum" /><br/>
		<input type="password" name="user.upwd" /><br/>
		<input type="submit" value="登录" />
	</form>
	<hr>
	<h2>${login_lose }</h2>
	<hr>
</body>
</html>