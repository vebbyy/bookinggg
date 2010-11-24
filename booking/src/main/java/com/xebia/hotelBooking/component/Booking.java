package com.xebia.hotelBooking.component;

import java.util.Date;

import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;

import com.xebia.hotelBooking.service.BookingService;

@Name("booking")
public class Booking {

	private static final String SUCCESS = "success";

	@In
	private BookingService bookingService;

	@In
	private FacesMessages facesMessages;

	@End
	public String book() {

		
		
		

			facesMessages.addToControl("checkInDate",
					"Check in date must be a future date");
			return "dsads";
//		bookingService.bookHotel(checkInDate, checkOutDate);
//
//		return SUCCESS;
	}

	private Date checkInDate;
	private Date checkOutDate;

	/**
	 * @return the checkInDate
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkInDate
	 *            the checkInDate to set
	 */
	public void setCheckInDate(Date checkInDate) {
		
		this.checkInDate = checkInDate;
	}

	/**
	 * @param checkOutDate
	 *            the checkOutDate to set
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
