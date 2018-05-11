package com.zhyl.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhyl.entity.Role;
import com.zhyl.service.IRoleService;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction {
	
	@Resource(name = "roleService")
	private IRoleService roleService;
	
	private Role role;
	private List<Role> roleList;
	private List list;
	private Map<String, List> map;
	
	private String errorInfo;
	
	/**
	 * 添加角色
	 * @return
	 */
	public String addRole() {
		if(roleService.addRole(role)) {
			errorInfo =  "添加角色成功";
		}
		errorInfo =  "添加角色失败";
		return "addRole";
	}

	/**
	 * 查询所有角色
	 * @return
	 */
	public String findRoleList() {
		roleList = roleService.findRoleList();
		ActionContext.getContext().put("roleList", roleList);
		return "findRoleList";
	}

	/**
	 * 查询所有角色及其拥有的权限
	 * @return
	 */
	public String findRoleAndPrivilege() {
		map = new HashMap();
		roleList = roleService.findRoleList();
		for (Role r : roleList) {
			map.put(r.getRname(), roleService.findRoleAndPrivilegeByRoleId(r));
		}
		return "findRoleAndPrivilege";
	}
	
	public String findRoleAndPrivilegeByRoleName() {
		list = roleService.findRoleAndPrivilegeByRoleName(role);
		return "findRoleAndPrivilegeByRoleName";
	}
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Map<String, List> getMap() {
		return map;
	}

	public void setMap(Map<String, List> map) {
		this.map = map;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	
}
