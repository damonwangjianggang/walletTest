package com.ylch.qkl.wallet.trade.service;

import java.math.BigDecimal;

public interface TradeService {
	/**
	 * 交易
	 * @param accountId
	 * @param passsword
	 * @param toAccountId
	 * @param amount
	 * @return
	 */
	public String sendTrasfer(String accountId,String passsword,String toAccountId, String amount,String data);
	
	
	/**
	 *  交易详情
	 * @param tranferHash
	 * @return
	 */
	public String getTranferInfo(String tranferHash);

}
