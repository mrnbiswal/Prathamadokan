package com.mu_dukani.prathamadokan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "email_id")
	private String emailId;

	public User() {

	}

	public User(long id, String name, String mobileNumber, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
