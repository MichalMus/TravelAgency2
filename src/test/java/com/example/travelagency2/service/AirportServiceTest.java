package com.example.travelagency2.service;

import com.example.travelagency2.model.AirportModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@WithMockUser
class AirportServiceTest {

    @Autowired
    private AirportService airportService;

    @Test
    void getAirportById() {
        //given

        //when
        Optional<AirportModel> airportById = airportService.getAirportById(1L);
        //then
        assertThat(airportById).isNotNull();
        assertThat(airportById.get().getAirPortName()).isEqualTo("lotniskoDzibutti");

    }
}