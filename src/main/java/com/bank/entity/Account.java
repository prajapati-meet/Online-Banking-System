package com.bank.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account 
{
	@Id
	private String account_id;
	
	@Column(nullable=false , unique=true)
	private String account_number;
	
	@Column(nullable=false )
	private BigDecimal balance;
	
	@Column(nullable=false )
	private String currency;
	
	@Column(nullable=false )
	private String version;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String account_id, String account_number, BigDecimal balance, String currency, String version,
			User user) {
		super();
		this.account_id = account_id;
		this.account_number = account_number;
		this.balance = balance;
		this.currency = currency;
		this.version = version;
		this.user = user;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_number=" + account_number + ", balance=" + balance
				+ ", currency=" + currency + ", version=" + version + "]";
	}

	
	
	
}
