package com.uhms.uhms.entity.wechat;

import lombok.Data;

/**
 *
 */
@Data
public class ArticlesEntity extends BaseBeanEntity{
    private String title; //标题
    private String description;  //描述
    private String url;  //该图文的点击跳转链接
    private String picUrl;  //图片的URL
}
