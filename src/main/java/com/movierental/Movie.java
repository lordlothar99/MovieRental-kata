package com.movierental;

public abstract class Movie {

	private final String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public abstract double getAmountOwed(int daysRented);

	public abstract boolean hasRenterBonusPoints();

}
