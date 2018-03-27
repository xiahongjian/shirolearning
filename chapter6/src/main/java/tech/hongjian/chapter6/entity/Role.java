package tech.hongjian.chapter6.entity;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:26:59
 *
 */
public class Role {
	private Long id;
	private String role;
	private String description;
	private Boolean available = Boolean.FALSE;
	
	public Role() {
	}

	public Role(String role, String description, Boolean availavle) {
		this.role = role;
		this.description = description;
		this.available = availavle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
