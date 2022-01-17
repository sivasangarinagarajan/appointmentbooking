package com.appointment.appointment.service;

import java.util.Date;
import java.util.List;

import com.appointment.appointment.dto.AppointmentDto;
import com.appointment.appointment.model.Appointment;


public interface AppointmentService {

	
	public String createAppointment(AppointmentDto appointmentDto);
	
	public Appointment getAppointmentById(String id);
	
	List<Appointment> getAppointmentByDate(Date date);
	
	long countByServiceIdAndAppointmentDateAndAppointmentTime(String Id,Date appDate,Date appTime);
}
