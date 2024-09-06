package com.pluralsight.hibernatefundamentals.airport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TICKETS")
public class Ticket {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NUMBER")
	private String number;
	
	@ManyToOne
	@JoinColumn(name = "PASSENGER_ID")
	private Passenger passenger;

	public Ticket(int id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Ticket() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
}
