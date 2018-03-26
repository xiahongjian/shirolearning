package tech.hongjian.chapter3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author xiahongjian 
 * @time   2018-03-26 10:51:39
 *
 */
public class RoleTest extends BaseTest {
	
	@Test
	public void testHasRole() {
		login("classpath:shiro.ini", "zhang", "123");
		Subject subject = subject();
		assertTrue(subject.hasRole("role1"));
		assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
		
		boolean[] results = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
		assertTrue(results[0]);
		assertTrue(results[1]);
		assertFalse(results[2]);
	}
	
	@Test(expected = UnauthorizedException.class)
	public void testCheckRole() {
		login("classpath:shiro.ini", "zhang", "123");
		subject().checkRole("role1");
		subject().checkRoles("role1", "role2", "role3");
	}
	
}
