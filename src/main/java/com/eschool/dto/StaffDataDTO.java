package com.eschool.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StaffDataDTO {

	@JsonIgnore
	private Integer userId;
	
	@NotEmpty(message = "Please Enter First name")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
	private String firstName;
	
	@NotEmpty(message = "Please Enter Last name")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
	private String lastName;
	
	@NotEmpty(message = "Please Enter Email")
    @Email(message = "Please Enter a Valid Email")
	private String userEmail;
	
	@NotEmpty(message = "Please Enter Contact number")
	private String contactNo;
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@NotEmpty(message = "Please Enter Password")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
	private String password;
	
	@NotEmpty(message = "Please Enter user type")
	private String userType;
	
	private Integer schoolid;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(Integer schoolid) {
		this.schoolid = schoolid;
	}
	
}
