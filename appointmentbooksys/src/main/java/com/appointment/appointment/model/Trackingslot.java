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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="trackingslot")
public class Trackingslot {

	 private static final String MY_TIME_ZONE="Asia/Kolkata";
	@Id
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	@Column(name="serviceid")
	private String serviceid;
	
	@Column(name="time")
	  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = MY_TIME_ZONE)
	@Temporal(TemporalType.TIME)
	     private Date time;
		
		
	
		
		@Column(name="slotcapacity")
		private int slotcapacity;
	
	
}
