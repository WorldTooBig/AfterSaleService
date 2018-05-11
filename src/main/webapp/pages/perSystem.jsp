<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>

	<h2>${user_login.unum }</h2>
	<h3>${user_privilege.size() }</h3>
	<s:iterator var="p" value="#session.user_privilege" status="i">
		<s:iterator var="s" value="#p">
		${s }<hr/>
		</s:iterator>
	</s:iterator>


<div style="float: left; width: 100%">
	<div style="float:left; width:30%;">
		<h2>添加用户</h2>
		<s:form action="userAction_addUser" method="post">
			登录工号：<s:textfield name="user.unum"/><br/>
			登录密码：<s:password name="user.upwd"/><br/>
			真实姓名：<s:textfield name="user.uname"/><br/>
			所在部门：<s:textfield name="user.udept"/><br/>
			<s:submit value="提交"/>
		</s:form>
	</div>
	
	<div style="float:left; width:30%;">
		<p></p>
		<h2>添加角色</h2>
		<s:form action="roleAction_addRole" method="post">
			角色名：<s:textfield name="role.rname"/><br/>
			<s:submit value="提交"/>
		</s:form>
	</div>
	
	<div style="float:left; width:30%;">
		<p></p>
		<h2>添加权限</h2>
		<s:form action="privilegeAction_addPrivilege" method="post">
			权限名：<s:textfield name="privilege.pname"/><br/>
			<s:submit value="提交"/>
		</s:form>
	</div>
</div>
	
	<hr>
	<div id="userDiv">
		<h2>用户信息</h2>
		<%-- <a href="${pageContext.request.contextPath}/userAction_findUserList">查询用户信息</a> --%>
		<table border=1>
			<tr>
				<th>序号</th><th>用户名</th><th>密码</th><th>真实名</th><th>部门</th>
			</tr>
			<%-- <s:iterator var="user" value="#userList" status="itm">
			<tr>
				<td>${itm.count }</td><td>${user.unum }</td><td>${user.upwd }</td><td>${user.uname }</td><td>${user.udept }</td>
			</tr>
			</s:iterator> --%>
		</table>
	</div>
	
	<div id="roleDiv">
		<h2>角色信息</h2>
		<%-- <a href="${pageContext.request.contextPath}/roleAction_findRoleAndPrivilege">查询角色信息</a> --%>
		<ul>
			<%-- <c:forEach var="r" items="${map }">
				<li>${r.key.rname }
					<ol>
					<c:forEach var="v" items="${r.value }">
						<li>${v[1] }-------------------<a href="${pageContext.request.contextPath}/rolePrivilegeAction_deleteRolePrivilegeById?rolePrivilege.rpno=${v[0] }">解绑</a></li>
					</c:forEach>
					</ol>
				</li>	
			</c:forEach> --%>
			<%-- <s:iterator var="r" value="${list }" status="itm">
			<li>${r.rname }
				<ol>
					<s:iterator var="privilege" value="#r">
					<li>${privilege.pname }
					<c:if test="${!empty privilege.pname}">
					${privilege.pname }
					</c:if>
					</li>
					</s:iterator>
				</ol>
			</li>
			</s:iterator> --%>
		</ul>
	</div>
	<br/>
	
	<hr>
	<div id="perDiv">
		<h2>权限信息</h2>
		<%-- <a href="${pageContext.request.contextPath}/privilegeAction_findPrivilegeList">查询权限信息</a> --%>
		<ul>
			<%-- <s:iterator var="per" value="#privilegeList" status="num">
			<li>${per.pname }</li>
			</s:iterator> --%>
		</ul>
	</div>
	
	<div id="fixDiv" style="position: fixed; top: 20%; left: 35%; width: 30%; height: 50%; background-color: RGBA(0,0,0,0.5);">
	
	</div>
	
</body>
<script>
	
	window.onload = start();

	function start() {
		userFind();
		roleFind();
		perFind();
		fixDivToggle();
	}
	
	function userFind() {
		$.post("userAction_findUserList", null, function(data){
			$("#userDiv table tr:not(:first)").remove();
			var strs = "";
			$.each(data.userList, function(i, v){
				strs += "<tr>";
				strs += "<td>" + (++i) + "</td>";
				strs += "<td>" + v.unum + "</td>";
				strs += "<td>" + v.upwd + "</td>";
				strs += "<td>" + v.uname + "</td>";
				strs += "<td>" + v.udept + "</td>";
				strs += "</tr>";
			});
			$("#userDiv table").append(strs);
		}, "json");
	}
	
	function roleFind() {
		$.post("roleAction_findRoleAndPrivilege", null, function(data){
			$("#roleDiv ul").empty();
			var strs = "";
			$.each(data.map, function(key, val){
				strs += "<li>" + key;
				strs += "<ol>";
				$.each(val, function(i, v){
					strs += '<li>';
					strs += v[1] + '-------------------<a href="\${pageContext.request.contextPath}/rolePrivilegeAction_deleteRolePrivilegeById?rolePrivilege.rpno=' + v[0] + '\">解绑</a>';
					strs += "</li>";
				});
				strs += "<input type='button' value='绑定权限' onclick=binding('" + key + "') />";
				strs += "</ol>";
				strs += "</li>";
			});
			$("#roleDiv ul").append(strs);
		}, "json");
		
	}
	
	function perFind() {
		$.post("privilegeAction_findPrivilegeList", null, function(data) {
			$("#perDiv ul").empty();
			var strs = "";
			$.each(data.privilegeList, function(i, v){
				strs += "<li>" + v.pname + "</li>";
			});
			$("#perDiv ul").append(strs);
		}, "json");
	}
	
	function binding(rname) {
		$("#fixDiv").empty();
		fixDivToggle();
		var strs = "";
		strs += "<h2>角色名：" + rname + "</h2>";
		$.post("roleAction_findRoleAndPrivilegeByRoleName", "role.rname=rname", function(data) {
			strs += "<form action='' method='post'>";
			$.each(data.list, function(i, v) {
				strs += "<input type='checkbox' name='pno'/>" + v.pname + "<br />";
			});
			strs += "<input type='submit' value='绑定权限'";
			strs += "</form>";
		}, "json");
		strs += "<input type='button' value='关闭' onclick='fixDivToggle'";
		$("#fixDiv").html();
	}
	
	function fixDivToggle() {
		var $fixDiv = $("#fixDiv");
		if($fixDiv.css("display") == "none") {
			$fixDiv.css("display", "block");
		} else {
			$fixDiv.css("display", "none");
		}
	}

</script>
</html>