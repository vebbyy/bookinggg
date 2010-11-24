package com.xebia.hotelBooking.action;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import com.xebia.hotelBooking.domain.City;
import com.xebia.hotelBooking.domain.Hotel;
import com.xebia.hotelBooking.domain.State;
import com.xebia.hotelBooking.service.SearchHotelService;

@Name("searchAction")
public class SearchAction {

	@In
	private SearchHotelService searchHotelService;

	@Out(required = false, scope=ScopeType.PAGE)
	private List<String> hotelBrandNameList;
	
	@Out(required = false, scope=ScopeType.PAGE)
	private List<Hotel> hotelList;
	
	@Out(required = false, scope=ScopeType.PAGE)
	private List<City> cityList;
	
	@Out(required = false, scope=ScopeType.PAGE)
	private List<State> stateList;
	
	
	
	@Factory(value = "hotelList")
	public void getHotelList() {
		hotelList = searchHotelService.getHotelList();
	}
	
	@Factory(value = "cityList")
	public void getCityList()
	{
		cityList=searchHotelService.getCityList();	
	}
	
	@Factory("stateList")
	public void getStateList()
	{
		stateList = searchHotelService.getStateList();		
	}
	

}
