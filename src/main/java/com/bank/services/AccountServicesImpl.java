package com.bank.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.dto.CreateAccountRequest;
import com.bank.entity.Account;
import com.bank.entity.User;
import com.bank.repository.AccountRepository;
import com.bank.repository.UserRepository;

@Service
public class AccountServicesImpl implements AccountServices
{
	
	UserRepository userRepo;
	AccountRepository accRepo;

	public AccountServicesImpl(UserRepository userRepo, AccountRepository accRepo) {
		super();
		this.userRepo = userRepo;
		this.accRepo = accRepo;
	}
	
	@Override
	public Account createAccount(CreateAccountRequest request) {
		
		User user=userRepo.findById(request.getUser_id()).orElseThrow(() -> new RuntimeException("User Not Found. Please register first."));
		
		Account acc=new Account();
		long count= accRepo.count()+1;
		String id=String.format("ACC_%02d", count);
		
		acc.setAccount_id(id);
		acc.setAccount_number(setAccountNumber(id));
		acc.setBalance(BigDecimal.ZERO);
		acc.setCurrency("INR");
		acc.setVersion("1");
		acc.setUser(user);
		
		return accRepo.save(acc);
	}

	private String setAccountNumber(String id) {
		return id+System.currentTimeMillis();
	}

	@Override
	public Account getAccount(String id) {
		return accRepo.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found"));
	}



	

}
