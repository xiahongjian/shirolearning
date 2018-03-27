package tech.hongjian.chapter6.dao;

import tech.hongjian.chapter6.entity.Role;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:56:06
 *
 */
public interface RoleDao {

	Role create(Role role);

	void delete(Long roleId);

	void correlationPermissions(Long roleId, Long... permissionIds);

	void uncorrelationPermissions(Long roleId, Long... permissionIds);

}