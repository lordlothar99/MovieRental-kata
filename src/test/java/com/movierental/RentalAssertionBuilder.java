package com.movierental;

public class RentalAssertionBuilder {

	private double amountOwed;
	private int pointsEarned;

    public static RentalAssertionBuilder should() {
        return new RentalAssertionBuilder();
    }

	public RentalAssertionBuilder amountOwedEqual(double amountOwed) {
        this.amountOwed = amountOwed;
        return this;
	}

    public RentalAssertionBuilder pointsEarnedEqual(int pointsEarned) {
        this.pointsEarned = pointsEarned;
        return this;
    }

	public static RentalBuilder rentalOf(Movie movie) {
		return new RentalBuilder(movie);
	}

	public Object[] forRentals(Rental... rentals) {
		return new Object[] { new Rentals(rentals), amountOwed, pointsEarned };
	}

}
