package com.gsm.im.tcp.feign;


import com.gsm.im.common.ResponseVO;
import com.gsm.im.common.model.message.CheckSendMessageReq;
import feign.Headers;
import feign.RequestLine;


public interface FeignMessageService {

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("POST /message/checkSend")
    public ResponseVO checkSendMessage(CheckSendMessageReq o);

}
