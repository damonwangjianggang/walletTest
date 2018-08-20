package com.ylch.qkl.wallet.trade.dao;


import java.io.IOException;
import java.math.BigInteger;


import com.ylch.qkl.wallet.trade.bean.TransferInfoBean;
import com.ylch.qkl.wallet.util.client.Web3JClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
 
    private Parity parity ;
    @Autowired
    private ParityClient parityClient;
    @Autowired
    private Web3JClient web3JClient;
 
    public String  trasfer(String accountId,String passsword,String toAccountId, String amount,String data,String ip)  {
    	 String tradeHash =null;

        Transaction transaction = Transaction.createFunctionCallTransaction(accountId,null,null,null,toAccountId,new BigInteger(amount),data);
        try{
            parity=parityClient.getParity(ip);
            EthSendTransaction ethSendTransaction =parity.personalSignAndSendTransaction(transaction,passsword).send();
            if(ethSendTransaction!=null){
                 tradeHash = ethSendTransaction.getTransactionHash();
                logger.info("账户:[{}]转账到账户:[{}],交易hash:[{}]",accountId,toAccountId,tradeHash);
            }
            return tradeHash;
        }catch (Exception e){
            logger.error("账户:[{}]交易失败!",accountId,e);
            return "账户:[{"+accountId+"}]交易失败!";
        }
    }


    public TransferInfoBean  getTrasfer(String transactionHash,String ip) throws IOException {

        parity=parityClient.getParity(ip);
        EthTransaction ethTransaction = parity.ethGetTransactionByHash(transactionHash).send();
        TransferInfoBean transferInfoBean = new TransferInfoBean();
        transferInfoBean.setFromAccount(ethTransaction.getResult().getFrom());
        transferInfoBean.setToAccount(ethTransaction.getResult().getTo());
        transferInfoBean.setValue(ethTransaction.getResult().getValue());
        transferInfoBean.setData(ethTransaction.getResult().getInput());
        return transferInfoBean;


    }




}
