package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.OTPS;

public interface OTPSRepository extends JpaRepository<OTPS, String> {

}
