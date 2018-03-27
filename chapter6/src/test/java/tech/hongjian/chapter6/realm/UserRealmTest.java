package tech.hongjian.chapter6.realm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.junit.Test;

import com.alibaba.druid.filter.config.ConfigFilter;

import tech.hongjian.chapter6.BaseTest;

/**
 * @author xiahongjian 
 * @time   2018-03-27 15:32:30
 *
 */
public class UserRealmTest extends BaseTest {
	private String configPath = "classpath:shiro.ini";
	@Test
	public void testLoginSuccess() {
		login(configPath, u1.getUsername(), password);
		assertTrue(subject().isAuthenticated());
	}
	
	@Test(expected = UnknownAccountException.class)
	public void  testLoginFailWithUnknownUsername() {
		login(configPath, u1.getUsername() + "1", password);
	}
	
	@Test(expected = IncorrectCredentialsException.class)
	public void testLoginFailWithErrorPassword() {
		login(configPath, u1.getUsername(), "111");
	}
	
	@Test(expected = LockedAccountException.class)
	public void testLoginFailWithLocked() {
		login(configPath, u4.getUsername(), password);
	}
	
	@Test(expected = ExcessiveAttemptsException.class)
	public void testLoginFailWithLimitRetryCount() {
		for (int i = 1; i <= 5; i++) {
			try {
				login(configPath, u3.getUsername(), password + "1");
			} catch (Exception e) {
			}
		}
		login(configPath, u3.getUsername(), password + "1");
	}
	
	@Test
	public void testHasRole() {
		login(configPath, u1.getUsername(), password);
		assert(subject().hasRole("admin"));
	}
	
	@Test
	public void testNoRole() {
		login(configPath, u2.getUsername(), password);
		assertFalse(subject().hasRole("admin"));
	}
	
	@Test
	public void testHasPermission() {
		login(configPath, u1.getUsername(), password);
		assertTrue(subject().isPermittedAll("user:create", "menu:create"));
	}
	
	@Test
	public void testNoPermisssion() {
		login(configPath, u2.getUsername(), password);
		assertFalse(subject().isPermitted("user:create"));
	}
}
