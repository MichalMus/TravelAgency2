package com.example.travelagency2.controller;

import com.example.travelagency.model.TravelModel;
import com.example.travelagency.model.Type;
import com.example.travelagency.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/travel")
public class TravelController {

    private final TravelService travelService;

    // dodać wyjątki
    @GetMapping("/promotion")
    public ResponseEntity<List<TravelModel>> getAllTravels() {
        return ResponseEntity.ok(travelService.findByPromotion());
    }

    @GetMapping("/near")
    public ResponseEntity<List<TravelModel>> getAllTrabyDates() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(travelService.findByStartDateAfterNow());
    }

    @GetMapping("near/continents")
    public ResponseEntity<List<TravelModel>> getAllTravelsByDatesOrderByContinents() {
        return ResponseEntity.ok(travelService.findByStartDateAfterNowOrderByContinent());
    }

    @GetMapping("near/countries")
    public ResponseEntity<List<TravelModel>> getAllTravelsByDatesOrderByCountries() {
        return ResponseEntity.ok(travelService.findByStartDateAfterNowOrderByCountry());
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<TravelModel>> getAllByCountry(@PathVariable("country") String countryName) {
        return ResponseEntity.ok(travelService.findTravelsByCountry(countryName));
    }

    @GetMapping("/airport/{airport}")
    public ResponseEntity<List<TravelModel>> getAllByAirport(@PathVariable("airport") String airport) {
        return ResponseEntity.ok(travelService.findTravelsByAirportName(airport));
    }

    @GetMapping("/hotel/{hotel}")
    public ResponseEntity<List<TravelModel>> getAllByHotel(@PathVariable("hotel") String hotel) {
        return ResponseEntity.ok(travelService.findTravelsByHotelName(hotel));
    }

    @GetMapping("/hoteltype/{type}")
    public ResponseEntity<List<TravelModel>> getAllByHotelType(@PathVariable("type") Type type) {
        return ResponseEntity.ok(travelService.findTravelsByHotelType(type));
    }


    //sprawdzić czy poprawić
    @GetMapping("/price/{id}")
    public ResponseEntity<Double> getTravelPrice(@PathVariable("id") Long id) {
        return ResponseEntity.ok(travelService.getPrice(id));
    }
}
