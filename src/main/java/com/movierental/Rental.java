package com.movierental;

public class Rental {
	private final Movie movie;
	private final int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double getAmountOwed() {
		return movie.getAmountOwed(getDaysRented());
	}

	public boolean hasRenterBonusPoints() {
		return movie.hasRenterBonusPoints() && getDaysRented() > 1;
	}

	@Override
	public String toString() {
		return movie.getTitle() + "\t" + movie.getAmountOwed(getDaysRented());
	}
}
