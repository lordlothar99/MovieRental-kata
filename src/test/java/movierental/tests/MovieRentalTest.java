package movierental.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import movierental.v1.Customer;
import movierental.v1.Movie;
import movierental.v1.Rental;

import org.junit.Test;

public class MovieRentalTest {

	@Test
	public void testStatement(){
		Movie movie = new Movie("Transformer", Movie.REGULAR);
		
		Rental rental = new Rental(movie, 3);
		
		Customer customer = new Customer("jpartogi");
		customer.addRental(rental);
		
		String statement = customer.statement();
		assertThat(statement, containsString("Transformer"));
	}
}
