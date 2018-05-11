package com.zhyl.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhyl.entity.Privilege;
import com.zhyl.service.IPrivilegeService;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction {

	@Resource(name = "privilegeService")
	private IPrivilegeService privilegeService;

	private Privilege privilege;
	private List<Privilege> privilegeList;
	private String errorInfo;
	private int[] rpno;
	
	/**
	 * 添加权限
	 * @return
	 */
	public String addPrivilege() {
		if(privilegeService.addPrivilege(privilege)) {
			errorInfo = "添加权限成功";
		}
		errorInfo = "添加权限失败";
		return "addPrivilege";
	}
	
	/**
	 * 获取所有权限
	 * @return
	 */
	public String findPrivilegeList() {
		privilegeList = privilegeService.findPrivilegeLst();
		ActionContext.getContext().put("privilegeList", privilegeList);
		return "findPrivilegeList";
	}
	
	public String findPrivilegeNoBindingListByRole() {
		
		return "findPrivilegeNoBindingListByRole";
	}
	
	
	public void setPrivilegeService(IPrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public List<Privilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	
}
