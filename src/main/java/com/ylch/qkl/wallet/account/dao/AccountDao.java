package com.ylch.qkl.wallet.account.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.parity.Parity;
import org.web3j.protocol.parity.methods.response.NewAccountIdentifier;
import org.web3j.protocol.parity.methods.response.PersonalAccountsInfo;
import org.web3j.protocol.parity.methods.response.PersonalAccountsInfo.AccountsInfo;

import com.ylch.qkl.wallet.account.bean.AccountInfo;
import com.ylch.qkl.wallet.util.client.ParityClient;
import com.ylch.qkl.wallet.util.client.Web3JClient;

@Component
public class AccountDao {
	
    private static  Parity parity = ParityClient.getParity();
    
    private static Web3j web3j = Web3JClient.getClient();
 
    /**
     * Life
     * Like this
     * Like that
     * Also
     * It's not the same with you think
     * @Author lzh
     *
     */
    public List<String> getAccountlist(){
 
        try{
            return  parity.personalListAccounts().send().getAccountIds();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
 
    public String createAccount(String accountName,String password,AccountInfo accountInfo){
        try {
            NewAccountIdentifier newAccountIdentifier = parity.personalNewAccount(password).send();
            if(newAccountIdentifier!=null){
                String accountId = newAccountIdentifier.getAccountId();
                parity.personalSetAccountName(accountId,accountName);
 
                Map<String,Object> account = new HashMap<String,Object>();
                account.put(accountId,accountInfo);
                parity.personalSetAccountMeta(accountId,account);
 
                return  accountId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public AccountsInfo getAccountInfo(String accountId){
 
        try{
        	
        System.out.println(parity.personalAccountsInfo());
            PersonalAccountsInfo personalAccountsInfo = parity.personalAccountsInfo().send();
        Map<String,AccountsInfo> map =personalAccountsInfo.getAccountsInfo(); 
        System.out.println(map);
            return  personalAccountsInfo.getAccountsInfo().get(accountId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
 
    public BigInteger getBalance(String accountId){
        try {
            DefaultBlockParameter defaultBlockParameter = new DefaultBlockParameterNumber(web3j.ethBlockNumber().send().getBlockNumber());
            
            EthGetBalance ethGetBalance =  parity.ethGetBalance(accountId,defaultBlockParameter).send();
            if(ethGetBalance!=null){
                return ethGetBalance.getBalance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
