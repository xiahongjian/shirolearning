package tech.hongjian.chapter6.entity;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:31:12
 *
 */
public class UserRole {
	private Long userId;
	private Long roleId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
