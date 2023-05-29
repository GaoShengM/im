package com.gsm.im.service.user.model.req;


import com.gsm.im.common.model.RequestBase;
import com.gsm.im.service.user.dao.ImUserDataEntity;
import lombok.Data;

import java.util.List;


@Data
public class ImportUserReq extends RequestBase {

    private List<ImUserDataEntity> userData;


}
