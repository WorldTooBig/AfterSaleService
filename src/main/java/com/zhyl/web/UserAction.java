package com.zhyl.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhyl.entity.Privilege;
import com.zhyl.entity.Role;
import com.zhyl.entity.User;
import com.zhyl.service.IUserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction {
	
	@Resource(name = "userService")
	private IUserService userService;
	
	private User user;
	
	private List list;
	private List<User> userList;
	private List<Role> roleList;
	private String errorInfo;
	
	/**
	 * 用户登录
	 * @return
	 */
	public String userLogin() {
		roleList = userService.userLogin(user);
		if(roleList != null) {
			//成功则获取该用户拥有的权限
			ActionContext.getContext().getSession().put("user_role", roleList);
			return "index";
		}
		ActionContext.getContext().getSession().put("login_lose", "用户名或密码错误");
		return "login";
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	public String addUser() {
		if(userService.addUser(user)) {
			errorInfo = "添加用户成功";
		}
		errorInfo = "添加用户失败";
		return "add";
	}
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public String findUserList() {
		userList = userService.findUserList();
		return "findUserList";
	}
	
	/**
	 * 查询所有用户和它的角色
	 * @return
	 */
	public String findUserAndRoleList() {
		list = userService.findUserAndRoleList();
		return "findUserAndRoleList";
	}
	
	/**
	 * 根据用户查询该用户的角色
	 * @return
	 */
	public String findUserAndROleByUserList() {
		list = new ArrayList();
		userList = userService.findUserList();
		for (User user : userList) {
			List l = new ArrayList();
			l.add(user);
			l.add(userService.findUserAndRoleByUserList(user));
			list.add(l);
		}
		return "findUserAndROleByUserList";
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	
}
