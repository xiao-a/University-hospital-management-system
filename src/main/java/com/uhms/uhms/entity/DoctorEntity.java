package com.uhms.uhms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Proxy(lazy = false)    //关闭延迟加载，不然测试单元总是报错
public class DoctorEntity implements Serializable {
    @Id
    private String id;
    private String name;
    private String sex;
    private String division;
    private Integer age;
    private String startWorkDate;
    private String phoneNumber;
    private String username;
    private String password;
}
