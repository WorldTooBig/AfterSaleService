package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.Privilege;
import com.zhyl.entity.User;

public interface IUserService {

	public List<Privilege> userLogin(User user);
	
	public boolean addUser(User user);
	
	public List<User> findUserList();
}
