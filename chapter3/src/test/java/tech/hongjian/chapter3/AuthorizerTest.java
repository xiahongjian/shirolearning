package tech.hongjian.chapter3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author xiahongjian 
 * @time   2018-03-26 14:16:36
 *
 */
public class AuthorizerTest extends BaseTest {

	@Test
	public void testPermitted() {
		login("classpath:shiro-authorizer.ini", "zhang", "123");
		Subject subject = subject();
		
		assertTrue(subject.isPermitted("user1:update"));
		assertTrue(subject.isPermitted("user2:update"));
		
		assertTrue(subject.isPermitted("+user1+2"));
		assertTrue(subject.isPermitted("+user1+8"));
		assertTrue(subject.isPermitted("+user2+10"));
		
		assertFalse(subject.isPermitted("+user1+4"));
		assertTrue(subject.isPermitted("menu:view"));
	}
}
