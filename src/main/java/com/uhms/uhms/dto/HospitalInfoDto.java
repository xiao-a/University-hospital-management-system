package com.uhms.uhms.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HospitalInfoDto implements Serializable {
    private String adminId;
    private String commonStartTime;
    private String commonEndTime;
    private String weekStartTime;
    private String weekEndTime;
    private String phoneNumber;
    private String address;
}
