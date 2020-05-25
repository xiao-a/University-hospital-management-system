package com.uhms.uhms.entity.wechat;

import lombok.Data;

/**
 *这里就把图文的内容包裹进来了    父类Basebean里面的包括了接收者的openid 和消息类型
 */
@Data
public class WeChatNewsEntity extends BaseBeanEntity{
    private KFNewsEntity kfNewsEntity;
}
