package com.zhyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhyl.dao.IRoleDao;
import com.zhyl.dao.IUserRoleDao;
import com.zhyl.entity.Role;
import com.zhyl.entity.User;
import com.zhyl.entity.UserRole;
import com.zhyl.service.IUserRoleService;

@Service("userRoleService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserRoleServiceImpl implements IUserRoleService {

	@Resource(name = "userRoleDao")
	private IUserRoleDao userRoleDao;
	@Resource(name = "roleDao")
	private IRoleDao roleDao;
	
	public void setUserRoleDao(IUserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}


	/**
	 * 根据ID删除数据，解绑用户角色
	 * @param userRole
	 * @return
	 */
	public boolean deleteUserRoleById(UserRole userRole) {
		return userRoleDao.deleteUserRole(userRole);
	}

	/**
	 * 查询该用户没有绑定的角色
	 * @param user
	 * @return
	 */
	public List<Role> findRoleNoBindingListByUser(User user) {
		int uno = user.getUno();
		String hql = "select r.rno, r.rname from UserRole ur right join ur.role r "
				+ "where (ur.role.rno != "+ uno + " or ur.role.rno is null) "
						+ "and r.rno not in(select ur.role.rno from ur where ur.user.uno = " + uno + ")"
								+ "group by r.rno, r.rname order by r.rno";
		return roleDao.queryRoleHql(hql);
	}
	/**
	 * 添加数据，绑定用户角色
	 * @param userRole
	 * @return
	 */
	public boolean addUserRole(UserRole userRole) {
		return userRoleDao.addUserRole(userRole);
	}

}
