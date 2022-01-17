package com.appointment.appointment.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	@NotBlank(message="Please enter your name")
	@Column(name="name")
	private String name;
	
	@Column(name="mail")
	private String mail;
	
	
	@Column(name="phoneNumber")
	@NotBlank(message="Phonenumber is mandatory")
	private String phoneNumber;
	
//	@OneToMany(cascade=CascadeType.ALL, targetEntity=Appointment.class)
//	private Set<Appointment> appointment = new HashSet<>();
	
}
