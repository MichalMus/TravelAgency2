package com.example.travelagency2.controller;

import com.example.travelagency2.model.CountryModel;
import com.example.travelagency2.service.CountryService;
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
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/allCountries")
    public ResponseEntity<List<CountryModel>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<CountryModel>> getCountryById(@PathVariable("id") Long id) {
        final Optional<CountryModel> countryModel = countryService.getCountryById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(countryModel);
    }

    @PostMapping("/addCountry")
    public ResponseEntity addNewContinent(@RequestBody CountryModel countryModel) {
        countryService.addNewCountry(countryModel);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/deleteCountry/{id}")
    public ResponseEntity deleteCountry(@PathVariable("id") Long id) {
        try {
            countryService.deleteCountryById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) { //spradzić czy dobrze zapisane tre wyjątki
            e.printStackTrace();
//            throw new TravelNotFoundException(id);  tutaj zmienić stworzyć nową klasę wyjątku
        }
        return null;
    }

    @PostMapping("/id/{id}")
    public ResponseEntity<CountryModel> postCountryById(@PathVariable("id") Long id, @RequestBody CountryModel countryModel) {
        countryService.addNewCountry(countryModel);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

}

}
