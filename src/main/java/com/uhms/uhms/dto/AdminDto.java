package com.uhms.uhms.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminDto implements Serializable {
    private String adminId;
    private String doctorId;
    private String name;
    private String sex;
    private Integer age;
    private String username;
    private String phoneNumber;
    private String address;
}
