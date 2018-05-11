package com.zhyl.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhyl.entity.RolePrivilege;
import com.zhyl.service.IRolePrivilegeService;

@Controller("rolePrivilegeAction")
@Scope("prototype")
public class RolePrivilegeAction {

	@Resource(name = "rolePrivilegeService")
	private IRolePrivilegeService rolePrivilegeService;
	
	private RolePrivilege rolePrivilege;
	private List<RolePrivilege> list;
	private int[] rpno;
	
	public String findRolePrivilegeList() {
		list = rolePrivilegeService.findRolePrivilege();
		return "findRolePrivilegeList";
	}
	
	public String deleteRolePrivilegeById() {
		if(rolePrivilegeService.deleteRolePrivelegeById(rolePrivilege)) {
		}
		return "deleteRolePrivilegeById";
	}
	
	public String findPrivilegeNoBindingListByRole() {
		
		return "findPrivilegeNoBindingListByRole";
	}

	public RolePrivilege getRolePrivilege() {
		return rolePrivilege;
	}

	public void setRolePrivilege(RolePrivilege rolePrivilege) {
		this.rolePrivilege = rolePrivilege;
	}

	public List<RolePrivilege> getList() {
		return list;
	}

	public void setList(List<RolePrivilege> list) {
		this.list = list;
	}


	public void setRolePrivilegeService(IRolePrivilegeService rolePrivilegeService) {
		this.rolePrivilegeService = rolePrivilegeService;
	}
	
	
}
