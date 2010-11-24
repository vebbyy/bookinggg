package com.xebia.hotelBooking.service;

import java.util.List;

import com.xebia.hotelBooking.domain.City;
import com.xebia.hotelBooking.domain.Hotel;
import com.xebia.hotelBooking.domain.State;

public interface SearchHotelService {

	List<Hotel> getHotelList();

	List<City> getCityList();

	List<State> getStateList();

}
