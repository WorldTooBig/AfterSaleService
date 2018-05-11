package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.Role;

public interface IRoleService {

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> findRoleList();
	
	/**
	 * 查询所有角色及其拥有的权限
	 * @return
	 */
	public List findRoleAndPrivilege();

	/**
	 * 根据传入的Role的id查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
	public List findRoleAndPrivilegeByRoleId(Role role);

	/**
	 * 根据传入的Role的rname查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
	public List findRoleAndPrivilegeByRoleName(Role role);
	
}
