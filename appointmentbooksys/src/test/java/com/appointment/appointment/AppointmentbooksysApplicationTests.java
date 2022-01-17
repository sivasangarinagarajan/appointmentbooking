package com.appointment.appointment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appointment.appointment.model.Serviceshop;
import com.appointment.appointment.repository.ServiceShopRepository;

@SpringBootTest
class AppointmentbooksysApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	ServiceShopRepository serviceshoprepo;
//	
//	@Test
//     public void testServiceAdd()
//	{
//		Serviceshop serviceshop=new Serviceshop();
//		serviceshop.setServiceshop("ss");
//		serviceshop.setCity("Madurai");
//		serviceshop.setState("TN");
//		
//		serviceshoprepo.save(serviceshop);	
//	}
}
