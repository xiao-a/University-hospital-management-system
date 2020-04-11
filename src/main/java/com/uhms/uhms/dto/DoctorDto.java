package com.uhms.uhms.dto;


import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
public class DoctorDto implements Serializable {
    private String doctorId;
    private String name;
    private String sex;
    private String division;
    private Integer age;
    private String startWorkDateStr;
    private String phoneNumber;
    private String username;
    private String password;
    private String email;
    private String status;
}
