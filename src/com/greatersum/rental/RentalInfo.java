package com.greatersum.rental;

import java.math.BigDecimal;
import java.util.HashMap;

public class RentalInfo {

    public String statement(Customer customer) {
        HashMap<String, Movie> movies = new HashMap();
        movies.put("F001", new Movie("Star Wars", "regular"));
        movies.put("F002", new Movie("Jurassic Park", "regular"));
        movies.put("F003", new Movie("Inside Out", "childrens"));
        movies.put("F004", new Movie("1917", "new"));

        BigDecimal totalAmount = BigDecimal.valueOf(0);
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + customer.getName() + "\n";
        for (MovieRental r : customer.getRentals()) {
            Movie movie = movies.get(r.getMovieId());
            BigDecimal thisAmount = BigDecimal.valueOf(0);

            // determine amount for each movie
            switch (movie.getCode()) {
                case "regular":
                    thisAmount = BigDecimal.valueOf(2.0);
                    if (r.getDays() > 2) {
                        thisAmount = BigDecimal.valueOf((r.getDays() - 1) * 1.5).add(thisAmount);
                    }
                    break;
                case "new":
                    thisAmount = BigDecimal.valueOf(r.getDays() * 3);
                    break;
                case "childrens":
                    thisAmount = BigDecimal.valueOf(1.5);
                    if (r.getDays() > 3) {
                        thisAmount = BigDecimal.valueOf((r.getDays() - 3) * 1.5).add(thisAmount);
                    }
                    break;
            }

            //add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (movie.getCode() == "new" && r.getDays() > 2) frequentRenterPoints++;

            //print figures for this rental
            result += "\t" + movie.getTitle() + "\t" + thisAmount + "\n";
            totalAmount = totalAmount.add(thisAmount);
        }
        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;
    }
}
