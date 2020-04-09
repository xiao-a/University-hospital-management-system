package com.uhms.uhms.entity;


import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Proxy(lazy = false)    //关闭延迟加载，不然测试单元总是报错
@Table(name = "t_doctor")
public class DoctorEntity  implements Serializable {
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
    private String email;
    private String status;
    private Date createDate;
    private Date updateDate;
}