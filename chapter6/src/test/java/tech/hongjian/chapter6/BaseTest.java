package tech.hongjian.chapter6;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import tech.hongjian.chapter6.entity.Permission;
import tech.hongjian.chapter6.entity.Role;
import tech.hongjian.chapter6.entity.User;
import tech.hongjian.chapter6.service.PermissionService;
import tech.hongjian.chapter6.service.RoleService;
import tech.hongjian.chapter6.service.UserService;
import tech.hongjian.chapter6.service.impl.PermissionServiceImpl;
import tech.hongjian.chapter6.service.impl.RoleServiceImpl;
import tech.hongjian.chapter6.service.impl.UserServiceImpl;
import tech.hongjian.chapter6.util.JdbcTemplateUtils;

/**
 * @author xiahongjian 
 * @time   2018-03-27 15:14:30
 *
 */
public class BaseTest {
	protected PermissionService permissionService = new PermissionServiceImpl();
	protected RoleService roleService = new RoleServiceImpl();
	protected UserService userService = new UserServiceImpl();
	
	protected String password = "123";
	
	protected Permission p1, p2, p3;
	protected Role r1, r2;
	protected User u1, u2, u3, u4;
	
	@Before
	public void setUp() {
		JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();
		jdbcTemplate.update("delete from sys_users");
		jdbcTemplate.update("delete from sys_roles");
		jdbcTemplate.update("delete from sys_permissions");
		jdbcTemplate.update("delete from sys_users_roles");
		jdbcTemplate.update("delete from sys_roles_permissions");
		
		// 1.新增权限
		p1 = new Permission("user:create", "用户模块新增", Boolean.TRUE);
		p2 = new Permission("user:update", "用户模块修改", Boolean.TRUE);
		p3 = new Permission("menu:create", "菜单模块新增", Boolean.TRUE);
		permissionService.create(p1);
		permissionService.create(p2);
		permissionService.create(p3);
		
		// 2.新增角色
		r1 = new Role("admin", "管理员", Boolean.TRUE);
		r2 = new Role("user", "用户管理员", Boolean.TRUE);
		roleService.create(r1);
		roleService.create(r2);
		
		// 3.关联角色-权限
		roleService.correlationPermissions(r1.getId(), p1.getId());
		roleService.correlationPermissions(r1.getId(), p2.getId());
		roleService.correlationPermissions(r1.getId(), p3.getId());
		
		roleService.correlationPermissions(r2.getId(), p1.getId(), p2.getId());
		
		// 4.新增用户
		u1 = new User("zhang", password);
		u2 = new User("li", password);	
		u3 = new User("wu", password);
		u4 = new User("wang", password);
		u4.setLocked(Boolean.TRUE);
		userService.create(u1);
		userService.create(u2);
		userService.create(u3);
		userService.create(u4);
		
		// 5.关联用户-角色
		userService.correlationRoles(u1.getId(), r1.getId());
	}
	
	@After
	public void tearDown() {
		ThreadContext.unbindSecurityManager();
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
