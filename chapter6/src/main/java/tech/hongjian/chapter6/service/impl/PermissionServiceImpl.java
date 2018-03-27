package tech.hongjian.chapter6.service.impl;

import tech.hongjian.chapter6.dao.PermissionDao;
import tech.hongjian.chapter6.dao.impl.PermissionDaoImpl;
import tech.hongjian.chapter6.entity.Permission;
import tech.hongjian.chapter6.service.PermissionService;

/**
 * @author xiahongjian 
 * @time   2018-03-27 14:00:23
 *
 */
public class PermissionServiceImpl implements PermissionService {
	private PermissionDao permissionDao = new PermissionDaoImpl();

	@Override
	public Permission create(Permission permission) {
		return permissionDao.create(permission);
	}

	@Override
	public void delete(Long id) {
		permissionDao.delete(id);
	}


	


}
