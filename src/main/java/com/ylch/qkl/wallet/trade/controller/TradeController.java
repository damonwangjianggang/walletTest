package com.ylch.qkl.wallet.trade.controller;

import com.ylch.qkl.wallet.trade.bean.TransferInfoBean;
import com.ylch.qkl.wallet.trade.service.TradeService;
import com.ylch.qkl.wallet.util.bean.RequestBodyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {


    @Autowired
    private TradeService tradeService;

    @PostMapping("/sendTrasfer")
    public String sendTrasfer(@RequestBody RequestBodyBean request){
        return  tradeService.sendTrasfer(request.getFromAccountId(),request.getFromAccountIdPassword(),request.getToAccountId(),
                request.getAmount(),request.getData(),request.getIp());
    }

    @PostMapping("/getTranferInfo")
    public TransferInfoBean getTranferInfo(@RequestBody RequestBodyBean request){
        return tradeService.getTranferInfo(request.getTranferHash(),request.getIp());
    }

}
