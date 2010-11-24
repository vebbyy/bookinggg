package com.xebia.hotelBooking.service.impl;

import com.xebia.hotelBooking.domain.Customer;
import com.xebia.hotelBooking.hibernate.HibernateTemplate;
import com.xebia.hotelBooking.service.RegistrationService;


public class RegistrationServiceImpl implements RegistrationService{

	private HibernateTemplate hibernateTemplate; 
	
	public void persistUser(Customer user) {
	hibernateTemplate.persist(user);	
	}
	
}
