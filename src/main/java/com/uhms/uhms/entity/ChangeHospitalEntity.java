package com.uhms.uhms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Proxy(lazy = false)    //关闭延迟加载，不然测试单元总是报错
public class ChangeHospitalEntity implements Serializable {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private Date changeHospitalDate;
    private String changeHospitalName;
}
