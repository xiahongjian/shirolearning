package tech.hongjian.chapter6.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import tech.hongjian.chapter6.entity.User;
import tech.hongjian.chapter6.service.UserService;
import tech.hongjian.chapter6.service.impl.UserServiceImpl;

/**
 * @author xiahongjian 
 * @time   2018-03-27 14:20:40
 *
 */
public class UserRealm extends AuthorizingRealm {
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.findRoles(username));
		authorizationInfo.setStringPermissions(userService.findPermissions(username));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = userService.findByUsername(username);
		if (user == null) {
			throw new UnknownAccountException();
		}
		if (Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					user.getUsername(),
					user.getPassword(),
					ByteSource.Util.bytes(user.getSalt()),
					getName()
				);
		return authenticationInfo;
	}

}
