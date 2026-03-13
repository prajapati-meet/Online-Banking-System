package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Audit_logs;

public interface AuditLogsRepository extends JpaRepository<Audit_logs, String>{

}
