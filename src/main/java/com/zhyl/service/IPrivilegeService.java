package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.Privilege;
import com.zhyl.entity.Role;

public interface IPrivilegeService {

	/**
	 * 添加权限
	 * @param privilege
	 * @return
	 */
	public boolean addPrivilege(Privilege privilege);
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Privilege> findPrivilegeLst();
	
	/**
	 * 根据角色id查询该角色未拥有的权限
	 * @param role
	 * @return
	 */
	public List<Privilege> findPrivilegeNoBindingListByRole(Role role);
}
