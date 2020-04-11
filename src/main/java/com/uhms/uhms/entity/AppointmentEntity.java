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
@Table(name="t_appointment")
public class AppointmentEntity  implements Serializable {
    @Id
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private Date appointmentDate;
    private String status;
    private Date createDate;
    private Date updateDate;
}
