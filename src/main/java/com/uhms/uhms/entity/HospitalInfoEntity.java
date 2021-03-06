package com.uhms.uhms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Proxy(lazy = false)    //关闭延迟加载，不然测试单元总是报错
@Table(name ="t_hospital_info")
public class HospitalInfoEntity implements Serializable {
    @Id
    private String hospitalInfoId;
    private String commonStartTime;
    private String commonEndTime;
    private String weekStartTime;
    private String weekEndTime;
    private String phoneNumber;
    private String address;
    private String status;
    private Date createDate;
    private Date updateDate;
}
