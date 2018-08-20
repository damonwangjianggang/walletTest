package com.ylch.qkl.wallet.trade.service;

import org.springframework.stereotype.Service;
import com.ylch.qkl.wallet.trade.bean.TransferInfoBean;

@Service
public interface TradeService {
	/**
	 * 交易
	 * @param accountId
	 * @param passsword
	 * @param toAccountId
	 * @param amount
	 * @return
	 */
	public String sendTrasfer(String accountId,String passsword,String toAccountId, String amount,String data,String ip);
	
	
	/**
	 *  交易详情
	 * @param tranferHash
	 * @return
	 */
	public TransferInfoBean getTranferInfo(String tranferHash,String ip);

}
