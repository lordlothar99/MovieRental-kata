package movierental;

import movierental.v1.Customer;
import movierental.v1.Movie;
import movierental.v1.Rental;

public class Main {
	public static void main(String[] args) {
		Movie movie = new Movie("Transformer", Movie.REGULAR);
		
		Rental rental = new Rental(movie, 3);
		
		Customer customer = new Customer("jpartogi");
		customer.addRental(rental);
		
		String statement = customer.statement();
		System.out.println(statement);
	}

}
