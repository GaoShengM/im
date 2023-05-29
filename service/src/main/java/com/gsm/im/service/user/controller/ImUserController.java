package com.gsm.im.service.user.controller;

import com.gsm.im.common.ResponseVO;
import com.gsm.im.service.user.model.req.DeleteUserReq;
import com.gsm.im.service.user.model.req.ImportUserReq;
import com.gsm.im.service.user.service.ImUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/user")
public class ImUserController {
    @Autowired
    private ImUserService imUserService;

    @RequestMapping("importUser")
    public ResponseVO importUser(@RequestBody ImportUserReq req, Integer appId) {
        return imUserService.importUser(req);
    }

    @RequestMapping("/deleteUser")
    public ResponseVO deleteUser(@RequestBody @Validated DeleteUserReq req, Integer appId) {
        req.setAppId(appId);
        return imUserService.deleteUser(req);
    }

}
