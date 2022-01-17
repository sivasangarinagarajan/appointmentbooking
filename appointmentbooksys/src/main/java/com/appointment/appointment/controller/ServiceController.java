package com.appointment.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.appointment.config.GenericResponse;
import com.appointment.appointment.dto.CheckslotDto;
import com.appointment.appointment.model.Serviceshop;
import com.appointment.appointment.service.ServiceShop;


@RestController
@RequestMapping("/serviceshop")
public class ServiceController {
	
	@Autowired
	ServiceShop serviceshop;
	
	@GetMapping("/location/{locationname}")
	public List<Serviceshop> getServiceByLocation(@PathVariable String locationname)
	{
	
	return serviceshop.findByCity(locationname);
	}
	
	 @PostMapping
	    public ResponseEntity<Serviceshop> createShop(@RequestBody Serviceshop servicedata)
	                                                    {
		 Serviceshop createdshop = serviceshop.createShop(servicedata);
	
		// System.out.println(createdshop.getId());
	        return new ResponseEntity<Serviceshop>(createdshop,HttpStatus.OK);
	    }
	 @GetMapping("/{id}")
	    public ResponseEntity<Serviceshop> getServiceshopById(@PathVariable("id") String id) 
	                                                    {
		 Serviceshop entity = serviceshop.getServiceshopById(id);
	 
	        return new ResponseEntity<Serviceshop>(entity,HttpStatus.OK);
	    }

	
	 @GetMapping("/timeslots/{id}")
	    public GenericResponse getOpeningAndClosingTimeById(@PathVariable("id") String id) 
	     {
	 // Serviceshop entity = serviceshop.getOpeningAndClosingById(id);
    //return new GenericResponse<Serviceshop>(entity,HttpStatus.OK);
			return serviceshop.getOpeningAndClosingById(id);
	    }

	 
	
}
