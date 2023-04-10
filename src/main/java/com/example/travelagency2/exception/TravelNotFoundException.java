package com.example.travelagency2.exception;

public class TravelNotFoundException extends RuntimeException {
    public TravelNotFoundException(Long id) {
        super("Could not find any travel with this feature: " + id);
    }
}
