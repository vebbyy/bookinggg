package com.xebia.hotelBooking.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.xebia.hotelBooking.domain.Customer;
import com.xebia.hotelBooking.hibernate.HibernateTemplate;
import com.xebia.hotelBooking.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private HibernateTemplate hibernateTemplate;

	@Override
	public Customer getUserForLoginVerification(final String userName,
			final String password) {

		List<Customer> customer = hibernateTemplate.executeCriteria(
				Customer.class,
				new HibernateTemplate.HibernateCallBack() {

					@Override
					public void setCriteriaData(Criteria criteria) {
						criteria.add(Restrictions.eq("userName", userName))
								.add(Restrictions.eq("password", password));

					}

				}

		);
		return customer.size() == 0 ? null : customer.get(0);
	}
}
