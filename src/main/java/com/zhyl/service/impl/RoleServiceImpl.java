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
	 * 添加角色
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role) {
		
		return roleDao.addRole(role);
	}

	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> findRoleList() {
		String hql = "FROM Role order by rno";
		return roleDao.queryRoleHql(hql);
	}

	/**
	 * 查询所有角色及其拥有的权限
	 * @return
	 */
	public List findRoleAndPrivilege() {
		String hql = "select r.rname, p.pname from RolePrivilege rp left join rp.role r left join rp.privilege p order by rp.rno";
		return roleDao.queryHql(hql);
	}

	/**
	 * 根据传入的Role的id查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
	public List findRoleAndPrivilegeByRoleId(Role role) {
		String hql = "select rp.rpno, p.pname from RolePrivilege rp left join rp.role r left join rp.privilege p where r.rno = " + role.getRno() + " order by r.rno";
		return roleDao.queryHql(hql);
	}
	
	/**
	 * 根据传入的Role的rname查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
	public List findRoleAndPrivilegeByRoleName(Role role) {
		String hql = "select rp.rpno, p.pname from RolePrivilege rp left join rp.role r left join rp.privilege p where r.rno = " + role.getRname() + " order by r.rno";
		return roleDao.queryHql(hql);
	}

}
