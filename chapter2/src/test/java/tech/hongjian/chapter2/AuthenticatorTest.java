package tech.hongjian.chapter2;

import static org.junit.Assert.assertEquals;

import java.security.Principal;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Test;

/**
 * @author xiahongjian 
 * @time   2018-03-23 16:37:00
 *
 */
public class AuthenticatorTest {
	@Test
	public void testAllSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-all-success.ini", "zhang", "123");
		Subject subject = SecurityUtils.getSubject();
		
		PrincipalCollection principalCollection = subject.getPrincipals();
		assertEquals(2, principalCollection.asList().size());
	}
	
	@Test(expected = UnknownAccountException.class)
	public void testAllSuccessfulStrategyWithFail() {
		login("classpath:shiro-authenticator-all-fail.ini", "zhang", "123");
	}
	
	@Test
	public void testFirstSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-first-success.ini", "zhang", "123");
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection principalCollection = subject.getPrincipals();
		
		assertEquals(1, principalCollection.asList().size());
		assertEquals(true, principalCollection.getRealmNames().contains("myRealm1"));
	}
	
	@Test
	public void testAtLeastOneSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-atLeastOne-success.ini", "zhang", "123");
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection principalCollection = subject.getPrincipals();
		
		assertEquals(2, principalCollection.asList().size());
	}
	
	@Test
	public void testOnlyOneAuthenticatorStrategy() {
		login("classpath:shiro-authenticator-onlyone-success.ini", "zhang", "123");
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection principalCollection = subject.getPrincipals();
		assertEquals(1, principalCollection.asList().size());
	}
	
	@After
	public void tearDown() {
		ThreadContext.unbindSubject();
	}
	
	private void initConfig(String config) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(config);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
	}
	
	private void login(String config, String username, String password) {
		initConfig(config);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		subject.login(token);
	}
}
