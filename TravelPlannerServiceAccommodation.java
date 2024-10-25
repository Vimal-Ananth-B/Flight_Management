package com.jap.lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TravelPlannerServiceAccommodation {

    private List<Accommodation> accommodations;

    // Constructor
    public TravelPlannerServiceAccommodation() {
        // Initialize the accommodations list
        this.accommodations = new ArrayList<>();
    }

    // Method to add an accommodation
    public void addAccommodation(Accommodation accommodation) {
        // Add the provided accommodation to the accommodations list
        this.accommodations.add(accommodation);
    }

    // Method to remove an accommodation by id
    public boolean removeAccommodation(String accommodationId) {
        // Remove the accommodation with the specified id from the accommodations list
        return this.accommodations.removeIf(accommodation -> accommodation.getId().equals(accommodationId));
    }

    // Method to get all accommodations
    public List<Accommodation> getAccommodations() {
        // Return all accommodations in the accommodations list
        return new ArrayList<>(this.accommodations);
    }

    // Method to filter accommodations based on a predicate
    public List<Accommodation> filterAccommodations(Predicate<Accommodation> predicate) {
        // Filter accommodations based on the provided predicate and return the filtered list
        return this.accommodations.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    // Method to sort accommodations using a comparator
    public List<Accommodation> sortAccommodations(Comparator<Accommodation> comparator) {
        // Sort accommodations using the provided comparator and return the sorted list
        return this.accommodations.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    // Method to filter accommodations by amenity
    public List<Accommodation> filterAccommodationsByAmenity(String amenity) {
        // Create a predicate to check if the accommodation has the specified amenity
        Predicate<Accommodation> hasAmenity = accommodation -> accommodation.getAmenities().contains(amenity);

        // Filter accommodations based on the amenity predicate and return the filtered list
        return this.accommodations.stream()
                .filter(hasAmenity)
                .collect(Collectors.toList());
    }
}
