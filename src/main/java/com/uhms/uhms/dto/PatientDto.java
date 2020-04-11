package com.uhms.uhms.dto;

import lombok.Data;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Data
public class PatientDto implements Serializable {
    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String status;
}
