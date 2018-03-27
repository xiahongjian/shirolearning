package tech.hongjian.chapter6.dao;

import java.util.Set;

import tech.hongjian.chapter6.entity.User;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:59:04
 *
 */
public interface UserDao {

	User create(User user);

	void update(User user);

	void delete(Long userId);

	void correlationRoles(Long userId, Long... roleIds);

	void uncorrelationRoles(Long userId, Long... roleIds);

	User findOne(Long userId);

	User findByUsername(String username);

	Set<String> findRoles(String username);

	Set<String> findPermissions(String username);

}