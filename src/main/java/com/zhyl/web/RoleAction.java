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
		list = new ArrayList();
		roleList = roleService.findRoleList();
		for (Role r : roleList) {
			List l = new ArrayList();
			l.add(r);
			l.add(roleService.findRoleAndPrivilegeByRoleId(r));
			list.add(l);
		}
		return "findRoleAndPrivilege";
	}

	/**
	 * 根据传入的Role的rname查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
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

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	
}
