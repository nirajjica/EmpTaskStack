package com.eschool.dto;

public class RoleDataDTO  {

    private String name;

    private String menus;

    public RoleDataDTO() {
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

	public RoleDataDTO(String name, String menus) {
		super();
		this.name = name;
		this.menus = menus;
	}

}
