package com.movierental;

public class RentalAssertionBuilder {

	private final double amountOwed;
	private int points;

	public RentalAssertionBuilder(double amountOwed) {
		this.amountOwed = amountOwed;
	}

	public static RentalAssertionBuilder expectAmountOwed(double amountOwed) {
		return new RentalAssertionBuilder(amountOwed);
	}

	public static RentalBuilder rent(Movie movie) {
		return new RentalBuilder(movie);
	}

	public Object[] forRentals(Rental... rentals) {
		return new Object[] { new Rentals(rentals), amountOwed, points };
	}

	public RentalAssertionBuilder andPoints(int points) {
		this.points = points;
		return this;
	}

}
