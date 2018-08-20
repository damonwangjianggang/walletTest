package com.ylch.qkl.wallet.util.test;

import com.ylch.qkl.wallet.util.client.ParityClient;
import com.ylch.qkl.wallet.util.client.Web3JClient;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;

import java.io.IOException;

/**
 * Created by ylch on 2018/8/16.
 */
public class loginTest {
    public static  void main(String args[]){
        ParityClient  parityClient = new ParityClient();
        Web3JClient web3JClient = new  Web3JClient();
        Parity parity =parityClient.getParity("Http://192.168.20.45:8585");
        try {
             parity.personalAccountsInfo().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
