package com.appointment.appointment.dto;

import java.util.Date;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {


	
	  
	   private String serviceId;
		private String ProductType;
	    private String Description;

		@Temporal(TemporalType.DATE)
	    private Date appointmentdate;
	
	
		 private static final String MY_TIME_ZONE="Asia/Kolkata";
		 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = MY_TIME_ZONE)
	     private Date appointmenttime;
		 
		 
		 private String customername;
		
		 @NotBlank(message="maild id mandatory")
		 private String mailid;
		 
		 @NotBlank(message = "Phonenumber is mandatory")
		 private String phonenumber;
		
		 
	
	   
}
