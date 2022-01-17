package com.appointment.appointment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment.appointment.model.Appointment;
import com.appointment.appointment.model.Serviceshop;



@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String>
{
	List<Appointment> findByAppointmentdate(Date date);
	long countByServiceshopAndAppointmentdateAndAppointmenttime(Serviceshop serviceshop,Date appDate,Date apptime);
}
