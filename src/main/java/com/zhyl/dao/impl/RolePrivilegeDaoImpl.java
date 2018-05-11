package com.zhyl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhyl.dao.IRolePrivilegeDao;
import com.zhyl.entity.RolePrivilege;

@Repository("rolePrivilegeDao")
public class RolePrivilegeDaoImpl extends BaseDao implements IRolePrivilegeDao {

	public boolean addRolePrivilege(RolePrivilege rolePrivilege) {
		try {
			getSession().save(rolePrivilege);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<RolePrivilege> queryRolePrivilegeHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteRolePrivilege(RolePrivilege rolePrivilege) {
		try {
			getSession().delete(rolePrivilege);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
