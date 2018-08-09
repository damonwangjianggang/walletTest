package com.ylch.qkl.wallet.account.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.parity.methods.response.PersonalAccountsInfo.AccountsInfo;

import com.ylch.qkl.wallet.account.bean.AccountInfo;
import com.ylch.qkl.wallet.account.service.AccountService;
import com.ylch.qkl.wallet.util.bean.RequestBodyBean;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/getAllAccounts")
	public List<String> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	@PostMapping("/getBalance")
	public BigInteger getBalance(@RequestBody RequestBodyBean request) {
		return accountService.getBalance(request.getAccountId());
	}
	
	@PostMapping("/createAccount")
	public  String createAccount(@RequestBody RequestBodyBean request) {
		
		AccountInfo accountInfo = new AccountInfo(request.getUserName(),request.getAddress(),request.getPhone(),request.getSchool());
		return accountService.createAccount(request.getAccountName(), request.getPassword(), accountInfo);
	}
	
	@PostMapping("/getAccountsInfo")
	public AccountsInfo getAccountInfo(@RequestBody RequestBodyBean request) {
		return accountService.getAccountInfo(request.getAccountId());
		
	} 

}
