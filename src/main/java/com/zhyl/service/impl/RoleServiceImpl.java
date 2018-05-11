package com.zhyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhyl.dao.IRoleDao;
import com.zhyl.entity.Role;
import com.zhyl.service.IRoleService;

@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements IRoleService {

	@Resource(name = "roleDao")
	private IRoleDao roleDao;
	
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}


	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role) {
		
		return roleDao.addRole(role);
	}

	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public List<Role> findRoleList() {
		String hql = "FROM Role order by rno";
		return roleDao.queryRoleHql(hql);
	}

	/**
	 * ��ѯ���н�ɫ����ӵ�е�Ȩ��
	 * @return
	 */
	public List findRoleAndPrivilege() {
		String hql = "select r.rname, p.pname from RolePrivilege rp left join rp.role r left join rp.privilege p order by rp.rno";
		return roleDao.queryHql(hql);
	}

	/**
	 * ���ݴ����Role��id��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List findRoleAndPrivilegeByRoleId(Role role) {
		String hql = "select rp.rpno, p.pname from RolePrivilege rp left join rp.role r left join rp.privilege p where r.rno = " + role.getRno() + " order by r.rno";
		return roleDao.queryHql(hql);
	}
	
	/**
	 * ���ݴ����Role��rname��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List findRoleAndPrivilegeByRoleName(Role role) {
		String hql = "select rp.rpno, p.pname from RolePrivilege rp left join rp.role r left join rp.privilege p where r.rno = " + role.getRname() + " order by r.rno";
		return roleDao.queryHql(hql);
	}

}
