package com.example.travelagency2.controller;


import com.example.travelagency2.model.CityModel;
import com.example.travelagency2.service.CityService;
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
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @GetMapping("/allCities")
    public ResponseEntity<List<CityModel>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<CityModel>> getCityById(@PathVariable("id") Long id) {
        final Optional<CityModel> cityModel = cityService.getCityById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cityModel);
    }

    @PostMapping("/addCity")
    public ResponseEntity addNewCity(@RequestBody CityModel cityModel) {
        cityService.addNewCity(cityModel);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") Long id) {
        try {
            cityService.deleteCityById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) { //spradzić czy dobrze zapisane tre wyjątki
            e.printStackTrace();
//            throw new TravelNotFoundException(id);  tutaj zmienić stworzyć nową klasę wyjątku
        }
        return null;
    }


    // zapytać, która z metod będzie lepsza
//    @PostMapping("/id/{id}")
//    public ResponseEntity<CityModel> postCityById(@PathVariable("id") Long id, @RequestBody CityModel cityModel) {
//        cityService.addNewCity(cityModel);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
//    }

    @PostMapping("/id")
    public ResponseEntity<CityModel> postCityById(UriComponentsBuilder builder, @RequestBody CityModel cityModel) {
        Long cityId = cityModel.getId();
        UriComponents uriComponents = builder.path("/{id}").buildAndExpand(cityId);
        cityService.addNewCity(cityModel);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }


}
