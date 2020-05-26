package com.uhms.uhms.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class PatientVagueDto implements Serializable {
    private String adminId;
    private String patientId;
    private String name;
    private String phoneNumber;
}
