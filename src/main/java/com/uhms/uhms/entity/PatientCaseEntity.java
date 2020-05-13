package com.uhms.uhms.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
@Table(name ="t_patient_case")
public class PatientCaseEntity implements Serializable {
    @Id
    String patientCaseId;
    String patientId;
    String patientName;
    Double fee;
    String patientCaseContext;
    String examineResult;
    String diagnosisResult;
    String handlingSuggestion;
    private String status;
    private Date createDate;
    private Date updateDate;
}
