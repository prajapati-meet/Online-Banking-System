package com.bank.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Audit_logs 
{
	@Id
	private String audit_id;
	
	@Column(nullable=false )
	private String action;
	
	@Column(nullable=false )
	private String entity;
	
	@Column(nullable=false )
	private String entity_id;
	
	@Column(nullable=false )
	private String meta;
	
	@Column(nullable=false )
	private LocalDateTime created_at;
		
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Audit_logs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Audit_logs(String audit_id, String action, String entity, String entity_id, String meta, LocalDateTime created_at,
			User user) {
		super();
		this.audit_id = audit_id;
		this.action = action;
		this.entity = entity;
		this.entity_id = entity_id;
		this.meta = meta;
		this.created_at = created_at;
		this.user = user;
	}

	public String getAudit_id() {
		return audit_id;
	}

	public void setAudit_id(String audit_id) {
		this.audit_id = audit_id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(String entity_id) {
		this.entity_id = entity_id;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Audit_logs [audit_id=" + audit_id + ", action=" + action + ", entity=" + entity + ", entity_id="
				+ entity_id + ", meta=" + meta + ", created_at=" + created_at + "]";
	}


	
}
