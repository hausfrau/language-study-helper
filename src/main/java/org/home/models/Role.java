package org.home.models;

public class Role extends Base {
	
	private String role;

	private Long id; 
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + ", id=" + id + "]";
	}


	

}
