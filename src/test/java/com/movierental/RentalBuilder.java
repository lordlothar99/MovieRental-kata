package com.movierental;

public class RentalBuilder {

	private final Movie movie;
	private int daysRented;

	public RentalBuilder(Movie movie) {
		this.movie = movie;
	}

	public RentalBuilder during(int daysRented) {
		this.daysRented = daysRented;
		return this;
	}

	public Rental days() {
		return new Rental(movie, daysRented);
	}

}
