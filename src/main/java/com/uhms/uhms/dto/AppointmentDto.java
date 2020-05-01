package com.uhms.uhms.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppointmentDto implements Serializable {
    private String patientId;
    private String division;
    private String appointmentDate;
    private String msg;
}
