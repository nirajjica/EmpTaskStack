package com.eschool.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.util.Date;

public class AccountDataDTO {
    private Long id;
    @JsonIgnore
    private Integer parentId;
    @NotEmpty(message = "Please Enter First name")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
    /*@Pattern(regexp="^[A-z ]+$", message="{usersDTO.validation.error.firstname.validate}")*/
    private String fname;
    @NotEmpty(message = "Please Enter Last name")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
    private String lname;
    @NotEmpty(message = "Please Enter User name")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
    private String username;
    @NotEmpty(message = "Please Enter Password")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
    private String password;
    @NotEmpty(message = "Please Enter Country")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
    private String country;
    @NotEmpty(message = "Please Enter State")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
    private String state;
    @NotEmpty(message = "Please Enter City")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
    private String city;
    @NotEmpty(message = "Please Enter pin")
    @Size(min = 2, max = 30, message = "The size should be between {min} and {max} characters")
    private String pin;
    @NotEmpty(message = "Please Enter Home Phone")
    private String hphone;
    @NotEmpty(message = "Please Enter Work phone")
    private String wphone;
    private String accounttype;
    @NotEmpty(message = "Please Enter Email")
    @Email(message = "Please Enter a Valid Email")
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    private String systemgenerated;
    private String accountstatus;
    private String welcomeEmailSent;
    private String verificationCode;
    private char visible;

    public AccountDataDTO() {

    }

    public AccountDataDTO(String fname, String lname, String username, String password, String email) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getWphone() {
        return wphone;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(String accountstatus) {
        this.accountstatus = accountstatus;
    }

    public String getWelcomeEmailSent() {
        return welcomeEmailSent;
    }

    public void setWelcomeEmailSent(String welcomeEmailSent) {
        this.welcomeEmailSent = welcomeEmailSent;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public char getVisible() {
        return visible;
    }

    public void setVisible(char visible) {
        this.visible = visible;
    }

    public String getSystemgenerated() {
        return systemgenerated;
    }

    public void setSystemgenerated(String systemgenerated) {
        this.systemgenerated = systemgenerated;
    }

    public Integer getParentId() {
        return parentId;
    }


    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


}
