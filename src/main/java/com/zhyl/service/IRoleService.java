package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.Role;

public interface IRoleService {

	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public List<Role> findRoleList();
	
	/**
	 * ��ѯ���н�ɫ����ӵ�е�Ȩ��
	 * @return
	 */
	public List findRoleAndPrivilege();

	/**
	 * ���ݴ����Role��id��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List findRoleAndPrivilegeByRoleId(Role role);

	/**
	 * ���ݴ����Role��rname��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List findRoleAndPrivilegeByRoleName(Role role);
	
}
