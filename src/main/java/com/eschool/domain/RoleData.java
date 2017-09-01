package com.eschool.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class RoleData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(nullable = false, name="name")
    private String name;

    @Column(name = "menus")
    private String menus;

    public RoleData() {
    	
    }
	public RoleData(String role) {
		this.name = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "RoleData [name=" + name + ", menus=" + menus + "]";
	}


}
