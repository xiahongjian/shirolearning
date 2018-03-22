package tech.hongjian.chapter2;

import static org.junit.Assert.assertEquals;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class LoginLogoutTest {
	@Test
	public void testHelloWorld() {
		login("classpath:shiro.ini");
	}
			
	@Test
	public void testRealm1() {
		login("classpath:shiro-realm.ini");
	}
	
	private void login(String configFile) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//		UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");
//		UsernamePasswordToken token = new UsernamePasswordToken("li", "123");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
}
