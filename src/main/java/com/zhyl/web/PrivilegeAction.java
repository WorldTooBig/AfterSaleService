package com.zhyl.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhyl.entity.Privilege;
import com.zhyl.entity.Role;
import com.zhyl.service.IPrivilegeService;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction {

	@Resource(name = "privilegeService")
	private IPrivilegeService privilegeService;

	private Role role;
	private Privilege privilege;
	private List<Privilege> privilegeList;
	private String errorInfo;
	
	/**
	 * ���Ȩ��
	 * @return
	 */
	public String addPrivilege() {
		if(privilegeService.addPrivilege(privilege)) {
			errorInfo = "���Ȩ�޳ɹ�";
		}
		errorInfo = "���Ȩ��ʧ��";
		return "addPrivilege";
	}
	
	/**
	 * ��ȡ����Ȩ��
	 * @return
	 */
	public String findPrivilegeList() {
		privilegeList = privilegeService.findPrivilegeLst();
//		ActionContext.getContext().put("privilegeList", privilegeList);
		return "findPrivilegeList";
	}

	/**
	 * ���ݽ�ɫid��ѯ�ý�ɫδӵ�е�Ȩ��
	 * @return
	 */
	public String findPrivilegeNoBindingListByRole() {
		privilegeList = privilegeService.findPrivilegeNoBindingListByRole(role);
		return "findPrivilegeNoBindingListByRole";
	}
	
	
	public void setPrivilegeService(IPrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
