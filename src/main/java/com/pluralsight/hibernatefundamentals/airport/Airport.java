package com.pluralsight.hibernatefundamentals.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "AIRPORTS")
@Access(AccessType.FIELD)
public class Airport {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@OneToMany(mappedBy = "airport")
	private List<Passenger> passengers = new ArrayList<>();

	public Airport(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Airport() {
		super();
	}

	public List<Passenger> getPassengers(){
		return Collections.unmodifiableList(passengers);
	}
	
	public void addPassengers(Passenger passenger) {
		passengers.add(passenger);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
