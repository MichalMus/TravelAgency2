package com.example.travelagency2.controller;

import com.example.travelagency2.model.DateDTO;
import com.example.travelagency2.model.TravelModel;
import com.example.travelagency2.model.Type;
import com.example.travelagency2.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
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

    @GetMapping("near/between")
    public ResponseEntity<List<TravelModel>> getAllTravelsNearThisDate(@RequestBody DateDTO dateDTO) {
        return ResponseEntity.ok(travelService.findTravelsByStartDateIsNear(dateDTO.getDate1(), dateDTO.getDate2()));
    }
    @GetMapping("near/{date1}/{date2}")
    public ResponseEntity<List<TravelModel>> getAllTravelsNearThisDate(@PathVariable("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1, @PathVariable("date2")  @DateTimeFormat(pattern = "yyyy-MM-dd")Date date2) {
        return ResponseEntity.ok(travelService.findTravelsByStartDateIsNear(date1,date2));
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
    @GetMapping("endDate/between")
    public ResponseEntity<List<TravelModel>> getAllTravelsNearThisEndDate(@RequestBody DateDTO dateDTO) {
        return ResponseEntity.ok(travelService.findTravelsByEndDateIsNear(dateDTO.getDate1(), dateDTO.getDate2()));
    }
    @GetMapping("endDate/{date1}/{date2}")
    public ResponseEntity<List<TravelModel>> getAllTravelsNearThisEndDate(@PathVariable("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1, @PathVariable("date2")  @DateTimeFormat(pattern = "yyyy-MM-dd")Date date2) {
        return ResponseEntity.ok(travelService.findTravelsByEndDateIsNear(date1,date2));
    }

    @GetMapping("hotelStars/{stars}")
    public ResponseEntity<List<TravelModel>> getAllTravelsByHotelStars(@PathVariable("stars") Byte stars) {
        return ResponseEntity.ok(travelService.findTravelsByHotelStars(stars));
    }

}
