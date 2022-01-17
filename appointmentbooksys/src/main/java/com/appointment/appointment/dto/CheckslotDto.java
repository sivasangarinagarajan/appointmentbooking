package com.appointment.appointment.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckslotDto {


	 private static final String MY_TIME_ZONE="Asia/Kolkata";
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = MY_TIME_ZONE)
    private Date slotTime;
    
    @Temporal(TemporalType.DATE)
    private Date slotDate;
    
    private String serviceid;
    
	

}
