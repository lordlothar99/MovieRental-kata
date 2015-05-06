package com.movierental;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.movierental.Customer;
import com.movierental.Movie;
import com.movierental.Rental;

public class MovieRentalTest {

	@Test
	public void testStatement() {
		Movie movie = new Movie("Transformer", Movie.REGULAR);

		Rental rental = new Rental(movie, 3);

		Customer customer = new Customer("Alice");
		customer.addRental(rental);

		String statement = customer.statement();
		assertThat(statement, containsString("Transformer"));
	}
}
