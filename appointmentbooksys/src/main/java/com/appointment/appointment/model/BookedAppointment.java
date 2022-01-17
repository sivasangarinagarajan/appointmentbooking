package com.appointment.appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bookedappointment")
public class BookedAppointment {

	
	@Id
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
}
