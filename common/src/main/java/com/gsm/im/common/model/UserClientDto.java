package com.gsm.im.common.model;

import lombok.Data;

/**
 * @description:
 * @author: gsm
 * @version: 1.0
 */
@Data
public class UserClientDto {

    private Integer appId;

    private Integer clientType;

    private String userId;

    private String imei;

}
