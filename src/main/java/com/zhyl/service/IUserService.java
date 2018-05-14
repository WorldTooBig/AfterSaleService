package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.Privilege;
import com.zhyl.entity.Role;
import com.zhyl.entity.User;

public interface IUserService {

	public List<Role> userLogin(User user);
	
	public boolean addUser(User user);
	
	public List<User> findUserList();
	
	public List findUserAndRoleList();
	
	public List findUserAndRoleByUserList(User user);
}
