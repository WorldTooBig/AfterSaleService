package com.zhyl.dao;

import com.zhyl.entity.UserRole;

public interface IUserRoleDao {

	/**
	 * ɾ�����ݣ�����û���ɫ
	 * @param userRole
	 * @return
	 */
	public boolean deleteUserRole(UserRole userRole);
	
	/**
	 * �������ݣ����û���ɫ
	 * @param userRole
	 * @return
	 */
	public boolean addUserRole(UserRole userRole);
}