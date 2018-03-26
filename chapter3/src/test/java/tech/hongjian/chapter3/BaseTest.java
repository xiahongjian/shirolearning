package tech.hongjian.chapter3;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;

/**
 * @author xiahongjian 
 * @time   2018-03-26 11:09:30
 *
 */
public class BaseTest {
	@After
	public void tearDown() {
		ThreadContext.unbindSubject();
	}
	
	private void initConfig(String config) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(config);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
	}
	
	protected void login(String config, String username, String password) {
		initConfig(config);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		subject.login(token);
	}
	
	protected Subject subject() {
		return SecurityUtils.getSubject();
	}
}
