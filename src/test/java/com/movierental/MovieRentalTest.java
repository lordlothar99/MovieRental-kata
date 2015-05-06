package com.movierental;

import static com.movierental.AssertionBuilder.expectAmountOwed;
import static com.movierental.AssertionBuilder.movie;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MovieRentalTest {

	private static final Movie TRANSFORMERS = new Movie("Transformers", Movie.REGULAR);
	private static final Movie NEMO = new Movie("Nemo", Movie.CHILDRENS);
	private static final Movie DIE_HARD_4 = new Movie("Die Hard 4", Movie.NEW_RELEASE);

	private Customer customer;
	@Parameter(0)
	public Rentals rentals;
	@Parameter(1)
	public double amountOwed;
	@Parameter(2)
	public int points;

	@Parameters(name = "Amount owed={1}, points= {2} for rentals: {0}")
	public static Collection<Object[]> getRentalsAssertions() {
		return Arrays.asList(new Object[][] { //

				expectAmountOwed(3.5).andPoints(1).forRentals(//
						movie(TRANSFORMERS).during(3).days()), //

						expectAmountOwed(2).andPoints(1).forRentals(//
								movie(TRANSFORMERS).during(1).days()), //

						expectAmountOwed(1.5).andPoints(1).forRentals(//
								movie(NEMO).during(3).days()), //

						expectAmountOwed(9.0).andPoints(2).forRentals(//
								movie(DIE_HARD_4).during(3).days()), //

						expectAmountOwed(5).andPoints(2).forRentals(//
								movie(TRANSFORMERS).during(3).days(), //
								movie(NEMO).during(3).days()), //
				});
	}

	@Before
	public void setup() {
		customer = new Customer("Alice");
		for (Rental rental : rentals) {
			customer.addRental(rental);
		}
	}

	@Test
	public void should_customer_be_correct() {
		String statement = customer.statement();
		assertThat(statement, containsString("Rental Record for " + customer.getName() + "\n"));
	}

	@Test
	public void should_rented_movies_be_correct() {
		String statement = customer.statement();
		assertThat(statement, rentedMoviesAre(rentals.toMovies()));
	}

	@Test
	public void should_renter_points_be_correct() {
		String statement = customer.statement();
		assertThat(statement, containsString("You earned " + points + " frequent renter points"));
	}

	@Test
	public void should_amount_owed_be_correct() {
		String statement = customer.statement();

		// String expected = "Rental Record for Alice\n" + "\tTransformers\t3.5\n" +
		// "Amount owed is 3.5\n"
		// + "You earned 1 frequent renter points";
		// Assert.assertEquals(expected, statement);

		assertThat(statement, containsString("Amount owed is " + amountOwed + "\n"));
	}

	private static Matcher<String> rentedMoviesAre(Movie... movies) {
		Collection<Matcher<? super String>> movieMatchers = new ArrayList<>();
		for (Movie movie : movies) {
			movieMatchers.add(containsString("\t" + movie.getTitle() + "\t"));
		}
		return Matchers.allOf(movieMatchers);
	}
}
