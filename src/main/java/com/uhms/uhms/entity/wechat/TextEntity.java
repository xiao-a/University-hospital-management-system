package com.uhms.uhms.entity.wechat;

import lombok.Data;

/**
 *消息共有的基类
 */
@Data
public class TextEntity {
    private String content;  //发送的文本内容
}
