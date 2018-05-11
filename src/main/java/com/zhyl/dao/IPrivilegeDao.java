package com.zhyl.dao;

import java.util.List;

import com.zhyl.entity.Privilege;

public interface IPrivilegeDao {
	
	/**
	 * 添加权限
	 * @param privilege
	 * @return
	 */
	public boolean addPrivilege(Privilege privilege);

	/**
	 * 执行sql语句返回Privilege泛型List
	 * @param sql
	 * @return
	 */
	public List<Privilege> queryPrivilegeSql(String sql);
	
	/**
	 * 执行hql语句返回Privilege泛型List
	 * @param hql
	 * @return
	 */
	public List<Privilege> queryPrivilegeHql(String hql);
}
