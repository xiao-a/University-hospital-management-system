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
    String doctorId;
    String doctorName;
    String appointmentId;
    Double fee;
    String division;
    String patientCaseContext;  //病情描述
    String examineResult;       //检查结果
    String diagnosisResult;     //诊断结果
    String handlingSuggestion;  //处理意见
    private String status;
    private Date createDate;
    private Date updateDate;
}
