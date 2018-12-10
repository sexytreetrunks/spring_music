package com.stt.domain;

public class SignupDTO {
	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirmPassword;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirmPassword = confirm_password;
	}
	@Override
	public String toString() {
		return "SignupDTO [email=" + email + ", name=" + name + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
}
