package com.movierental;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
	}

	@Override
	public double getAmountOwed(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public boolean hasRenterBonusPoints() {
		return true;
	}
}
