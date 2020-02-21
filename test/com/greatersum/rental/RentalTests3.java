package com.greatersum.rental;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentalTests3 {

    private RentalInfo rentalReceipt;

    @Before
    public void setUp() throws Exception {
        rentalReceipt = new RentalInfo();
    }

    @Ignore
    @Test
    public void rentTwoRegularMovies() {
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

    @Ignore
    @Test
    public void rentAChildrensMovieForOneDay() {
        String receipt =
                "Rental Record for Martin\n" +
                        "\tInside Out\t1.5\n" +
                        "Amount owed is 1.5\n" +
                        "You earned 1 frequent renter points\n";
        List<MovieRental> rentals = Collections.singletonList(new MovieRental("F003", 1));
        Customer customer = new Customer("Martin", rentals);
        assertThat(rentalReceipt.statement(customer), is(receipt));
    }

    @Ignore
    @Test
    public void rentAChildrensMovieForFiveDays() {
        String receipt =
                "Rental Record for Martin\n" +
                        "\tInside Out\t4.5\n" +
                        "Amount owed is 4.5\n" +
                        "You earned 1 frequent renter points\n";
        List<MovieRental> rentals = Collections.singletonList(new MovieRental("F003", 5));
        Customer customer = new Customer("Martin", rentals);
        assertThat(rentalReceipt.statement(customer), is(receipt));
    }

    @Ignore
    @Test
    public void rentTwoNewMoviesForOneAndFiveDays() {
        String receipt =
                "Rental Record for Martin\n" +
                        "\t1917\t3\n" +
                        "\t1917\t15\n" +
                        "Amount owed is 18\n" +
                        "You earned 3 frequent renter points\n";
        List<MovieRental> rentals = Arrays.asList(new MovieRental("F004", 1), new MovieRental("F004", 5));
        Customer customer = new Customer("Martin", rentals);
        assertThat(rentalReceipt.statement(customer), is(receipt));
    }

    @Ignore
    @Test
    public void rentOneNewMoviesForThreeDays() {
        String receipt =
                "Rental Record for Martin\n" +
                        "\t1917\t9\n" +
                        "Amount owed is 9\n" +
                        "You earned 2 frequent renter points\n";
        List<MovieRental> rentals = Collections.singletonList(new MovieRental("F004", 3));
        Customer customer = new Customer("Martin", rentals);
        assertThat(rentalReceipt.statement(customer), is(receipt));
    }

    @Ignore
    @Test
    public void rentOneNewMoviesForTwoDays() {
        String receipt =
                "Rental Record for Martin\n" +
                        "\t1917\t6\n" +
                        "Amount owed is 6\n" +
                        "You earned 1 frequent renter points\n";
        List<MovieRental> rentals = Collections.singletonList(new MovieRental("F004", 2));
        Customer customer = new Customer("Martin", rentals);
        assertThat(rentalReceipt.statement(customer), is(receipt));
    }

    @Ignore
    @Test
    public void rentOneRegularMovieForTwoDays() {
        String receipt =
                "Rental Record for Martin\n" +
                        "\tStar Wars\t2.0\n" +
                        "Amount owed is 2.0\n" +
                        "You earned 1 frequent renter points\n";
        List<MovieRental> rentals = Collections.singletonList(new MovieRental("F001", 2));
        Customer customer = new Customer("Martin", rentals);
        assertThat(rentalReceipt.statement(customer), is(receipt));
    }
}
