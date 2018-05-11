package com.zhyl.dao;

import java.util.List;

import com.zhyl.entity.Privilege;

public interface IPrivilegeDao {
	
	/**
	 * ���Ȩ��
	 * @param privilege
	 * @return
	 */
	public boolean addPrivilege(Privilege privilege);

	/**
	 * ִ��sql��䷵��Privilege����List
	 * @param sql
	 * @return
	 */
	public List<Privilege> queryPrivilegeSql(String sql);
	
	/**
	 * ִ��hql��䷵��Privilege����List
	 * @param hql
	 * @return
	 */
	public List<Privilege> queryPrivilegeHql(String hql);
}
