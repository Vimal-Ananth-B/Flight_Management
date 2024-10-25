package com.jap.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.List;

/**
 * Main class for demonstrating travel planner functionalities.
 */
public class TravelPlannerMainDemo {

    public static void main(String[] args) {
        TravelPlannerServiceAccommodation travelPlannerService = initializeTravelPlannerService();
        TravelPlannerFlightsService travelPlannerServiceFlights = initializeTravelPlannerServiceFlight();

        printAllFlights(travelPlannerServiceFlights);
        filterAndPrintFlights(travelPlannerServiceFlights);
        sortByPriceAndPrintFlights(travelPlannerServiceFlights);
        sortByRatingAndPrintFlights(travelPlannerServiceFlights);
        removeFlightAndPrintFlights(travelPlannerServiceFlights);

        printAllAccommodation(travelPlannerService);
        filterAndPrintAccommodation(travelPlannerService);
        sortByPriceAndPrintAccommodation(travelPlannerService);
        sortByRatingAndPrintAccommodation(travelPlannerService);
        filterAccommodationsByAmenity(travelPlannerService, "Pool");
    }

    // Method to initialize TravelPlannerFlightsService
    private static TravelPlannerFlightsService initializeTravelPlannerServiceFlight() {
        TravelPlannerFlightsService travelPlannerServiceFlights = new TravelPlannerFlightsService();
        // Initialize flights
        travelPlannerServiceFlights.addFlight(new Flight("F1", "Airline1", "Departure1", "Arrival1", 200.0, 4.5));
        travelPlannerServiceFlights.addFlight(new Flight("F2", "Airline2", "Departure2", "Arrival2", 300.0, 4.2));
        travelPlannerServiceFlights.addFlight(new Flight("F3", "Airline3", "Departure3", "Arrival3", 250.0, 5.0));
        travelPlannerServiceFlights.addFlight(new Flight("F4", "Airline4", "Departure4", "Arrival4", 450.0, 3.5));
        travelPlannerServiceFlights.addFlight(new Flight("F5", "Airline5", "Departure5", "Arrival5", 150.0, 4.0));
        return travelPlannerServiceFlights;
    }

    // Method to initialize TravelPlannerServiceAccommodation
    private static TravelPlannerServiceAccommodation initializeTravelPlannerService() {
        TravelPlannerServiceAccommodation travelPlannerServiceAccommodation = new TravelPlannerServiceAccommodation();
        // Add accommodations
        travelPlannerServiceAccommodation.addAccommodation(new Accommodation("A1", "Hotel1", "Location1", 200.0, 4.5, Arrays.asList("Pool", "WiFi")));
        travelPlannerServiceAccommodation.addAccommodation(new Accommodation("A2", "Hotel2", "Location2", 150.0, 4.2, Arrays.asList("WiFi")));
        travelPlannerServiceAccommodation.addAccommodation(new Accommodation("A3", "Hotel3", "Location3", 300.0, 5.0, Arrays.asList("Pool", "Gym")));
        travelPlannerServiceAccommodation.addAccommodation(new Accommodation("A4", "Hotel4", "Location4", 400.0, 3.5, Arrays.asList("WiFi", "Breakfast")));
        travelPlannerServiceAccommodation.addAccommodation(new Accommodation("A5", "Hotel5", "Location5", 350.0, 4.0, Arrays.asList("Pool", "WiFi", "Breakfast")));
        return travelPlannerServiceAccommodation;
    }

    // Method to print all flights
    public static void printAllFlights(TravelPlannerFlightsService travelPlannerServiceFlights) {
        System.out.println("All Flights:");
        List<Flight> flights = travelPlannerServiceFlights.getFlights();
        flights.forEach(System.out::println);
    }

    // Method to filter and print flights with price less than 300
    public static void filterAndPrintFlights(TravelPlannerFlightsService travelPlannerServiceFlights) {
        System.out.println("\nFlights with Price less than 300:");
        List<Flight> filteredFlights = travelPlannerServiceFlights.filterFlights(flight -> flight.getPrice() < 300);
        filteredFlights.forEach(System.out::println);
    }

    // Method to sort flights by price and print
    public static void sortByPriceAndPrintFlights(TravelPlannerFlightsService travelPlannerServiceFlights) {
        System.out.println("\nFlights Sorted by Price:");
        List<Flight> sortedFlights = travelPlannerServiceFlights.sortFlights(Comparator.comparingDouble(Flight::getPrice));
        sortedFlights.forEach(System.out::println);
    }

    // Method to sort flights by rating and print
    public static void sortByRatingAndPrintFlights(TravelPlannerFlightsService travelPlannerServiceFlights) {
        System.out.println("\nFlights Sorted by Rating:");
        List<Flight> sortedFlights = travelPlannerServiceFlights.sortFlights(TravelOptionComparator.sortByRatings());
        sortedFlights.forEach(System.out::println);
    }

    // Method to remove a flight and print updated list
    // Method to remove a flight and print updated list
    public static void removeFlightAndPrintFlights(TravelPlannerFlightsService travelPlannerServiceFlights){
        System.out.println("Remove flight with Flight no");
        // Remove a flight and display updated list
        boolean found = travelPlannerServiceFlights.removeFlight("F1");
        if(found)
        {
            System.out.println("true");
        }
        else
            System.out.println("false");
    }

    // Method to print all accommodations
    public static void printAllAccommodation(TravelPlannerServiceAccommodation travelPlannerService) {
        System.out.println("All Accommodation:");
        List<Accommodation> accommodations = travelPlannerService.getAccommodations();
        accommodations.forEach(System.out::println);
    }

    // Method to filter and print accommodations with price less than 300
    public static void filterAndPrintAccommodation(TravelPlannerServiceAccommodation travelPlannerService) {
        System.out.println("\nAccommodation with Price less than 300:");
        List<Accommodation> filteredAccommodations = travelPlannerService.filterAccommodations(accommodation -> accommodation.getPricePerNight() < 300);
        filteredAccommodations.forEach(System.out::println);
    }

    // Method to sort accommodations by price and print
    public static void sortByPriceAndPrintAccommodation(TravelPlannerServiceAccommodation travelPlannerService) {
        System.out.println("\nAccommodation Sorted by Price:");
        List<Accommodation> sortedAccommodations = travelPlannerService.sortAccommodations(Comparator.comparingDouble(Accommodation::getPricePerNight));
        sortedAccommodations.forEach(System.out::println);
    }

    // Method to sort accommodations by rating and print
    public static void sortByRatingAndPrintAccommodation(TravelPlannerServiceAccommodation travelPlannerService) {
        System.out.println("\nAccommodation Sorted by Rating:");
        List<Accommodation> sortedAccommodations = travelPlannerService.sortAccommodations(TravelOptionComparator.sortByRatings());
        sortedAccommodations.forEach(System.out::println);
    }

    // Method to filter accommodations by amenity and print
    public static void filterAccommodationsByAmenity(TravelPlannerServiceAccommodation travelPlannerService, String amenity) {
        System.out.println("Accommodations with " + amenity + " amenity:");
        List<Accommodation> filteredAccommodations = travelPlannerService.filterAccommodationsByAmenity(amenity);
        filteredAccommodations.forEach(System.out::println);
    }
}
