package com.gsm.im.service.friendship.model.req;

import com.gsm.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: gsm
 * @version: 1.0
 */
@Data
public class GetFriendShipRequestReq extends RequestBase {

    @NotBlank(message = "用户id不能为空")
    private String fromId;

}
