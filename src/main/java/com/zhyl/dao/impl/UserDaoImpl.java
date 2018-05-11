package com.zhyl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhyl.dao.IUserDao;
import com.zhyl.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements IUserDao {

	
	public List<User> queryUserHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addUser(User user) {
		try {
			getSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
