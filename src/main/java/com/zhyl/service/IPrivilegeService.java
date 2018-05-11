package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.Privilege;

public interface IPrivilegeService {

	/**
	 * ���Ȩ��
	 * @param privilege
	 * @return
	 */
	public boolean addPrivilege(Privilege privilege);
	
	/**
	 * ��ѯ����Ȩ��
	 * @return
	 */
	public List<Privilege> findPrivilegeLst();
	
	/**
	 * ���ݽ�ɫid��ѯ�ý�ɫδӵ�е�Ȩ��
	 * @param rno
	 * @return
	 */
	public List<Privilege> findPrivilegeNoBindingListByRole(int rno);
}
