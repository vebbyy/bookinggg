package com.xebia.hotelBooking.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class CustomerHotelBooking {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@Cascade(value = { CascadeType.ALL })
	private Hotel hotel;

	
	@ManyToOne
	@Cascade(value = { CascadeType.ALL })
	private Customer customer;
	
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the user
	 */

	private Date checkInDate;

	private Date checkOutDate;

	/**
	 * @return the checkInDate
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param checkInDate
	 *            the checkInDate to set
	 */
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate
	 *            the checkOutDate to set
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the archive
	 */
	public int getArchive() {
		return archive;
	}

	/**
	 * @param archive
	 *            the archive to set
	 */
	public void setArchive(int archive) {
		this.archive = archive;
	}

	private int archive;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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


	/**
	 * @return the user
	 */

}
