package com.uhms.uhms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
//@Entity
//@Proxy(lazy = false)    //关闭延迟加载，不然测试单元总是报错
//@Table(name ="t_patient_case")
public class FinancialEntity {
//    @Id
    String financialId;
    String year;
    String month;
    String day;
    Double money;
    private String status;
    private Date createDate;
    private Date updateDate;
}
