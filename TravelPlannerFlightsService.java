package com.jap.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TravelPlannerFlightsService {

    private List<Flight> flights;

    // Constructor
    public TravelPlannerFlightsService() {
        // Initialize the flights list
        this.flights = new ArrayList<>();
    }

    // Method to add a flight
    public void addFlight(Flight flight) {
        // Add the provided flight to the flights list
        flights.add(flight);
    }

    // Method to remove a flight
    public boolean removeFlight(String flightId) {
        // Remove the flight with the specified id from the flights list if present
        return flights.removeIf(flight -> flight.getId().equals(flightId));
    }

    // Method to get all flights
    public List<Flight> getFlights() {
        // Return all flights in the flights list
        return new ArrayList<>(flights);
    }

    // Method to filter flights based on predicate
    public List<Flight> filterFlights(Predicate<Flight> predicate) {
        // Use Streams to filter flights based on the provided predicate and return the filtered list
        return flights.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }


    // Method to sort flights using comparators
    public List<Flight> sortFlights(Comparator<Flight> comparator) {
        // Sort flights using the provided comparator and return the sorted list
        List<Flight> sortedFlights = new ArrayList<>(flights);
        sortedFlights.sort(comparator);
        return sortedFlights;
    }

    // Comparator for sorting flights by ticket price
    public Comparator<Flight> sortByTicketPrice() {
        // Implement comparator logic here
        return Comparator.comparingDouble(Flight::getPrice);
    }

    // Comparator for sorting flights by departure time
    public Comparator<Flight> sortByDepartureTime() {
        // Implement comparator logic here
        return Comparator.comparing(Flight::getDepartureAirport);
    }

    // Comparator for sorting flights by arrival time
    public Comparator<Flight> sortByArrivalTime() {
        // Implement comparator logic here
        return Comparator.comparing(Flight::getArrivalAirport);
    }
}
