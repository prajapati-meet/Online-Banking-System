package com.bank.controller;


import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.CreateAccountRequest;
import com.bank.entity.Account;
import com.bank.services.AccountServices;

@RestController
@RequestMapping("/accounts")
public class AccountController 
{
	private AccountServices accServ;

	public AccountController(AccountServices accServ) {
		super();
		this.accServ = accServ;
	}
	
	@PostMapping
	public Account createAccount(@RequestBody CreateAccountRequest request) 
	{
		return accServ.createAccount(request);
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable String id)
	{
		return accServ.getAccount(id);
	}
	

}
