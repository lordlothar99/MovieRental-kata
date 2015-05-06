package com.movierental;

public class AssertionBuilder {

	private final double amountOwed;
	private int points;

	public AssertionBuilder(double amountOwed) {
		this.amountOwed = amountOwed;
	}

	public static AssertionBuilder expectAmountOwed(double amountOwed) {
		return new AssertionBuilder(amountOwed);
	}

	public static RentalBuilder movie(Movie movie) {
		return new RentalBuilder(movie);
	}

	public Object[] forRentals(Rental... rentals) {
		return new Object[] { new Rentals(rentals), amountOwed, points };
	}

	public AssertionBuilder andPoints(int points) {
		this.points = points;
		return this;
	}

}
