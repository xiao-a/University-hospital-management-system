package com.uhms.uhms.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppointmentHistoryDto implements Serializable {
    private String patientId;
    private String division;
    private String doctorName;
    private String msg;
    private String appointmentStatus;
    private String appointmentDate;
    private String submitDate;
}
