package com.xebia.hotelBooking.service.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.annotations.In;
import org.jboss.seam.security.Credentials;

import com.xebia.hotelBooking.domain.Hotel;
import com.xebia.hotelBooking.domain.Customer;
import com.xebia.hotelBooking.domain.CustomerHotelBooking;
import com.xebia.hotelBooking.hibernate.HibernateTemplate;
import com.xebia.hotelBooking.service.BookingService;

public class BookingServiceImpl implements BookingService {

	private HibernateTemplate hibernateTemplate;

	@In
	private Credentials credentials;

	@In
	private Hotel hotel;

	private CustomerHotelBooking userHotelBooking;

	@Override
	public void bookHotel(Date checkInDate, Date checkOutDate) {

		prepareUserHotelBooking(checkInDate, checkOutDate);

		hibernateTemplate.persist(userHotelBooking);
	}

	private void prepareUserHotelBooking(Date checkInDate, Date checkOutDate) {
		Customer user = getUser();
		userHotelBooking = new CustomerHotelBooking();

		userHotelBooking.setCustomer(user);
		hotel.setIsBooked(1);
		userHotelBooking.setHotel(hotel);
		userHotelBooking.setCheckInDate(checkInDate);
		userHotelBooking.setCheckOutDate(checkOutDate);

	}

	private Customer getUser() {

		return hibernateTemplate.executeCriteria(Customer.class,
				new HibernateTemplate.HibernateCallBack<Customer>() {

					@Override
					public void setCriteriaData(Criteria criteria) {
						criteria.add(Restrictions.eq("userName", credentials
								.getUsername()));
						

					}
				}).get(0);

	}

}
