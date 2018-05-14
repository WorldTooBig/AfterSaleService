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
	 * �û���¼
	 */
	public List<Role> userLogin(User user) {
		String hql = "from User where unum = '" + user.getUnum() + "'";
		List<User> list = userDao.queryUserHql(hql);
		for (User u : list) {
			if(user.getUpwd().equals(u.getUpwd())) {
				//��ȡ���û���Ϣ
				ActionContext.getContext().getSession().put("user_login", u);
				//�û���������ƥ�����ѯ�����û��µ�����Ȩ��
//				String sql = "select pname from ylzh_privilege where pno in (select pno from ylzh_roleprivilege where rno in (select rno from ylzh_userrole where uno = " + u.getUno() + "))";
//				return privilegeDao.queryPrivilegeSql(sql);
				//�û���������ƥ�����ѯ�����û������н�ɫ
				String h   = "select r.rname from UserRole ur right join ur.role r where ur.user.uno = " + u.getUno() + ")";
				return roleDao.queryRoleHql(h);
			}
		}
		return null;
	}

	/**
	 * ����û�
	 */
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	/**
	 * ��ѯ�����û���Ϣ
	 */
	public List<User> findUserList() {
		String hql = "FROM User";
		return userDao.queryUserHql(hql);
	}

	/**
	 * ��ѯ�����û��Լ����Ľ�ɫ
	 */
	public List findUserAndRoleList() {
		String hql = "select u.uname, r.rname from User u left join UserRole ur on u.uno = ur.uno left ru.role r";
		return userDao.queryHql(hql);
	}

	/**
	 * ����user��ѯ���û������н�ɫ
	 */
	public List findUserAndRoleByUserList(User user) {
		String hql = "select ur.urno, r.rname from UserRole ur left join ur.user u left join ur.role r where u.uno = " + user.getUno() + " order by r.rno";
		return userDao.queryHql(hql);
	}
	
	

}
