package com.uhms.uhms.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class DoctorVagueDto implements Serializable {
    private String adminId;
    private String doctorId;
    private String name;
    private String division;
}
