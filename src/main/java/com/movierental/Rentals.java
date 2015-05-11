package com.movierental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Rentals implements Iterable<Rental> {

	private final List<Rental> rentals;

	public Rentals() {
		super();
		rentals = new ArrayList<Rental>();
	}

	public Rentals(Rental[] rentals) {
		this.rentals = Arrays.asList(rentals);
	}

	@Override
	public String toString() {
		String sep = "";
		String string = "";
		for (Rental rental : rentals) {
			string += sep + rental.getMovie().getTitle() + "(" + rental.getDaysRented() + ")";
			sep = ",";
		}
		return string;
	}

	public String getRecord() {
		String rentalRecord = "";
		for (Rental rental : rentals) {
			rentalRecord += "\t" + rental + "\n";
		}
		return rentalRecord;
	}

	public int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental : rentals) {
			frequentRenterPoints++;

			if (rental.hasRenterBonusPoints()) {
				frequentRenterPoints++;
			}
		}
		return frequentRenterPoints;
	}

	public double getAmountOwed() {
		double amountOwed = 0;
		for (Rental rental : rentals) {
			amountOwed += rental.getAmountOwed();
		}
		return amountOwed;
	}

	public void add(Rental rental) {
		rentals.add(rental);
	}

	@Override
	public Iterator<Rental> iterator() {
		return rentals.iterator();
	}

}
