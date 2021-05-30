package com.cos.photogramstart.web.dto.auth;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class SignupDto {
	
	@Size(min =2, max = 20)
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String name;
	
	public User toEntity() {
		return User.builder() 
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
	
	public SignupDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SignupDto(@Size(min = 2, max = 20) String username, @NotBlank String password, @NotBlank String email,
			@NotBlank String name) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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


	@Override
	public String toString() {
		return "SignupDto [username=" + username + ", password=" + password + ", email=" + email + ", name=" + name
				+ "]";
	}
	
	

	
	
}
