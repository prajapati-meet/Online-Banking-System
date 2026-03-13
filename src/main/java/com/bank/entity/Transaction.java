package com.bank.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction 
{
	@Id
	private String transaction_id;
	
	@Column(nullable=false )
	private String type;
	
	@Column(nullable=false )
	private BigDecimal amount;
	
	@Column(nullable=false )
	private double reference_amount;
	
	@Column(nullable=false )
	private String status;
	
	@Column(nullable=false )
	private LocalDateTime created_at;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transaction_id, String type, BigDecimal amount, double reference_amount, String status,
			LocalDateTime created_at, Account account) {
		super();
		this.transaction_id = transaction_id;
		this.type = type;
		this.amount = amount;
		this.reference_amount = reference_amount;
		this.status = status;
		this.created_at = created_at;
		this.account = account;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public double getReference_amount() {
		return reference_amount;
	}

	public void setReference_amount(double reference_amount) {
		this.reference_amount = reference_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", type=" + type + ", amount=" + amount
				+ ", reference_amount=" + reference_amount + ", status=" + status + ", created_at=" + created_at + "]";
	}

	
	
	
}
