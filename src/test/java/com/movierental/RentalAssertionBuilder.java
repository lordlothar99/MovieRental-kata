package com.movierental;

public class RentalAssertionBuilder {

	private final double amountOwed;
	private int pointsEarned;

	public RentalAssertionBuilder(double amountOwed) {
		this.amountOwed = amountOwed;
	}

	public static RentalAssertionBuilder expectAmountOwed(double amountOwed) {
		return new RentalAssertionBuilder(amountOwed);
	}

	public static RentalBuilder rentalOf(Movie movie) {
		return new RentalBuilder(movie);
	}

	public Object[] forRentals(Rental... rentals) {
		return new Object[] { new Rentals(rentals), amountOwed, pointsEarned };
	}

	public RentalAssertionBuilder andPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
		return this;
	}

}
