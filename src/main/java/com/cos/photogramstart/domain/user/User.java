package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 20, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	private String website;
	private String bio;
	
	@Column(nullable = false)
	private String email;
	private String phone;
	private String gender;
	
	private String profileImageUrl;
	private String role;
	
	private LocalDateTime createDate;
	
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", website="
				+ website + ", bio=" + bio + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ ", profileImageUrl=" + profileImageUrl + ", role=" + role + ", createDate=" + createDate + "]";
	}



	public static UserBuilder builder() {
	    return new UserBuilder();
	  }
	
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getWebsite() {return website;}
	public void setWebsite(String website) {this.website = website;}
	public String getBio() {return bio;}
	public void setBio(String bio) {this.bio = bio;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	public String getProfileImageUrl() {return profileImageUrl;}
	public void setProfileImageUrl(String profileImageUrl) {this.profileImageUrl = profileImageUrl;}
	public String getRole() {return role;}
	public void setRole(String role) {this.role = role;}
	public LocalDateTime getCreateDate() {return createDate;}
	public void setCreateDate(LocalDateTime createDate) {this.createDate = createDate;}
	
	
	
	
	
	public User(String username) {
		super();
		this.username = username;
	}



	public User() {}
	public User(int id, String username, String password, String name, String website, String bio, String email,
			String phone, String gender, String profileImageUrl, String role, LocalDateTime createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.website = website;
		this.bio = bio;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.profileImageUrl = profileImageUrl;
		this.role = role;
		this.createDate = createDate;
	}
	
	

	public User(String username, String password, String email, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}



	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}


 
//Builder Class
public static class UserBuilder {
	private int id;
	
	private String username;
	private String password;
	
	private String name;
	private String website;
	private String bio;
	private String email;
	private String phone;
	private String gender;
	
	private String profileImageUrl;
	private String role;
	
	private LocalDateTime createDate;

	public User build() {
	  User user = new User();
	  user.setId(this.id);
	  user.setName(this.username);
	  user.setPassword(this.password);
	  user.setName(this.name);
	  user.setWebsite(this.website);
	  user.setBio(this.bio);
	  user.setEmail(this.email);
	  user.setPhone(this.phone);
	  user.setGender(this.gender);
	  user.setProfileImageUrl(this.profileImageUrl);
	  user.setRole(this.role);
	  user.setCreateDate(this.createDate);
	  return user;
	}

	public UserBuilder id(int id) {
      this.id = id;
	  return this;
	}

	public UserBuilder username(String username) {
	  this.username = username;
	  return this;
	}
	public UserBuilder password(String password) {
		  this.password = password;
		  return this;
		}

	public UserBuilder name(String name) {
	  this.name = name;
	  return this;
	} 

	public UserBuilder website(String website) {
	  this.website = website;
	  return this;
	}
	public UserBuilder bio(String bio) {
	  this.bio = bio;
	  return this;
	}
	public UserBuilder email(String email) {
	  this.email = email;
	  return this;
	}
	public UserBuilder phone(String phone) {
	  this.phone = phone;
	  return this;
	}
	public UserBuilder profileImageUrl(String profileImageUrl) {
	  this.profileImageUrl = profileImageUrl;
	  return this;
	}
	public UserBuilder role(String role) {
	  this.role = role;
	  return this;
	}
	public UserBuilder createDate(LocalDateTime createDate) {
	  this.createDate = createDate;
	  return this;
	}
}

}


