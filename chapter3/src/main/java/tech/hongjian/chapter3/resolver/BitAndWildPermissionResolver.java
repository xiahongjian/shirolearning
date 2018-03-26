package tech.hongjian.chapter3.resolver;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @author xiahongjian 
 * @time   2018-03-26 13:54:13
 *
 */
public class BitAndWildPermissionResolver implements PermissionResolver {

	@Override
	public Permission resolvePermission(String permissionString) {
		if (permissionString.startsWith("+")) {
			return new BitPermission(permissionString);
		}
		return new WildcardPermission(permissionString);
	}

}
