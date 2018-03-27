package tech.hongjian.chapter6.entity;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:28:35
 *
 */
public class RolePermission {
	private Long roleId;
	private Long permissionId;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
}
