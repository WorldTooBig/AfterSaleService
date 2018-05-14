package com.zhyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhyl.dao.IPrivilegeDao;
import com.zhyl.entity.Privilege;
import com.zhyl.entity.Role;
import com.zhyl.service.IPrivilegeService;

@Service("privilegeService")
@Transactional(propagation = Propagation.REQUIRED)
public class PrivilegeServiceImpl implements IPrivilegeService {

	@Resource(name = "privilegeDao")
	private IPrivilegeDao privilegeDao;
	
	public void setPrivilegeDao(IPrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}


	/**
	 * ���Ȩ��
	 * @param privilege
	 * @return
	 */
	public boolean addPrivilege(Privilege privilege) {
		return privilegeDao.addPrivilege(privilege);
	}

	/**
	 * ��ѯ����Ȩ��
	 * @return
	 */
	public List<Privilege> findPrivilegeLst() {
		String hql = "FROM Privilege";
		return privilegeDao.queryPrivilegeHql(hql);
	}

	/**
	 * ���ݽ�ɫid��ѯ�ý�ɫδӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List<Privilege> findPrivilegeNoBindingListByRole(Role role) {
		int rno = role.getRno();
		String hql = "select p.pno, p.pname from RolePrivilege rp right join rp.privilege p"
				+ " where (rp.role.rno != " + rno + " or rp.role.rno is null) and p.pno not in(select rp.privilege.pno from rp where rp.role.rno = " + rno + ")"
				+ " group by p.pno, p.pname order by p.pno";
		return privilegeDao.queryPrivilegeHql(hql);
	}

}
