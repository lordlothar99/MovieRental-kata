package com.movierental;

public class ChildrenMovie extends Movie {

	public ChildrenMovie(String title) {
		super(title);
	}

	@Override
	public double getAmountOwed(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 1.5;
		return thisAmount;
	}

	@Override
	public boolean hasRenterBonusPoints() {
		return false;
	}
}
