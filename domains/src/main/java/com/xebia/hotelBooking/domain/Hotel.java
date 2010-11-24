package com.xebia.hotelBooking.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Hotel implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8605076356962958680L;


	private int id;
	
	private String description;
	
	private City city;
	
	private String name;
	
	private String rating ;

	private int isBooked; 
	
	/**
	 * @return the isBooked
	 */

	/**
	 * @return the isBooked
	 */
	public int getIsBooked() {
		return isBooked;
	}

	/**
	 * @param isBooked the isBooked to set
	 */
	public void setIsBooked(int isBooked) {
		this.isBooked = isBooked;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@Cascade(value = { CascadeType.ALL })
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
}

