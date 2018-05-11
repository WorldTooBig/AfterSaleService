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
	 * �û���¼
	 */
	public List<Privilege> userLogin(User user) {
		String hql = "from User where unum = '" + user.getUnum() + "'";
		List<User> list = userDao.queryUserHql(hql);
		for (User u : list) {
			if(user.getUpwd().equals(u.getUpwd())) {
				//�û���������ƥ�����ѯ�����û��µ�����Ȩ��
				String sql = "select pname from ylzh_privilege where pno in (select pno from ylzh_roleprivilege where rno in (select rno from ylzh_userrole where uno in (select uno from ylzh_user where uno = " + u.getUno() + ")))";
				return privilegeDao.queryPrivilegeSql(sql);
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

}
