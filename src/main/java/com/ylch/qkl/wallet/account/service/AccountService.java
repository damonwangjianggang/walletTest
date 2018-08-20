package com.ylch.qkl.wallet.account.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;
import org.web3j.protocol.parity.methods.response.PersonalAccountsInfo.AccountsInfo;

import com.ylch.qkl.wallet.account.bean.AccountInfo;


@Service
public interface AccountService {

	/**
	 * 查询所有账户
	 * @return
	 */
	public List<String> getAllAccounts(String ip);
	/**
	 * 查询账户余额 
	 */ 
  	public BigInteger getBalance(String accountId,String ip);
 
	/**
	 * 创建账户
	 */
	public String  createAccount(String accountName,String password,AccountInfo accountInfo,String ip);
	/**
	 * 得到账户信息
	 */
	public AccountsInfo getAccountInfo(String accountId);  
}
