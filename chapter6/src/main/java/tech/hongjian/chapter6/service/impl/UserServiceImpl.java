package tech.hongjian.chapter6.service.impl;

import java.util.Set;

import tech.hongjian.chapter6.dao.UserDao;
import tech.hongjian.chapter6.dao.impl.UserDaoImpl;
import tech.hongjian.chapter6.entity.User;
import tech.hongjian.chapter6.service.UserService;
import tech.hongjian.chapter6.util.PasswordHelper;

/**
 * @author xiahongjian 
 * @time   2018-03-27 14:07:52
 *
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	private PasswordHelper passwordHelper = new PasswordHelper();
	
	@Override
	public User create(User user) {
		passwordHelper.encryptPassword(user);
		return userDao.create(user);
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userDao.update(user);
	}

	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		userDao.correlationRoles(userId, roleIds);
	}

	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		userDao.uncorrelationRoles(userId, roleIds);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		return userDao.findRoles(username);
	}

	@Override
	public Set<String> findPermissions(String username) {
		return userDao.findPermissions(username);
	}

}
