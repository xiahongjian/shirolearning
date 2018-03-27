package tech.hongjian.chapter6.dao;

import tech.hongjian.chapter6.entity.Permission;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:52:31
 *
 */
public interface PermissionDao {

	Permission create(Permission permission);

	void delete(Long permissionId);

}