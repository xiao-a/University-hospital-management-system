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
@Table(name = "t_bed_use")
public class BedUseEntity implements Serializable {
    @Id
    private String bedUseId;
    private String patientId;
    private Date startDate;
    private Date endDate;
    private String status;
    private Date createDate;
    private Date updateDate;
}
