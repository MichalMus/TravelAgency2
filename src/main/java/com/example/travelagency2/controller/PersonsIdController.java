package com.example.travelagency2.controller;

import com.example.travelagency2.model.PersonsIdModel;
import com.example.travelagency2.service.PersonsIdService;
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
@RequestMapping("/personsid")
public class PersonsIdController {

    private final PersonsIdService personsIdService;
    @GetMapping("/allPersons")
    public ResponseEntity<List<PersonsIdModel>> getAllPersons() {
        return ResponseEntity.ok(personsIdService.getAllPersonsIdList());

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<PersonsIdModel>> getPersonById(@PathVariable("id") Long id) {
        final Optional<PersonsIdModel> personsIdModel = personsIdService.findPersonById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personsIdModel);
    }

    @PostMapping("/addPerson")
    public ResponseEntity addNewPerson(@RequestBody PersonsIdModel personsIdModel) {
        personsIdService.addNewPersonsId(personsIdModel);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personsIdModel);
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id) {
        try {
            personsIdService.deletePersonsIdById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) { //spradzić czy dobrze zapisane tre wyjątki
            e.printStackTrace();
//            throw new TravelNotFoundException(id);  tutaj zmienić stworzyć nową klasę wyjątku
        }
        return null;
    }


    @PostMapping("/id/{id}")
    public ResponseEntity<PersonsIdModel> postPersonById(@PathVariable("id") Long id, @RequestBody PersonsIdModel personsIdModel) {
        personsIdService.addNewPersonsId(personsIdModel);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personsIdModel);
    }

    @GetMapping("/surname/{surname}")
    public ResponseEntity<List<PersonsIdModel>> getAllPersonsBySurname(@PathVariable("surname") String surname) {
        return ResponseEntity.ok(personsIdService.findPersonsBySurname(surname));

    }

}
