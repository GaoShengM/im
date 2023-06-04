package com.gsm.im.service.group.model.req;

import com.gsm.im.common.model.RequestBase;
import lombok.Data;

/**
 * @author: Chackylee
 * @description:
 **/
@Data
public class GetGroupReq extends RequestBase {

    private String groupId;

}
