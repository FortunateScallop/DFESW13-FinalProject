package com.qa.finalProject.model;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarParking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String number_plate;
	@Column(nullable = false)
	private String make;
	@Column(nullable = false)
	private String model;
	@Column(nullable = false)
	private String colour;
	@Column(nullable = false)
	private float price;
	@Column(nullable = false)
	private boolean paid;
	// Add Session Start Date/Time and Session End Date/Time if poss.
	
	
	public CarParking() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor without ID
	public CarParking(String number_plate, String make, String model, String colour, float price, boolean paid) {
		super();
		this.number_plate = number_plate;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.paid = paid;
	}

	// Constructor with ID
	public CarParking(long id, String number_plate, String make, String model, String colour, float price,
			boolean paid) {
		super();
		this.id = id;
		this.number_plate = number_plate;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.paid = paid;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber_plate() {
		return number_plate;
	}

	public void setNumber_plate(String number_plate) {
		this.number_plate = number_plate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, make, model, number_plate, paid, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarParking other = (CarParking) obj;
		return Objects.equals(colour, other.colour) && Objects.equals(make, other.make)
				&& Objects.equals(model, other.model) && Objects.equals(number_plate, other.number_plate)
				&& paid == other.paid && Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}

	@Override
	public String toString() {
		return "CarParking [id=" + id + ", number_plate=" + number_plate + ", make=" + make + ", model=" + model
				+ ", colour=" + colour + ", price=" + price + ", paid=" + paid + "]";
	}
	
	
	
	
	
	
	
	
	


	

}
