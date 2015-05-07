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
}
