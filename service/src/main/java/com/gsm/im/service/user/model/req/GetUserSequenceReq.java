package com.gsm.im.service.user.model.req;

import com.gsm.im.common.model.RequestBase;
import lombok.Data;

/**
 * @description:
 * @author: gsm
 * @version: 1.0
 */
@Data
public class GetUserSequenceReq extends RequestBase {

    private String userId;

}
