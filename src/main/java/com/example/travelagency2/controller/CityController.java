package com.example.travelagency2.controller;


import com.example.travelagency2.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;
}
