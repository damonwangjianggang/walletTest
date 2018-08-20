package com.ylch.qkl.wallet.account.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.parity.methods.response.PersonalAccountsInfo.AccountsInfo;

import com.ylch.qkl.wallet.account.bean.AccountInfo;
import com.ylch.qkl.wallet.account.dao.AccountDao;
import com.ylch.qkl.wallet.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao account;

	@Override
	public List<String> getAllAccounts(String ip) {
		
		return account.getAccountlist(ip);
	}

	@Override
	public BigInteger getBalance(String accountId,String ip) {
		
		return account.getBalance(accountId.trim(),ip);
	}

	@Override
	public String createAccount(String accountName,String password,AccountInfo accountInfo,String ip) {
		
		return account.createAccount(accountName, password, accountInfo,ip);
	}

	@Override
	public AccountsInfo getAccountInfo(String accountId) {
		return account.getAccountInfo(accountId);
	}

}
