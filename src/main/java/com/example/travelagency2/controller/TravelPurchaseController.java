package com.example.travelagency2.controller;

import com.example.travelagency2.service.TravelPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/travelpurchase")
public class TravelPurchaseController {
    private final TravelPurchaseService travelPurchaseService;

}
