package com.xebia.hotelBooking.service;

import com.xebia.hotelBooking.domain.Customer;

public interface LoginService {

	public Customer getUserForLoginVerification( String userName, String password);

}
