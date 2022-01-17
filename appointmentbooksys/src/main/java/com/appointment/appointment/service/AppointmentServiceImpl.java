package com.appointment.appointment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.appointment.appointment.dto.AppointmentDto;
import com.appointment.appointment.model.Appointment;
import com.appointment.appointment.model.Customer;
import com.appointment.appointment.model.Serviceshop;
import com.appointment.appointment.repository.AppointmentRepository;
import com.appointment.appointment.repository.ServiceShopRepository;
import com.appointment.appointment.repository.TrackingslotRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	CustomerService customerservice;
	
	@Autowired
	ServiceShop serviceshop;
	
	@Autowired
	AppointmentRepository apprepo;
	
	@Autowired
	ServiceShopRepository servicerepo;
	

	@Autowired
	TrackingslotRepository tsrepo;
	
	@Autowired
	AppointmentService appointmentservice;
	
	@Override
	public String createAppointment(AppointmentDto appointmentDto) {
		
		long ifexist = tsrepo.countByServiceidAndTime(appointmentDto.getServiceId(), appointmentDto.getAppointmenttime());
		System.out.println(ifexist);
		System.out.println("--------------");
		if(ifexist >= 1)
		 {
			long ifavailable = appointmentservice.countByServiceIdAndAppointmentDateAndAppointmentTime(appointmentDto.getServiceId(),appointmentDto.getAppointmentdate(),appointmentDto.getAppointmenttime());
			System.out.println(ifavailable);
			Serviceshop checkcapacity=servicerepo.getById(appointmentDto.getServiceId());
			int capacity=checkcapacity.getSlotcapacity();
			System.out.println(capacity);
			if(capacity>ifavailable)
			{
				
				Date date=new Date(System.currentTimeMillis());
				Appointment appointment=new Appointment();
				Customer customer=new Customer();
				customer.setName(appointmentDto.getCustomername());
				customer.setMail(appointmentDto.getMailid());
				customer.setPhoneNumber(appointmentDto.getPhonenumber());
			    Serviceshop newserviceshop=serviceshop.getServiceshopById(appointmentDto.getServiceId());
				appointment.setCustomer(customer);
				appointment.setServiceshop(newserviceshop);
				appointment.setProducttype(appointmentDto.getProductType());
				appointment.setDescription(appointmentDto.getDescription());
				appointment.setAppointmentdate(appointmentDto.getAppointmentdate());
				appointment.setAppointmenttime(appointmentDto.getAppointmenttime());
				apprepo.save(appointment);
				return "Appointment Fixed";
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

	@Override
	public Appointment getAppointmentById(String id) {
		// TODO Auto-generated method stub
		return apprepo.findById(id).get();
	}

	@Override
	public List<Appointment> getAppointmentByDate(Date date) {
		// TODO Auto-generated method stub
		return apprepo.findByAppointmentdate(date);
	}

	

	@Override
	public long countByServiceIdAndAppointmentDateAndAppointmentTime(String Id, Date appDate, Date appTime) {
		
		Serviceshop servicesp=servicerepo.findById(Id).get();
		return apprepo.countByServiceshopAndAppointmentdateAndAppointmenttime(servicesp, appDate, appTime);
	}

	

}
