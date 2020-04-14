package com.uhms.uhms.dto;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Data
public class ChangeHospitalDto implements Serializable {
    private String patientId;
    private String doctorId;
    private String changeHospitalDate;
    private String changeHospitalName;
}
