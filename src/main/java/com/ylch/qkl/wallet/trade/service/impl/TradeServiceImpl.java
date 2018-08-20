package com.ylch.qkl.wallet.trade.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ylch.qkl.wallet.trade.bean.TransferInfoBean;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylch.qkl.wallet.trade.dao.TradeDao;
import com.ylch.qkl.wallet.trade.service.TradeService;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService{

	@Autowired
	 private TradeDao tradeDao;

	@Override
	public String sendTrasfer(String accountId, String passsword, String toAccountId, String amountm ,String data,String ip) {

		return tradeDao.trasfer(accountId, passsword, toAccountId, amountm, transferStringToHah(data),ip);
	}

	@Override
	public TransferInfoBean getTranferInfo(String tranferHash,String ip) {
		try {
			TransferInfoBean transferInfoBean = tradeDao.getTrasfer(tranferHash,ip);
			JSONObject jsonObject = transferHahToString(transferInfoBean.getData());
			transferInfoBean.setData(jsonObject.get("data").toString());
			transferInfoBean.setTime(jsonObject.get("time").toString());
			return  transferInfoBean;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String  transferStringToHah(String data){
		Map map = new HashMap();

		map.put("time", (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
		map.put("data",data);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String jsonObjectString =jsonObject.toString();
		byte[] bytes = jsonObjectString.getBytes();
		StringBuilder  stringBuilder  = new StringBuilder ("");
		for (int i =0;i<bytes.length;i++){
			int v= bytes[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public JSONObject transferHahToString(String data){
		data = data.toUpperCase();
		int length = data.length() / 2;
		char[] hexChars = data.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}

		data = new String(d);
		data = data.substring(1,data.length());
		JSONObject jsonObject =JSONObject.fromObject(data);
		return jsonObject;
	}

	public  byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	

}
