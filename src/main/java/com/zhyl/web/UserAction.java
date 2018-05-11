package com.zhyl.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhyl.entity.Privilege;
import com.zhyl.entity.User;
import com.zhyl.service.IUserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction {
	
	@Resource(name = "userService")
	private IUserService userService;
	
	private User user;
	
	private List<User> userList;
	private List<Privilege> privilegeList;
	private String errorInfo;
	
	/**
	 * 用户登录
	 * @return
	 */
	public String userLogin() {
		privilegeList = userService.userLogin(user);
		if(privilegeList != null) {
			//获取到用户信息
			ActionContext.getContext().getSession().put("user_login", user);
			//成功则获取该用户拥有的权限
			ActionContext.getContext().getSession().put("user_privilege", privilegeList);
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Privilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
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
