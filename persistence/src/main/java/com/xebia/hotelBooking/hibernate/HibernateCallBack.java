package com.xebia.hotelBooking.hibernate;

import org.hibernate.Session;

public abstract class HibernateCallBack<T> {

	public abstract T execute(Session session);
	
	
}
