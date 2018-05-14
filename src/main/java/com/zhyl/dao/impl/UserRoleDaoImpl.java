package com.zhyl.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhyl.dao.IUserRoleDao;
import com.zhyl.entity.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseDao implements IUserRoleDao {

	/**
	 * ɾ�����ݣ�����û���ɫ
	 * @param userRole
	 * @return
	 */
	public boolean deleteUserRole(UserRole userRole) {
		try {
			getSession().delete(userRole);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ������ݣ����û���ɫ
	 * @param userRole
	 * @return
	 */
	public boolean addUserRole(UserRole userRole) {
		try {
			getSession().save(userRole);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
