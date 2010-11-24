package com.xebia.hotelBooking.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class HibernateTemplate {

	private Session session;

	public <R> void persist(R persistObject) {

		session.save(persistObject);
	}

	public <T> List<T> executeCriteria(Class className,
			HibernateCallBack<T> hibernateCallBack) {
		Criteria criteria = session.createCriteria(className);
		hibernateCallBack.setCriteriaData(criteria);
		return criteria.list();

	}

	public interface HibernateCallBack<T> {

		public void setCriteriaData(Criteria criteria);

	}

}
