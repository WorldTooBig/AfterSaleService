package com.zhyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhyl.dao.IRolePrivilegeDao;
import com.zhyl.entity.Privilege;
import com.zhyl.entity.RolePrivilege;
import com.zhyl.service.IRolePrivilegeService;

@Service("rolePrivilegeService")
@Transactional(propagation = Propagation.REQUIRED)
public class RolePrivilegeServiceImpl implements IRolePrivilegeService {

	@Resource(name = "rolePrivilegeDao")
	private IRolePrivilegeDao rolePrivilegeDao;
	
	public void setRolePrivilegeDao(IRolePrivilegeDao rolePrivilegeDao) {
		this.rolePrivilegeDao = rolePrivilegeDao;
	}


	/**
	 * ��ѯ���н�ɫȨ�ޱ���Ϣ
	 * @return
	 */
	public List<RolePrivilege> findRolePrivilege() {
		String hql = "from RolePrivilege";
		return rolePrivilegeDao.queryRolePrivilegeHql(hql);
	}

	/**
	 * ����IDɾ���ý�ɫȨ����Ϣ
	 * @param rolePrivilege
	 * @return
	 */
	public boolean deleteRolePrivelegeById(RolePrivilege rolePrivilege) {
		return rolePrivilegeDao.deleteRolePrivilege(rolePrivilege);
	}

	/**
	 * Ϊ��ɫ��Ȩ��
	 * @param rolePrivilege
	 * @return
	 */
	public boolean addRolePrivilege(RolePrivilege rolePrivilege) {
		return rolePrivilegeDao.addRolePrivilege(rolePrivilege);
	}

}
