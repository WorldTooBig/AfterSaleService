package com.zhyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhyl.dao.IPrivilegeDao;
import com.zhyl.dao.IUserDao;
import com.zhyl.entity.Privilege;
import com.zhyl.entity.User;
import com.zhyl.service.IUserService;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

	@Resource(name = "userDao")
	private IUserDao userDao;
	@Resource(name = "privilegeDao")
	private IPrivilegeDao privilegeDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setPrivilegeDao(IPrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	/**
	 * 用户登录
	 */
	public List<Privilege> userLogin(User user) {
		String hql = "from User where unum = '" + user.getUnum() + "'";
		List<User> list = userDao.queryUserHql(hql);
		for (User u : list) {
			if(user.getUpwd().equals(u.getUpwd())) {
				//用户名和密码匹配则查询出该用户下的所有权限
				String sql = "select pname from ylzh_privilege where pno in (select pno from ylzh_roleprivilege where rno in (select rno from ylzh_userrole where uno in (select uno from ylzh_user where uno = " + u.getUno() + ")))";
				return privilegeDao.queryPrivilegeSql(sql);
			}
		}
		return null;
	}

	/**
	 * 添加用户
	 */
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	/**
	 * 查询所有用户信息
	 */
	public List<User> findUserList() {
		String hql = "FROM User";
		return userDao.queryUserHql(hql);
	}

}
