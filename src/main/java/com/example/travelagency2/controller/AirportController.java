package com.example.travelagency2.controller;

import com.example.travelagency.model.AirportModel;
import com.example.travelagency.service.AirportService;
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
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/{city}")
    public ResponseEntity<List<AirportModel>> getAirportsInCity(@PathVariable("city") String cityName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(airportService.findAirportByCity2(cityName));
    }
}
