package com.zhyl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhyl.dao.IRoleDao;
import com.zhyl.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDao implements IRoleDao {

	/**
	 * ��ӽ�ɫ
	 */
	public boolean addRole(Role role) {
		try {
			getSession().save(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ִ��hql����ҷ���Role����List
	 * @return
	 */
	public List<Role> queryRoleHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ִ��hql����ҷ��طǷ���List
	 * @return
	 */
	public List queryHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
