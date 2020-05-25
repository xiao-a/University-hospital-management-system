package com.uhms.uhms.entity.wechat;

import lombok.Data;

/**
 *消息共有的基类
 */
@Data
public class BaseBeanEntity {
    private String toUser;
    private String msgType;
}
