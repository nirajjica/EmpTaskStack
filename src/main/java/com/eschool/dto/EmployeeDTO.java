package com.eschool.dto;

public class EmployeeDTO {

	private Integer id;
	private String code;
	private String fname;
	private String lname;
	private String email;
	private String address;
	private String salary;
	private String password;
	private String username;
	private String phone;
	private String accounttype;
	private String createdate;
	private String accountstatus;
	private String departmentId;
	private String roleName;
	private String manager;

	
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDTO(Integer id, String code, String fname, String lname, String email, String address, String salary,
			String password, String username, String phone, String accounttype, String createdate, String accountstatus,
			String departmentId, String roleName) {
		super();
		this.id = id;
		this.code = code;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.salary = salary;
		this.password = password;
		this.username = username;
		this.phone = phone;
		this.accounttype = accounttype;
		this.createdate = createdate;
		this.accountstatus = accountstatus;
		this.departmentId = departmentId;
		this.roleName = roleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getAccountstatus() {
		return accountstatus;
	}
	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
}
