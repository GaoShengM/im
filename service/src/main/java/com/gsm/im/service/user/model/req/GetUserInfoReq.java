package com.gsm.im.service.user.model.req;


import com.gsm.im.common.model.RequestBase;
import lombok.Data;

import java.util.List;


@Data
public class GetUserInfoReq extends RequestBase {

    private List<String> userIds;


}
