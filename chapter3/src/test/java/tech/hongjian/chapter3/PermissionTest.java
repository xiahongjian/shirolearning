package tech.hongjian.chapter3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author xiahongjian 
 * @time   2018-03-26 11:09:09
 *
 */
public class PermissionTest extends BaseTest {
	
	@Test
	public void testIsPermitted() {
		login("classpath:shiro-permission.ini", "zhang", "123");
		Subject subject = subject();
		assertTrue(subject.isPermitted("user:create"));
		assertTrue(subject.isPermittedAll("user:update", "user:delete"));
		assertFalse(subject.isPermitted("user:view"));
	}
	
	@Test(expected = UnauthorizedException.class)
	public void testCheckPermission() {
		login("classpath:shiro-permission.ini", "zhang", "123");
		Subject subject = subject();
		subject.checkPermission("user:create");
		subject.checkPermissions("user:delete", "user:update");
		subject.checkPermission("user:view");
	}
}
