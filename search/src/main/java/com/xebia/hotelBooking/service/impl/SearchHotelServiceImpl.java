package com.xebia.hotelBooking.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.annotations.In;

import com.xebia.hotelBooking.domain.City;
import com.xebia.hotelBooking.domain.Hotel;
import com.xebia.hotelBooking.domain.State;
import com.xebia.hotelBooking.hibernate.HibernateTemplate;
import com.xebia.hotelBooking.model.SearchModel;
import com.xebia.hotelBooking.service.SearchHotelService;


public class SearchHotelServiceImpl implements SearchHotelService {

	private HibernateTemplate hibernateTemplate;

	@In
	private SearchModel searchModel ;
	
	@Override
	public List<Hotel> getHotelList() {

		return hibernateTemplate.executeCriteria(Hotel.class,
				new HibernateTemplate.HibernateCallBack<Hotel>() {

					@Override
					public void setCriteriaData(Criteria criteria) {
						criteria.add(Restrictions.like("name", searchModel
								.getHotelName()
								+ "%"));
						
						System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
						System.out.println(searchModel.getCityID());
						System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
						
						if(searchModel.getCityID() != 0) {
							criteria.add(Restrictions.eq("city.id", searchModel.getCityID())) ;
						}
						criteria.add(Restrictions.eq("isBooked", 0));

					}

				});

	}

	@Override
	public List<City> getCityList() {
		
		return hibernateTemplate.executeCriteria(City.class,
				new HibernateTemplate.HibernateCallBack<City>() {

					@Override
					public void setCriteriaData(Criteria criteria) {
					}

				});	}

	@Override
	public List<State> getStateList() {
		// TODO Auto-generated method stub
		return null;
	}


}
