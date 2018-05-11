package com.zhyl.service;

import java.util.List;

import com.zhyl.entity.RolePrivilege;

public interface IRolePrivilegeService {

	public List<RolePrivilege> findRolePrivilege();
	
	public boolean deleteRolePrivelegeById(RolePrivilege rolePrivilege);
}
