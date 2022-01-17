package com.appointment.appointment.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.appointment.appointment.config.GenericResponse;
import com.appointment.appointment.dto.ServiceShopTimeDto;
import com.appointment.appointment.model.Serviceshop;
import com.appointment.appointment.model.Trackingslot;
import com.appointment.appointment.repository.ServiceShopRepository;
import com.appointment.appointment.repository.TrackingslotRepository;

@Service
public class ServiceShopImpl implements ServiceShop{

	@Autowired
	ServiceShopRepository servicerepo;
	@Autowired
	TrackingslotRepository trackingrepo;
	
	@Override
	public Serviceshop createShop(Serviceshop serviceshop) {
		// TODO Auto-generated method stub
		Serviceshop createdshop = servicerepo.save(serviceshop);
		String sid=createdshop.getId();
		Serviceshop getserviceshop=servicerepo.findById(sid).get();
		List<ServiceShopTimeDto> slots = new ArrayList<>();
		Date dateObj1 = getserviceshop.getOpeningtime();
		Date dateObj2 = getserviceshop.getClosingtime();
		int serviceslotinterval=getserviceshop.getSlotinterval();
		System.out.println("Time Start: "+dateObj1);
		System.out.println("Time End: "+dateObj2);
		long dif = dateObj1.getTime();//convert to Millisec
		long dif2 = dateObj2.getTime();
		long interval=serviceslotinterval*60000;
		//GenericResponse response=new GenericResponse();
		for(long i=dif;dif<dif2; dif += interval) //1hr=3600000ms
		{
			ServiceShopTimeDto slotTime=new ServiceShopTimeDto();
		    Date slot = new Date(dif);
		    slotTime.setSlotTime(slot);
		    //slots.add(slotTime);
		    //System.out.println(slotTime.getSlotTime());
		    Trackingslot ts = new Trackingslot();
		    ts.setServiceid(sid);
		    ts.setTime(slotTime.getSlotTime());
		    ts.setSlotcapacity(getserviceshop.getSlotcapacity());
		    trackingrepo.save(ts);
		}  
		
		return createdshop;
	}
	@Override
	public List<Serviceshop> findByCity(String city) {
		
		return  servicerepo.findByCity(city);
		
	}
	@Override
	public Serviceshop getServiceshopById(String id) {
		// TODO Auto-generated method stub
		  return servicerepo.findById(id).get();
	}
	@Override
	public GenericResponse getOpeningAndClosingById(String Id) {
		//get minute based interval
		Serviceshop serviceshop=servicerepo.findById(Id).get();
		List<ServiceShopTimeDto> slots = new ArrayList<>();
		Date dateObj1 = serviceshop.getOpeningtime();
		Date dateObj2 = serviceshop.getClosingtime();
		int serviceslotinterval=serviceshop.getSlotinterval();
		System.out.println("Time Start: "+dateObj1);
		System.out.println("Time End: "+dateObj2);
		long dif = dateObj1.getTime();//convert to Millisec
		long dif2 = dateObj2.getTime();
		long interval=serviceslotinterval*60000;
		GenericResponse response=new GenericResponse();
		for(long i=dif;dif<dif2; dif += interval) //1hr=3600000ms
		{
			ServiceShopTimeDto slotTime=new ServiceShopTimeDto();
		    Date slot = new Date(dif);
		    slotTime.setSlotTime(slot);
		    slots.add(slotTime);
		    
		}  
		response.setData(slots);
		//response.setDescription("success");
		return response;
		}


	
	
	

}
