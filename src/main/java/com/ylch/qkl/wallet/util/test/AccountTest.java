
package com.ylch.qkl.wallet.util.test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.protocol.parity.methods.response.PersonalAccountsInfo.AccountsInfo;

import com.ylch.qkl.wallet.account.bean.AccountInfo;
import com.ylch.qkl.wallet.account.dao.AccountDao;
import sun.security.ec.ECKeyPairGenerator;

public class AccountTest {
	
    public static void main(String args[]){
        Web3j web3j = Web3j.build(new HttpService("http://192.168.20.45:8545"));
        Parity parity = Parity.build(new HttpService("http://192.168.20.45:8545"));
        try {
            System.out.print(parity.personalAccountsInfo().send().getResult().toString());
            parity.personalNewAccount("123").send().getAccountId();
            BigInteger a =new BigInteger("123456787454554");
            BigInteger b =new BigInteger("123");
            ECKeyPair ecKeyPair = new ECKeyPair(a,b);
            WalletFile walletFile = Wallet.create("123",ecKeyPair,2,1);
            walletFile.getAddress();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
        //getBalance();
    	//System.out.println(queryAccount());
    	//createAccount();
    	//getAccountInfo();
    }
 
    public static void getBalance(){
       /* AccountDao account = new AccountDao();
        String firstAccount = queryAccount().get(0);
        BigInteger ba = account.getBalance(firstAccount);
        System.out.print(ba);*/
    }
 
    /*public static List<String> queryAccount(){
      *//*  AccountDao account = new AccountDao();
        List<String> accounts = account.getAccountlist();
        return accounts;*//*
 
    }*/
 
    public static void createAccount(){
            /*AccountDao account = new AccountDao();
            AccountInfo accountInfo = new AccountInfo("lzh","229787499","世宁大厦","buaa");
            String accountId = account.createAccount("lzh","123456",accountInfo);
            System.out.println("注册账户成功:"+accountId);
//        PersonalAccountsInfo.AccountsInfo accountsInfo = account.getAccountInfo("0xad7bbca86e02e503076b06931e05938e51e49fb9");
//        System.out.println(accountsInfo.toString());*/
    }
    
    public static void getAccountInfo() {
        AccountDao account = new AccountDao();
        AccountsInfo accountInfo = account.getAccountInfo("0xc4e2c50c578b1f577ca35017ac9a8376337c5b77");
        System.out.println(accountInfo);
    }

}

