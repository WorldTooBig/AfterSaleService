package com.zhyl.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhyl.entity.Role;
import com.zhyl.entity.User;
import com.zhyl.entity.UserRole;
import com.zhyl.service.IUserRoleService;

@Controller("userRoleAction")
@Scope("prototype")
public class UserRoleAction {

	@Resource(name = "userRoleService")
	private IUserRoleService userRoleService;

	private User user;
	private Role role;
	private UserRole userRole;
	private List<Role> roleList;
	private int[] rno;
	
	/**
	 * ������ݣ����û���ɫ
	 * @return
	 */
	public String addUserRole() {
		role = new Role();
		for (int i = 0; i < rno.length; i++) {
			role.setRno(rno[i]);
			userRole.setRole(role);
			if(userRoleService.addUserRole(userRole)) {
				
			}
		}
		return "addUserRole";
	}
	
	/**
	 * ɾ���������ݣ�����û���ɫ
	 * @return
	 */
	public String deleteUserRole() {
		if(userRoleService.deleteUserRoleById(userRole)) {
			
		}
		return "deleteUserRole";
	}

	/**
	 * ��ѯ���û�û�а󶨵Ľ�ɫ
	 * @return
	 */
	public String findRoleNoBindingListByUser() {
		roleList = userRoleService.findRoleNoBindingListByUser(user);
		return "findRoleNoBindingListByUser";
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public int[] getRno() {
		return rno;
	}

	public void setRno(int[] rno) {
		this.rno = rno;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
}
