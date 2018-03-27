package tech.hongjian.chapter6.service;

import tech.hongjian.chapter6.entity.Permission;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:32:28
 *
 */
public interface PermissionService {
	Permission create(Permission permission);
	void delete(Long id);
}
