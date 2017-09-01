package com.eschool.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Author  Niraj Kumar
 * @CreatedOn 04-Jun-2017
 */
public class SchoolDataDTO {

	private Integer user_id;
	@NotNull(message="Please enter name.")
	private String name;
	@NotNull(message="Please enter code.")
	private Integer code;
	private String telephone;
	private String email;
	private String password;
	
	@JsonIgnore
	private Date created_date;
	
	@JsonIgnore
	private Boolean is_active = true;
	
	private String license_start;
	private String license_end;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	public String getLicense_start() {
		return license_start;
	}
	public void setLicense_start(String license_start) {
		this.license_start = license_start;
	}
	public String getLicense_end() {
		return license_end;
	}
	public void setLicense_end(String license_end) {
		this.license_end = license_end;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
}
