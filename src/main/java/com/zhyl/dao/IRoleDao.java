package com.zhyl.dao;

import java.util.List;

import com.zhyl.entity.Role;

public interface IRoleDao {

	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	
	/**
	 * ִ��hql����ҷ���Role����List
	 * @return
	 */
	public List<Role> queryRoleHql(String hql);
	
	/**
	 * ִ��hql����ҷ��طǷ���List
	 * @return
	 */
	public List queryHql(String hql);
	
	public List<Role> queryRoleSql(String sql);
	
}
