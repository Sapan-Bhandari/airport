package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Airport;
import com.pluralsight.hibernatefundamentals.airport.Passenger;
import com.pluralsight.hibernatefundamentals.airport.Ticket;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Airport airport = new Airport(1, "Heathrow Airport");
		
		Passenger sapan = new Passenger(1, "Sapan Bhandari");
		Passenger john = new Passenger(2, "John Smith");
		
		sapan.setAirport(airport);
		john.setAirport(airport);
		
		airport.addPassengers(sapan);
		airport.addPassengers(john);
		
		Ticket ticket1 = new Ticket(1, "AA1234");
		Ticket ticket2 = new Ticket(2, "BB5678");
		
		ticket1.setPassenger(sapan);
		ticket2.setPassenger(sapan);
		sapan.addTicket(ticket1);
		sapan.addTicket(ticket2);
		
		Ticket ticket3 = new Ticket(3, "CC0987");
		ticket3.setPassenger(john);
		john.addTicket(ticket3);
		
		em.persist(airport);
		em.persist(sapan);
		em.persist(john);
		
		em.persist(ticket1);
		em.persist(ticket2);
		em.persist(ticket3);
		
		em.getTransaction().commit();
		
		emf.close();

	}

}
