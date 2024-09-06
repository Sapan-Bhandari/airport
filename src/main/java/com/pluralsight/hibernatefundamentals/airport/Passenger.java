package com.pluralsight.hibernatefundamentals.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "AIRPORT_ID")
	private Airport airport;
	
	@OneToMany(mappedBy = "passenger")
	private List<Ticket> tickets = new ArrayList<>();

	public Passenger(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Passenger() {
		super();
	}

	public List<Ticket> getTickets(){
		return Collections.unmodifiableList(tickets);
	}
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	
	
}