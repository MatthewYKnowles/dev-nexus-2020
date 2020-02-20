package com.greatersum.rental;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentalTests {

    private RentalInfo rentalReceipt;

    @Before
    public void setUp() throws Exception {
        rentalReceipt = new RentalInfo();
    }

    @Test
    public void MartinTest() {
        String receipt =
                "Rental Record for Martin\n" +
                "\tStar Wars\t5.0\n" +
                "\tJurassic Park\t2.0\n" +
                "Amount owed is 7.0\n" +
                "You earned 2 frequent renter points\n";
        List<MovieRental> rentals = Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1));
        Customer customer = new Customer("Martin", rentals);
        assertThat(rentalReceipt.statement(customer), is(receipt));
    }
}
