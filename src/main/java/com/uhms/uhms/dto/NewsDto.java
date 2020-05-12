package com.uhms.uhms.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewsDto implements Serializable {
    private String adminId;
    private String newsId;
    private String newsImg;
    private String newsText;
    private String newsTitle;
}
