package com.movierental;

public class Customer {
	private final String name;
	final Rentals rentals = new Rentals();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return this.name;
	}

	public String getRentalsRecord() {
		String rentalRecord = "Rental Record for " + getName() + "\n";
		rentalRecord += rentals.getRecord();
		rentalRecord += "Amount owed is " + rentals.getAmountOwed() + "\n";
		rentalRecord += "You earned " + rentals.getFrequentRenterPoints() + " frequent renter points";
		return rentalRecord;
	}
}