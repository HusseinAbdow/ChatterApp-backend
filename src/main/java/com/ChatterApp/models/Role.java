package com.ChatterApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer roleId;
	
	private String authority;

	public Role() {
		super();
	}
	

	public Role(String authority) {
		super();
		
	}


	public Role(Integer roleId, String authority) {
		super();
		this.roleId = roleId;
		this.authority = authority;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", authority=" + authority + "]";
	}
	
	

}
