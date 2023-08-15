package com.gsm.im.codec.pack.friendship;

import lombok.Data;

@Data
public class AddFriendBlackPack {
    private String fromId;

    private String toId;

    private Long sequence;
}
