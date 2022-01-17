package com.appointment.appointment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="serviceshop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serviceshop {

	@Id
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	private static final String MY_TIME_ZONE="Asia/Kolkata";
	
	@Column(name="serviceshop")
	private String serviceshop;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="openingtime")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = MY_TIME_ZONE)
// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Temporal(TemporalType.TIME)
     private Date openingtime;
	
	@Column(name="closingtime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = MY_TIME_ZONE)
    @Temporal(TemporalType.TIME)
    private Date closingtime;
	
	
	@Column(name="country")
	private String country;
	
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	
	@Column(name="slotinterval")
	private int slotinterval;
	
	
	@Column(name="slotcapacity")
	private int slotcapacity;
	
	
	
	
	

	
}
	
