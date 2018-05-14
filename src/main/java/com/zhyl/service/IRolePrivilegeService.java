package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.RolePrivilege;

public interface IRolePrivilegeService {

	/**
	 * ��ѯ���н�ɫȨ�ޱ���Ϣ
	 * @return
	 */
	public List<RolePrivilege> findRolePrivilege();
	
	/**
	 * ����IDɾ���ý�ɫȨ����Ϣ
	 * @param rolePrivilege
	 * @return
	 */
	public boolean deleteRolePrivelegeById(RolePrivilege rolePrivilege);
	
	/**
	 * Ϊ��ɫ��Ȩ��
	 * @param rolePrivilege
	 * @return
	 */
	public boolean addRolePrivilege(RolePrivilege rolePrivilege);
}
