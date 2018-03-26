package tech.hongjian.chapter4;

import static org.junit.Assert.assertTrue;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author xiahongjian 
 * @time   2018-03-26 15:36:32
 *
 */
public class ConfigurationCreateTest {

	@Test
	public void testConfigurationCreate() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-config.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		subject.login(token);
		
		assertTrue(subject.isAuthenticated());
	}
}
