package com.ylch.qkl.wallet.util.test;

import java.math.BigDecimal;

import com.ylch.qkl.wallet.trade.dao.TradeDao;

public class TradeTest {
    public static void main(String args[]){
        TradeDao trade = new TradeDao();
       // trade.trasfer("0xa1b895b4591cd7ba31247a222a89c5ac368e3a5c","123","0x82bfcbce994b4a3091d0a7eadc1109f382360965",new BigDecimal(100));
    String a =trade.trasfer("0x7074798e9fdc7a9ddb3d090ef86b528ca8f6fe34",
    		"123", 
    		"0x4cd1f2800c020580cb32d06831b670ddfabdb54a", 
    		"100",
    		"0x7b2274696d65223a313533333738303337323839342c2274797065223a226572726f72222c226d7367223a22e4baa4e69893e4bfa1e681afe4b88ae993be227d");
    System.out.println(a);
    
    	
    }

}
