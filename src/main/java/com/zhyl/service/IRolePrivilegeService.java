package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.RolePrivilege;

public interface IRolePrivilegeService {

	/**
	 * 查询所有角色权限表信息
	 * @return
	 */
	public List<RolePrivilege> findRolePrivilege();
	
	/**
	 * 根据ID删除该角色权限信息
	 * @param rolePrivilege
	 * @return
	 */
	public boolean deleteRolePrivelegeById(RolePrivilege rolePrivilege);
	
	/**
	 * 为角色绑定权限
	 * @param rolePrivilege
	 * @return
	 */
	public boolean addRolePrivilege(RolePrivilege rolePrivilege);
}
