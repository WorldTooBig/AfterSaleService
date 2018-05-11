package com.zhyl.dao;

import java.util.List;

import com.zhyl.entity.RolePrivilege;

public interface IRolePrivilegeDao {

	public boolean addRolePrivilege(RolePrivilege rolePrivilege);
	
	public boolean deleteRolePrivilege(RolePrivilege rolePrivilege);
	
	public List<RolePrivilege> queryRolePrivilegeHql(String hql);
}
