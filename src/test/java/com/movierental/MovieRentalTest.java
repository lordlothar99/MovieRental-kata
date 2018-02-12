package com.movierental;

import static com.movierental.RentalAssertionBuilder.rentalOf;
import static com.movierental.RentalAssertionBuilder.should;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MovieRentalTest {

    private static final Movie TRANSFORMERS = new RegularMovie("Transformers");
    private static final Movie NEMO = new ChildrenMovie("Nemo");
    private static final Movie DIE_HARD_4 = new NewReleaseMovie("Die Hard 4");

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

                should().amountOwedEqual(2).pointsEarnedEqual(1).forRentals(//
                        rentalOf(TRANSFORMERS).during(1).days()), //

                should().amountOwedEqual(2).pointsEarnedEqual(1).forRentals(//
                        rentalOf(TRANSFORMERS).during(2).days()), //

                should().amountOwedEqual(3.5).pointsEarnedEqual(1).forRentals(//
                        rentalOf(TRANSFORMERS).during(3).days()), //

                should().amountOwedEqual(5).pointsEarnedEqual(1).forRentals(//
                        rentalOf(TRANSFORMERS).during(4).days()), //

                should().amountOwedEqual(1.5).pointsEarnedEqual(1).forRentals(//
                        rentalOf(NEMO).during(1).days()), //

                should().amountOwedEqual(1.5).pointsEarnedEqual(1).forRentals(//
                        rentalOf(NEMO).during(2).days()), //

                should().amountOwedEqual(1.5).pointsEarnedEqual(1).forRentals(//
                        rentalOf(NEMO).during(3).days()), //

                should().amountOwedEqual(3).pointsEarnedEqual(1).forRentals(//
                        rentalOf(NEMO).during(4).days()), //

                should().amountOwedEqual(4.5).pointsEarnedEqual(1).forRentals(//
                        rentalOf(NEMO).during(5).days()), //

                should().amountOwedEqual(3).pointsEarnedEqual(1).forRentals(//
                        rentalOf(DIE_HARD_4).during(1).days()), //

                should().amountOwedEqual(6).pointsEarnedEqual(2).forRentals(//
                        rentalOf(DIE_HARD_4).during(2).days()), //

                should().amountOwedEqual(9).pointsEarnedEqual(2).forRentals(//
                        rentalOf(DIE_HARD_4).during(3).days()), //

                should().amountOwedEqual(5).pointsEarnedEqual(2).forRentals(//
                        rentalOf(TRANSFORMERS).during(3).days(), //
                        rentalOf(NEMO).during(3).days()), //

                should().amountOwedEqual(32).pointsEarnedEqual(4).forRentals(//
                        rentalOf(TRANSFORMERS).during(7).days(), //
                        rentalOf(NEMO).during(5).days(), //
                        rentalOf(DIE_HARD_4).during(6).days()), //
        });
    }

    @Before
    public void setup() {
        customer = new Customer("Alice");
        for (Rental rental : rentals) {
            customer.addRental(rental);
        }
        System.out.println(customer.getRentalsRecord());
    }

    @Test
    public void should_customer_name_be_the_one_who_rented_movies() {
        String statement = customer.getRentalsRecord();
        assertThat(statement, containsString("Rental Record for " + customer.getName() + "\n"));
    }

    @Test
    public void should_rented_movies_names_be_those_which_were_rented() {
        String statement = customer.getRentalsRecord();
        for (Rental rental : rentals) {
            assertThat(statement, containsString("\t" + rental.getMovie().getTitle() + "\t"));
        }
    }

    @Test
    public void should_renter_points_be_well_calculated() {
        String statement = customer.getRentalsRecord();
        assertThat(statement, containsString("You earned " + points + " frequent renter points"));
    }

    @Test
    public void should_amount_owed_be_well_calculated() {
        String statement = customer.getRentalsRecord();
        assertThat(statement, containsString("Amount owed is " + amountOwed + "\n"));
    }
}
