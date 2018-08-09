package com.ylch.qkl.wallet.util.test;

import java.math.BigInteger;
import java.util.List;

import org.web3j.protocol.parity.methods.response.PersonalAccountsInfo.AccountsInfo;

import com.ylch.qkl.wallet.account.bean.AccountInfo;
import com.ylch.qkl.wallet.account.dao.AccountDao;

public class AccountTest {
	
    public static void main(String args[]) {
    	//getBalance();
    	//queryAccount();
    	//createAccount();
    	getAccountInfo();
    }
 
    public static void getBalance(){
        AccountDao account = new AccountDao();
        String firstAccount = queryAccount().get(0);
        BigInteger ba = account.getBalance(firstAccount);
        System.out.print(ba);
    }
 
    public static List<String> queryAccount(){
        AccountDao account = new AccountDao();
        List<String> accounts = account.getAccountlist();
        return accounts;
 
    }
 
    public static void createAccount(){
            AccountDao account = new AccountDao();
            AccountInfo accountInfo = new AccountInfo("lzh","229787499","世宁大厦","buaa");
            String accountId = account.createAccount("lzh","123456",accountInfo);
            System.out.println("注册账户成功:"+accountId);
//        PersonalAccountsInfo.AccountsInfo accountsInfo = account.getAccountInfo("0xad7bbca86e02e503076b06931e05938e51e49fb9");
//        System.out.println(accountsInfo.toString());
    }
    
    public static void getAccountInfo() {
        AccountDao account = new AccountDao();
        AccountsInfo accountInfo = account.getAccountInfo("0xc4e2c50c578b1f577ca35017ac9a8376337c5b77");
        System.out.println(accountInfo);
    }

}
