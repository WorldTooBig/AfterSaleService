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

	<h2>${user_login.uname }</h2>


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
		<table border=1>
			<tr>
				<th>序号</th><th>用户名</th><th>密码</th><th>真实名</th><th>部门</th>
			</tr>
		</table>
	</div>
	
	<div id="roleDiv">
		<h2>角色信息</h2>
		<ul>
		</ul>
	</div>
	<br/>
	
	<hr>
	<div id="perDiv">
		<h2>权限信息</h2>
		<ul>
		</ul>
	</div>
	
	<div id="fixDiv" style="position: fixed; top: 0; left: 0; width: 100%; height: 100%;">
		<div style="position: fixed; top: 20%; left: 35%; width: 30%; height: 50%; background-color: RGBA(0,0,0,0.5);">
		</div>
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
	
	//获得所有用户信息
	function userFind() {
		$.post("userAction_findUserAndROleByUserList", null, function(data){
			$("#userDiv table tr:not(:first)").remove();
			var strs = "";
			$.each(data.list, function(i, val){
				strs += "<tr>";
				strs += "<td>" + (++i) + "</td>";
				strs += "<td>" + val[0].unum + "</td>";
				strs += "<td>" + val[0].upwd + "</td>";
				strs += "<td>" + val[0].uname + "</td>";
				strs += "<td>" + val[0].udept + "</td>";
				strs += "</tr>";
				strs += "<tr>";
				strs += "<td colspan=5 style='padding-left:20px;'>";
				$.each(val[1], function(j, value) {
					var v = value.toString().split(",");
					strs += ++j + "." + v[1] + "------------------<a href='\${pageContext.request.contextPath}/userRoleAction_deleteUserRole?userRole.urno=" + v[0] + "'>解绑</a><br />";
				});
				strs += "<input type='button' value='绑定角色' onclick=bindingRole('" + val[0].uno + "','" + val[0].uname + "') />";
				strs += "";
				strs += "</td>";
				strs += "</tr>";
			});
			$("#userDiv table").append(strs);
		}, "json");
	}
	
	//获得所有角色信息
	function roleFind() {
		$.post("roleAction_findRoleAndPrivilege", null, function(data){
			$("#roleDiv ul").empty();
			var strs = "";
			$.each(data.list, function(i, v){
				strs += "<li>" + v[0].rname;
				strs += "<ol>";
				$.each(v[1], function(j, value){
					var val = value.toString().split(",");
					strs += '<li>';
					strs += val[1] + '-------------------<a href="\${pageContext.request.contextPath}/rolePrivilegeAction_deleteRolePrivilegeById?rolePrivilege.rpno=' + val[0] + '\">解绑</a>';
					strs += "</li>";
				});
				strs += "<input type='button' value='绑定权限' onclick=bindingPer('" + v[0].rno + "','" + v[0].rname + "') />";
				strs += "</ol>";
				strs += "</li>";
				
			});
			$("#roleDiv ul").append(strs);
		}, "json");
		
	}
	
	//获得所有权限信息
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
	
	//绑定权限
	function bindingPer(rno, rname) {
		$("#fixDiv div").empty();
		fixDivToggle();
		$.post("privilegeAction_findPrivilegeNoBindingListByRole", "role.rno=" + rno, function(data) {
			var strs = "";
			strs += "<h2>角色名：" + rname + "</h2>";
			strs += "<form action='rolePrivilegeAction_addRolePrivilege' method='post'>";
			strs += "<input type='hidden' name='rolePrivilege.role.rno' value='" + rno + "' />";
			strs += "<ul>"
			$.each(data.privilegeList, function(i, v) {
				strs += "<li><input type='checkbox' name='pno' value='" + v[0] + "' />" + v[1] + "</li>";
			});
			strs += "</ul>"
			strs += "<br /><input type='submit' value='绑定权限' />";
			strs += "</form><br />";
			strs += "<input type='button' value='关闭' onclick='fixDivToggle()' />	";
			$("#fixDiv div").html(strs);
		}, "json");
	}
	
	//绑定角色
	function bindingRole(uno, uname) {
		$("#fixDiv div").empty();
		fixDivToggle();
		$.post("userRoleAction_findRoleNoBindingListByUser", "user.uno=" + uno, function(data) {
			var strs = "";
			strs += "<h2>用户名：" + uname + "</h2>";
			strs += "<form action='userRoleAction_addUserRole' method='post'>";
			strs += "<input type='hidden' name='userRole.user.uno' value='" + uno + "' />";
			strs += "<ul>";
			$.each(data.roleList, function(i, v) {
				strs += "<li><input type='checkbox' name='rno' value='" + v[0] + "' />" + v[1] + "</li>";
			});
			strs += "</ul>";
			strs += "<br /><input type='submit' value='绑定角色' />";
			strs += "</form><br />";
			strs += "<input type='button' value='关闭' onclick='fixDivToggle()' />";
			$("#fixDiv div").html(strs);
		}, "json");
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