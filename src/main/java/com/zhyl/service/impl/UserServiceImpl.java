package com.zhyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.zhyl.dao.IPrivilegeDao;
import com.zhyl.dao.IRoleDao;
import com.zhyl.dao.IUserDao;
import com.zhyl.entity.Privilege;
import com.zhyl.entity.Role;
import com.zhyl.entity.User;
import com.zhyl.service.IUserService;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

	@Resource(name = "userDao")
	private IUserDao userDao;
	@Resource(name = "roleDao")
	private IRoleDao roleDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * 用户登录
	 */
	public List<Role> userLogin(User user) {
		String hql = "from User where unum = '" + user.getUnum() + "'";
		List<User> list = userDao.queryUserHql(hql);
		for (User u : list) {
			if(user.getUpwd().equals(u.getUpwd())) {
				//获取到用户信息
				ActionContext.getContext().getSession().put("user_login", u);
				//用户名和密码匹配则查询出该用户下的所有权限
//				String sql = "select pname from ylzh_privilege where pno in (select pno from ylzh_roleprivilege where rno in (select rno from ylzh_userrole where uno = " + u.getUno() + "))";
//				return privilegeDao.queryPrivilegeSql(sql);
				//用户名和密码匹配则查询出该用户的所有角色
				String h   = "select r.rname from UserRole ur right join ur.role r where ur.user.uno = " + u.getUno() + ")";
				return roleDao.queryRoleHql(h);
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

	/**
	 * 查询所有用户以及它的角色
	 */
	public List findUserAndRoleList() {
		String hql = "select u.uname, r.rname from User u left join UserRole ur on u.uno = ur.uno left ru.role r";
		return userDao.queryHql(hql);
	}

	/**
	 * 根据user查询该用户的所有角色
	 */
	public List findUserAndRoleByUserList(User user) {
		String hql = "select ur.urno, r.rname from UserRole ur left join ur.user u left join ur.role r where u.uno = " + user.getUno() + " order by r.rno";
		return userDao.queryHql(hql);
	}
	
	

}
