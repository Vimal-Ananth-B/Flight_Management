package com.jap.lambdas;

import java.util.Comparator;

public class TravelOptionComparator {

    //Comparator for sorting travel options by flight ticket price.
    public static <T> Comparator<Flight> sortByFlightTicketPrice() {
        // Implement comparator logic here
        return Comparator.comparingDouble(Flight::getPrice);
    }

    // Comparator for sorting travel options by accommodation price per night.
    public static <T> Comparator<Accommodation> sortByAccommodationPricePerNight() {
        // Implement comparator logic here

        return Comparator.comparingDouble(Accommodation::getPricePerNight); // Placeholder, replace with actual implementation
    }

    // Comparator for sorting travel options by ratings (either flight or accommodation)
    public static <T> Comparator<T> sortByRatings() {
        // Implement comparator logic here
        return (o1,o2)->{
            if(o1 instanceof Flight && o2 instanceof Flight)
            {
                Flight f1 = (Flight) o1;
                Flight f2 = (Flight) o2;
                return Double.compare(f2.getRatings(),f1.getRatings());//Desc
            } else if (o1 instanceof Accommodation && o2 instanceof Accommodation) {
                Accommodation a1 = (Accommodation) o1;
                Accommodation a2 = (Accommodation) o2;
                return Double.compare(a2.getRatings(),a1.getRatings()); //Desc
            }
            else {
                throw new IllegalArgumentException("Not Compatible");
            }
        };
    }

}
