package tech.hongjian.chapter6.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import tech.hongjian.chapter6.BaseTest;

/**
 * @author xiahongjian 
 * @time   2018-03-27 16:49:58
 *
 */
public class ServiceTest extends BaseTest {
	
	@Test
	public void testUserRolePermissionRelation() {
		Set<String> roles = userService.findRoles(u1.getUsername());
		assertEquals(1, roles.size());
		assertTrue(roles.contains(r1.getRole()));
		
		Set<String> permissions = userService.findPermissions(u1.getUsername());
		assertEquals(3, permissions.size());
		assertTrue(permissions.contains(p3.getPermission()));
		
		roles = userService.findRoles(u2.getUsername());
		assertEquals(0, roles.size());
		permissions = userService.findPermissions(u2.getUsername());
		assertEquals(0, permissions.size());
		
		roleService.uncorrelationPermissions(r1.getId(), p3.getId());
		permissions = userService.findPermissions(u1.getUsername());
		assertEquals(2, permissions.size());
		assertFalse(permissions.contains(p3.getPermission()));
		
		permissionService.delete(p2.getId());
		permissions = userService.findPermissions(u1.getUsername());
		assertEquals(1, permissions.size());
		
		userService.uncorrelationRoles(u1.getId(), r1.getId());
		roles = userService.findRoles(u1.getUsername());
		assertEquals(0, roles.size());
	}
}
