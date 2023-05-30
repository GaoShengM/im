package com.gsm.im.service.friendship.service;

import com.gsm.im.common.ResponseVO;
import com.gsm.im.service.friendship.model.req.AddFriendShipGroupMemberReq;
import com.gsm.im.service.friendship.model.req.DeleteFriendShipGroupMemberReq;

/**
 * @author: Chackylee
 * @description:
 **/
public interface ImFriendShipGroupMemberService {

    public ResponseVO addGroupMember(AddFriendShipGroupMemberReq req);

    public ResponseVO delGroupMember(DeleteFriendShipGroupMemberReq req);

    public int doAddGroupMember(Long groupId, String toId);

    public int clearGroupMember(Long groupId);
}
