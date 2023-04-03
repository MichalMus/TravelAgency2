package com.example.travelagency2.controller;

import com.example.travelagency.service.ContinentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/continent")
public class ContinentController {

    private final ContinentService continentService;
}
