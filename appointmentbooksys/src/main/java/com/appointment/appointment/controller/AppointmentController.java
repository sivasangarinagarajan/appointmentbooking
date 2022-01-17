package com.appointment.appointment.controller;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.appointment.appointment.dto.AppointmentDto;
import com.appointment.appointment.dto.CheckslotDto;
import com.appointment.appointment.model.Appointment;
import com.appointment.appointment.repository.TrackingslotRepository;
import com.appointment.appointment.service.AppointmentService;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	

	@Autowired
	AppointmentService appointmentservice;
	
	@Autowired
	TrackingslotRepository tsrepo;

	@PostMapping
    public ResponseEntity<String> createAppointment(@Valid @RequestBody AppointmentDto appointmentDto)
     {
		 String returnmsg = appointmentservice.createAppointment(appointmentDto);
		 if(returnmsg == "Appointment fixed")
		 {
        return ResponseEntity.status(HttpStatus.OK).body("ok");
		 }
		 else
		 {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(returnmsg); 
		 }
    }
	 @GetMapping("/{id}")
	    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") String id) 
	                                                    {
		 Appointment entity = appointmentservice.getAppointmentById(id);
	        return new ResponseEntity<Appointment>(entity,HttpStatus.OK);
	    }

	 
	 
	 
	 
	 
	 @GetMapping("/date")
	    public ResponseEntity<?> getAppointmentByDate( @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) 
	                                                    {
		 List<Appointment> entity = appointmentservice.getAppointmentByDate(date);
	        return  ResponseEntity.status(HttpStatus.OK).body(entity);
	    }
	 
	 @PostMapping("/checkslot")
	    public String getTimeSlotCount(@RequestBody CheckslotDto checkslotdto) 
	     {
		 
		 //System.out.println(checkslotdto.getServiceid() +checkslotdto.getSlotDate()+checkslotdto.getSlotTime());
//		 DateFormat inputFormat = new SimpleDateFormat("HH:mm:ss");
//		 Date date = inputFormat.parse(checkslotdto.getSlotTime());
		 long ifexist = tsrepo.countByServiceidAndTime(checkslotdto.getServiceid(), checkslotdto.getSlotTime());
		 if(ifexist >= 1)
		 {
			long ifavailable = appointmentservice.countByServiceIdAndAppointmentDateAndAppointmentTime(checkslotdto.getServiceid(), checkslotdto.getSlotDate(), checkslotdto.getSlotTime());
			if(ifavailable == 0)
			{
				
				return "Appointemnt fixed";
			}
			else
			{
				 return "Already appointment fixed for given timeslot";
			}
	   
	     }
		 else
		 {
			 return "No slot time available";
		 }
	     }

}
