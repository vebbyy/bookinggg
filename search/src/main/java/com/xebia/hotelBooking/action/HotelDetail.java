package com.xebia.hotelBooking.action;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import com.xebia.hotelBooking.domain.Hotel;

@Name("hotelDetail")
public class HotelDetail {

	private static final String BOOKHOTEL = "bookHotel";

	
	@Out(required=false,scope=ScopeType.CONVERSATION)
	private Hotel hotel;

	@Begin
	public String getHotelDetail(Hotel hotel) {
		
		this.hotel = hotel;
		return BOOKHOTEL;

	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 *            the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
