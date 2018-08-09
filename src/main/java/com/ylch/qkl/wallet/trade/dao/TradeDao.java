package com.ylch.qkl.wallet.trade.dao;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.parity.Parity;

import com.ylch.qkl.wallet.util.client.ParityClient;


@Component
public class TradeDao {
    private static final Logger logger = LoggerFactory.getLogger(TradeDao.class);
    
    private static BigInteger nonce = new BigInteger("0");
 
    private static BigInteger gasPrice = new BigInteger("1");
 
    private static BigInteger gasLimit = new BigInteger("50");
 
    private Parity parity = ParityClient.getParity();
 
    public String  trasfer(String accountId,String passsword,String toAccountId, String amount,String data)  {
    	 String tradeHash =null;
        Transaction transaction = Transaction.createFunctionCallTransaction(accountId,null,null,null,toAccountId,new BigInteger(amount),data);
        try{
            EthSendTransaction ethSendTransaction =parity.personalSignAndSendTransaction(transaction,passsword).send();
            if(ethSendTransaction!=null){
                 tradeHash = ethSendTransaction.getTransactionHash();
                logger.info("账户:[{}]转账到账户:[{}],交易hash:[{}]",accountId,toAccountId,tradeHash);
            }
        }catch (Exception e){
            logger.error("账户:[{}]交易失败!",accountId,e);
            return "账户:[{"+accountId+"}]交易失败!";
        }
        return tradeHash;

    }
    
    public boolean getTrasfer(String transactionHash) {
    	
    	Request<Object,EthTransaction> ed =(Request<Object, EthTransaction>) parity.ethGetTransactionByHash(transactionHash);
    	return true;
    }

}
