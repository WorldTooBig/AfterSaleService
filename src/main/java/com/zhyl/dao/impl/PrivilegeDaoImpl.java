package com.zhyl.dao.impl;

import java.util.List;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitPrimaryKeyJoinColumnNameSource;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.springframework.stereotype.Repository;

import com.zhyl.dao.IPrivilegeDao;
import com.zhyl.entity.Privilege;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDao implements IPrivilegeDao {

	/**
	 * 添加权限
	 * @param privilege
	 * @return
	 */
	public boolean addPrivilege(Privilege privilege) {
		try {
			getSession().save(privilege);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 执行sql语句返回Privilege泛型List
	 * @param sql
	 * @return
	 */
	public List<Privilege> queryPrivilegeSql(String sql) {
		try {
			return getSession().createSQLQuery(sql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 执行hql语句返回Privilege泛型List
	 * @param hql
	 * @return
	 */
	public List<Privilege> queryPrivilegeHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
