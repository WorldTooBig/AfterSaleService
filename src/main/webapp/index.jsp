<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<body>

	<s:iterator var="role" value="#session.user_role">
		<p>${role }</p>
	</s:iterator>
	
	<h2>Hello World!${user_login.uname }</h2>
	<a href="${pageContext.request.contextPath}/pages/perSystem.jsp">权限管理</a>
<br/><br/><br/><br/><br/>
	<table border=1>
		<tr>
			<td>1111111111</td>
			<td>2222222222</td>
			<td>3333333333</td>
		</tr>
		<tr>
			<td>5555555555555555<br>555555</td>
		</tr>
	</table>
	
</body>
</html>
