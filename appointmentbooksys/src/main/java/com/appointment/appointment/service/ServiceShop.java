package com.appointment.appointment.service;

import java.util.List;

import com.appointment.appointment.config.GenericResponse;
import com.appointment.appointment.model.Serviceshop;



public interface ServiceShop {

	public Serviceshop createShop(Serviceshop servcieshop);
	
	List<Serviceshop> findByCity(String city);
	public Serviceshop getServiceshopById(String id);
    GenericResponse getOpeningAndClosingById(String Id);
}
