package com.zhyl.dao;

import java.util.List;

import com.zhyl.entity.Role;

public interface IRoleDao {

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	
	/**
	 * 执行hql语句且返回Role泛型List
	 * @return
	 */
	public List<Role> queryRoleHql(String hql);
	
	/**
	 * 执行hql语句且返回非泛型List
	 * @return
	 */
	public List queryHql(String hql);
	
	public List<Role> queryRoleSql(String sql);
	
}
