package com.appointment.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment.appointment.model.Serviceshop;

@Repository
public interface ServiceShopRepository extends JpaRepository<Serviceshop, String>{

	List<Serviceshop> findByCity(String city);
	Serviceshop findOpeningtimeAndClosingtimeById(String Id);
	
	
}
