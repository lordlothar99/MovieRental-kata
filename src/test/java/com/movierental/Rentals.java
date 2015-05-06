package com.movierental;

import java.util.ArrayList;
import java.util.Arrays;

public class Rentals extends ArrayList<Rental> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rentals(Rental[] rentals) {
		super(Arrays.asList(rentals));
	}

	@Override
	public String toString() {
		String sep = "";
		String string = "";
		for (Rental rental : this) {
			string += sep + rental.getMovie().getTitle() + "(" + rental.getDaysRented() + ")";
			sep = ",";
		}
		return string;
	}

	public Movie[] toMovies() {
		Movie[] movies = new Movie[this.size()];
		for (int i = 0; i < this.size(); i++) {
			Rental rental = this.get(i);
			movies[i] = rental.getMovie();
		}
		return movies;

	}
}
