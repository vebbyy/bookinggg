package com.xebia.hotelBooking.service.impl;

import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xebia.hotelBooking.DBSetUp.IDataMethods;
import com.xebia.hotelBooking.domain.Customer;
import com.xebia.hotelBooking.hibernate.HibernateTemplate;

@ContextConfiguration(locations = { "classpath:hibernate-test.cfg.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceImplTest extends IDataMethods {

	private LoginServiceImpl loginServiceImpl;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	private SessionFactory hibernateSession;

	private String username;

	private String password;

	private DirectFieldAccessor directFieldAccessor;

	@Before
	public void setUp() throws Exception {
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
		loginServiceImpl = new LoginServiceImpl();
		hibernateTemplate = new HibernateTemplate();
		
		directFieldAccessor = new DirectFieldAccessor(loginServiceImpl);
		directFieldAccessor.setPropertyValue("hibernateTemplate",
				hibernateTemplate);

		directFieldAccessor = new DirectFieldAccessor(hibernateTemplate);
		directFieldAccessor.setPropertyValue("session", hibernateSession
				.openSession());

		username = "abcd";
		password = "abcd";
	}

	@Test
	public void shouldGetUserForLoginVerification() {
		assertEquals("abcd", loginServiceImpl.getUserForLoginVerification(
				username, password).getUserName());
	}

}
