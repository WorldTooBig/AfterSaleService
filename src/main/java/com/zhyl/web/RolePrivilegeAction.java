package com.zhyl.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhyl.entity.Privilege;
import com.zhyl.entity.Role;
import com.zhyl.entity.RolePrivilege;
import com.zhyl.service.IRolePrivilegeService;

@Controller("rolePrivilegeAction")
@Scope("prototype")
public class RolePrivilegeAction {

	@Resource(name = "rolePrivilegeService")
	private IRolePrivilegeService rolePrivilegeService;
	
	private Role role;
	private Privilege privilege;
	private RolePrivilege rolePrivilege;
	private List<RolePrivilege> list;
	private int[] pno;
	
	//查询角色权限信息
	public String findRolePrivilegeList() {
		list = rolePrivilegeService.findRolePrivilege();
		return "findRolePrivilegeList";
	}
	
	//根据ID删除角色权限
	public String deleteRolePrivilegeById() {
		if(rolePrivilegeService.deleteRolePrivelegeById(rolePrivilege)) {
		}
		return "deleteRolePrivilegeById";
	}
	
	//为角色绑定权限
	public String addRolePrivilege() {
		privilege = new Privilege();
		for (int i = 0; i < pno.length; i++) {
			privilege.setPno(pno[i]);
			rolePrivilege.setPrivilege(privilege);
			if(rolePrivilegeService.addRolePrivilege(rolePrivilege)) {
				
			}
		}
		return "addRolePrivilege";
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


	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int[] getPno() {
		return pno;
	}

	public void setPno(int[] pno) {
		this.pno = pno;
	}

	public void setRolePrivilegeService(IRolePrivilegeService rolePrivilegeService) {
		this.rolePrivilegeService = rolePrivilegeService;
	}
	
	
}
