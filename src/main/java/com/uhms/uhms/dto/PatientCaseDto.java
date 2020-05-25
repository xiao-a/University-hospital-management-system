package com.uhms.uhms.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PatientCaseDto implements Serializable {
    String patientCaseId;
    String appointmentId;
    String doctorId;
    String patientId;
    String patientName;
    Double fee;
    String division;
    String patientCaseContext;
    String examineResult;
    String diagnosisResult;
    String handlingSuggestion;
    private String status;
    private Date createDate;
    private Date updateDate;
}
