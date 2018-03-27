package tech.hongjian.chapter6.service;

import java.util.Set;

import tech.hongjian.chapter6.entity.User;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:35:31
 *
 */
public interface UserService {
	User create(User user);
	void changePassword(Long userId, String newPassword);
	void correlationRoles(Long userId, Long...roleIds);
	void uncorrelationRoles(Long userId, Long...roleIds);
	User findByUsername(String username);
	Set<String> findRoles(String username);
	Set<String> findPermissions(String username);
}
