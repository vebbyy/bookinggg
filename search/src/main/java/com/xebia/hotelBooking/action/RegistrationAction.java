package com.xebia.hotelBooking.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import com.xebia.hotelBooking.domain.Customer;
import com.xebia.hotelBooking.service.RegistrationService;

@Name("registrationAction")
public class RegistrationAction {

	
	@In
	private RegistrationService registerService;
	
	
	@In
	private Customer user;
	
	
	public void persistUser()
	{
		
		
		registerService.persistUser(user);
	}
	
}
