package com.ylch.qkl.wallet.util.client;

import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;


public class ParityClient {
    private static String ip = "http://192.168.20.45:8545/";
    
    private ParityClient(){}
 
    private static class ClientHolder{
        private static final Parity parity = Parity.build(new HttpService(ip));
    }
 
    public static final  Parity getParity(){
        return ClientHolder.parity;
    }

}
