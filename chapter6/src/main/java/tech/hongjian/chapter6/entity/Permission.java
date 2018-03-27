package tech.hongjian.chapter6.entity;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:24:10
 *
 */
public class Permission {
	private Long id;
	private String permission;
	private String description;
	private Boolean available = Boolean.FALSE;
	
	public Permission() {}
	
	public Permission(String permission, String description, Boolean availavle) {
		this.permission = permission;
		this.description = description;
		this.available = availavle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
}
