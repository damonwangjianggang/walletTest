/*
package com.ylch.qkl.wallet.util.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ylch.qkl.wallet.trade.dao.TradeDao;
import com.ylch.qkl.wallet.util.client.ParityClient;
import net.sf.json.JSONObject;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.parity.Parity;
import rx.Observable;

public class TradeTest {
    public static void main(String args[]) throws IOException {
      */
/*  String data = "王建刚";
        Map map = new HashMap();
        map.put("time",new Date());
        map.put("data",data);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String jsonObjectString =jsonObject.toString();
        byte[] bytes = jsonObjectString.getBytes();
        StringBuilder  stringBuilder  = new StringBuilder ("");
        int v = 0 ;
        for (int i =0;i<bytes.length;i++) {
            v= bytes[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        String newStringDate=stringBuilder.toString();*//*


       */
/* System.out.print(newStringDate);
        TradeDao trade = new TradeDao();
       // trade.trasfer("0xa1b895b4591cd7ba31247a222a89c5ac368e3a5c","123","0x82bfcbce994b4a3091d0a7eadc1109f382360965",new BigDecimal(100));
    String a =trade.trasfer("0x408295f19c8cc90fc7885519d2e5657bf88c229d",
    		"123",
            "0x8c83def30fb18d2e4fd02ffe7704ea42ba53038f",
    		"100",
            newStringDate);
    System.out.println(a);*//*


        */
/*System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" Params: "+request.getParams()
                +" Id: "+request.getId()
                +" Method: "+request.getMethod()
                +" Jsonrpc: "+request.getJsonrpc()
                +" Id: "+request.getId()
                +" observable: "+request.observable());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");*//*

        Parity parity = ParityClient.getParity();
     Transaction transaction   = parity.ethGetTransactionByHash("0xa96d5d9183451ec7d97167c7268cf637a036616c6dfb1d9e1bbdc0e005355108")
                                .send()
                                .getResult();
        System.out.println("from:  "+transaction.getFrom());
        System.out.println("to :   "+transaction.getTo()+" "+
                           "value: "+transaction.getValue()+" "+
                            "data: "+transaction.getInput());
        String data = transaction.getInput();
        data = data.toUpperCase();
        int length = data.length() / 2;
        char[] hexChars = data.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }

        System.out.print("d :"+new String(d));



    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

}
*/
