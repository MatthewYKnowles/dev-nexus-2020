package com.greatersum.rental;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RentalTests1 {
    private RentalInfo rentalReceipt;

    @Before
    public void setUp() throws Exception {
        rentalReceipt = new RentalInfo();
    }

    @Ignore
    @Test
    public void rentTwoRegularMovies() {
        String expectedReceipt =
                "Rental Record for Martin\n" +
                        "\tStar Wars\t5.0\n" +
                        "\tJurassic Park\t2.0\n" +
                        "Amount owed is 7.0\n" +
                        "You earned 2 frequent renter points\n";
        List<MovieRental> rentals = Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1));
        Customer customer = new Customer("Martin", rentals);
        String receipt = rentalReceipt.statement(customer);
        assertThat(receipt, is(expectedReceipt));
    }

    @Ignore
    @Test
    public void rentANewAndChildrensMovie() {
        String expectedReceipt =
                "Rental Record for Martin\n" +
                        "\tInside Out\t4.5\n" +
                        "\t1917\t15\n" +
                        "Amount owed is 19.5\n" +
                        "You earned 3 frequent renter points\n";
        List<MovieRental> rentals = Arrays.asList(new MovieRental("F003", 5), new MovieRental("F004", 5));
        Customer customer = new Customer("Martin", rentals);
        String receipt = rentalReceipt.statement(customer);
        assertThat(receipt, is(expectedReceipt));
    }
}
