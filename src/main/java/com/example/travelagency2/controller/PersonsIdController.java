package com.example.travelagency2.controller;

import com.example.travelagency2.service.PersonsIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/personsid")
public class PersonsIdController {

    private final PersonsIdService personsIdService;
}
