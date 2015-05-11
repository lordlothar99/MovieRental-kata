package com.movierental;

public class RegularMovie extends Movie {

	public RegularMovie(String title) {
		super(title);
	}

	@Override
	public double getAmountOwed(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2)
			thisAmount += (daysRented - 2) * 1.5;
		return thisAmount;
	}

	@Override
	public boolean hasRenterBonusPoints() {
		return false;
	}
}
