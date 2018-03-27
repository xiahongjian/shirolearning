package tech.hongjian.chapter6.service.impl;

import tech.hongjian.chapter6.dao.RoleDao;
import tech.hongjian.chapter6.dao.impl.RoleDaoImpl;
import tech.hongjian.chapter6.entity.Role;
import tech.hongjian.chapter6.service.RoleService;

/**
 * @author xiahongjian 
 * @time   2018-03-27 14:05:47
 *
 */
public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao = new RoleDaoImpl();
	@Override
	public Role create(Role role) {
		return roleDao.create(role);
	}

	@Override
	public void delete(Long id) {
		roleDao.delete(id);
	}

	@Override
	public void correlationPermissions(Long roleId, Long... permissionIds) {
		roleDao.correlationPermissions(roleId, permissionIds);
	}

	@Override
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
		roleDao.uncorrelationPermissions(roleId, permissionIds);
	}

}
