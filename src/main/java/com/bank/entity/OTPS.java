package com.bank.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OTPS{

	@Id
	private String otp_id;
	
	@Column(nullable=false )
	private String purpose;
	
	@Column(nullable=false )
	private String code_hash;
	
	@Column(nullable=false )
	private LocalDateTime expires_at;
	
	@Column(nullable=false, columnDefinition="TINYINT(1)" )
	private Boolean used;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public OTPS() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OTPS(String otp_id, String purpose, String code_hash, LocalDateTime expires_at, Boolean used, User user) {
		super();
		this.otp_id = otp_id;
		this.purpose = purpose;
		this.code_hash = code_hash;
		this.expires_at = expires_at;
		this.used = used;
		this.user = user;
	}


	public String getOtp_id() {
		return otp_id;
	}


	public void setOtp_id(String otp_id) {
		this.otp_id = otp_id;
	}


	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	public String getCode_hash() {
		return code_hash;
	}


	public void setCode_hash(String code_hash) {
		this.code_hash = code_hash;
	}


	public LocalDateTime getExpires_at() {
		return expires_at;
	}


	public void setExpires_at(LocalDateTime expires_at) {
		this.expires_at = expires_at;
	}


	public Boolean getUsed() {
		return used;
	}


	public void setUsed(Boolean used) {
		this.used = used;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "OTPS [otp_id=" + otp_id + ", purpose=" + purpose + ", code_hash=" + code_hash + ", expires_at="
				+ expires_at + ", used=" + used + "]";
	}


	
	
}
