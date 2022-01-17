package com.appointment.appointment.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.GenericGenerator;

import com.appointment.appointment.dto.AppointmentDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

	
	@Id
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	 @ManyToOne
	 @JoinColumn(name="serviceId")
	 private Serviceshop serviceshop;
	
	
	 @ManyToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="customer_id")
	 private Customer customer;


	  
	 
	@Column(name="appointmentdate")
    @Temporal(TemporalType.DATE)
	private Date appointmentdate;
	
		
		
	 @Column(name="appointmenttime")
	 private static final String MY_TIME_ZONE="Asia/Kolkata";
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = MY_TIME_ZONE)
	 @Temporal(TemporalType.TIME)
     private Date appointmenttime;
		
	 @Column(name="producttype")
	 private String producttype;
	
	 @Column(name="description")
	 private String description;
	 
	
	

	 
	

	
	
}
