package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.Role;
import com.zhyl.entity.User;
import com.zhyl.entity.UserRole;

public interface IUserRoleService {

	/**
	 * ����IDɾ�����ݣ�����û���ɫ
	 * @param userRole
	 * @return
	 */
	public boolean deleteUserRoleById(UserRole userRole);
	
	/**
	 * ��ѯ���û�û�а󶨵Ľ�ɫ
	 * @param user
	 * @return
	 */
	public List<Role> findRoleNoBindingListByUser(User user);
	
	/**
	 * ������ݣ����û���ɫ
	 * @param userRole
	 * @return
	 */
	public boolean addUserRole(UserRole userRole);
}
