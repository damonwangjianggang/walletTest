package com.ylch.qkl.wallet.trade.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.ylch.qkl.wallet.trade.dao.TradeDao;
import com.ylch.qkl.wallet.trade.service.TradeService;

public class TradeServiceImpl implements TradeService{

	@Autowired
	 private TradeDao trade;

	@Override
	public String sendTrasfer(String accountId, String passsword, String toAccountId, String amountm ,String data) {
		return trade.trasfer(accountId, passsword, toAccountId, amountm, data);
	}

	@Override
	public String getTranferInfo(String tranferHash) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
