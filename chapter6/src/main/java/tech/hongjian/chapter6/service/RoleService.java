package tech.hongjian.chapter6.service;

import tech.hongjian.chapter6.entity.Role;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:33:27
 *
 */
public interface RoleService {
	Role create(Role role);
	void delete(Long id);
	void correlationPermissions(Long roleId, Long...permissionIds);
	void uncorrelationPermissions(Long roleId, Long...permissionIds);
}
