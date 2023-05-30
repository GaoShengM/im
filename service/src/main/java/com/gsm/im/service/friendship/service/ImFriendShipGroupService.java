package com.gsm.im.service.friendship.service;

import com.gsm.im.common.ResponseVO;
import com.gsm.im.service.friendship.dao.ImFriendShipGroupEntity;
import com.gsm.im.service.friendship.model.req.AddFriendShipGroupReq;
import com.gsm.im.service.friendship.model.req.DeleteFriendShipGroupReq;

/**
 * @author: Chackylee
 * @description:
 **/
public interface ImFriendShipGroupService {

    public ResponseVO addGroup(AddFriendShipGroupReq req);

    public ResponseVO deleteGroup(DeleteFriendShipGroupReq req);

    public ResponseVO<ImFriendShipGroupEntity> getGroup(String fromId, String groupName, Integer appId);


}
