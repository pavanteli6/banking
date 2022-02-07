package com.banking.auth.customRequest;

public class CustomerRequestForResetPassword {

	public String email;
	public String password;
	public String newPassword;
	public CustomerRequestForResetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerRequestForResetPassword(String email, String password, String newPassword) {
		super();
		this.email = email;
		this.password = password;
		this.newPassword = newPassword;
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
