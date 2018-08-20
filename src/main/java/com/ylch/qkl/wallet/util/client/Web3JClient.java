package com.ylch.qkl.wallet.util.client;

import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;


@Component
public class Web3JClient {

    private   Web3j web3j;
    public  Web3j getWeb3j(String ip){
                if(web3j==null) {
                    web3j = Web3j.build(new HttpService(ip));
                }
        return web3j;
    }

}
