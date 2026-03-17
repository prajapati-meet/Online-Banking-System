package com.bank.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bank.dto.TransferRequest;
import com.bank.repository.AccountRepository;

import jakarta.transaction.Transactional;

import com.bank.entity.Account;
import com.bank.entity.Transactions;

@Service
public class TransferServicesImpl implements TransferServices
{
	
	private AccountRepository accRepo;
	private TransactionServices tserv;

	public TransferServicesImpl(AccountRepository accRepo, TransactionServices tserv) {
		super();
		this.accRepo = accRepo;
		this.tserv = tserv;
	}

	@Transactional
	public String transfer(TransferRequest request) 
	{
		Account sender=accRepo.findById(request.getFromAccount()).orElseThrow(()->new RuntimeException("Sender Account Not Found"));
		Account receiver=accRepo.findById(request.getToAccount()).orElseThrow(()->new RuntimeException("Receiver Account Not Found"));
		BigDecimal amount=request.getAmount();
		
		if(sender.getBalance().compareTo(amount)<0)
		{
			return "Transaction Failed. Insufficient Balance";
		}
		
		sender.setBalance(sender.getBalance().subtract(amount));
		receiver.setBalance(receiver.getBalance().add(amount));
		
		accRepo.save(sender);
		accRepo.save(receiver);
		
		Transactions t= new Transactions(
				"TNX"+sender.getAccount_id()+ receiver.getAccount_id()+System.currentTimeMillis(),
				"TRANSFER",
				amount,
				sender.getBalance(),
				"SUCCESS",
				LocalDateTime.now(),
				sender,
				receiver
				);
		
		tserv.saveTransaction(t);
		return "Transaction Successful";
	}

}