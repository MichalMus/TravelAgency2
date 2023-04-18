package com.example.travelagency2.controller;

import com.example.travelagency2.model.HotelModel;
import com.example.travelagency2.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/{city}")
    public ResponseEntity<List<HotelModel>> getHotelsInCity(@PathVariable("city") String cityName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelService.findAllHotelsInCity(cityName));
    }

    @GetMapping("/allHotels")
    public ResponseEntity<List<HotelModel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<HotelModel>> findHotelById(@PathVariable("id") Long id) {
        final Optional<HotelModel> hotelModel = hotelService.findHotelById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelModel);
    }

    @PostMapping("/addHotel")
    public ResponseEntity addNewHotel(@RequestBody HotelModel hotelModel) {
        hotelService.addNewHotel(hotelModel);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/deleteHotel/{id}")
    public ResponseEntity deleteHotel(@PathVariable("id") Long id) {
        try {
            hotelService.deleteHotelById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) { //spradzić czy dobrze zapisane tre wyjątki
            e.printStackTrace();
//            throw new TravelNotFoundException(id);  tutaj zmienić stworzyć nową klasę wyjątku
        }
        return null;
    }

    @PostMapping("/id/{id}")
    public ResponseEntity<HotelModel> postHotelById(@PathVariable("id") Long id, @RequestBody HotelModel hotelModel) {
        hotelService.addNewHotel(hotelModel);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }




}

