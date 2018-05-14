package com.zhyl.dao;

import com.zhyl.entity.UserRole;

public interface IUserRoleDao {

	/**
	 * 删除数据，解绑用户角色
	 * @param userRole
	 * @return
	 */
	public boolean deleteUserRole(UserRole userRole);
	
	/**
	 * 添加数据，绑定用户角色
	 * @param userRole
	 * @return
	 */
	public boolean addUserRole(UserRole userRole);
}
