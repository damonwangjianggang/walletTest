package com.ylch.qkl.wallet.util.client;

import org.springframework.stereotype.Component;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;


@Component
public class ParityClient {

    private  Parity parity;
    public  Parity getParity(String ip) {
        return parity = Parity.build(new HttpService(ip));

    }
}
