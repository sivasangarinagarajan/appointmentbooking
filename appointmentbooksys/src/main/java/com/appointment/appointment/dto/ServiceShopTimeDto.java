package com.appointment.appointment.dto;

import java.util.Date;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ServiceShopTimeDto {

	private static final String MY_TIME_ZONE="Asia/Kolkata";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = MY_TIME_ZONE)
    @Temporal(TemporalType.TIME)
    private Date slotTime;
    
}
