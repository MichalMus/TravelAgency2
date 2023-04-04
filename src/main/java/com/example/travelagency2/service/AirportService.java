package com.example.travelagency2.service;

import com.example.travelagency2.model.AirportModel;
import com.example.travelagency2.repository.AirportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(final AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportModel> getAllAirports() {
        return airportRepository.findAll();
    }

    public void addAirport(AirportModel airportModel) {
        airportRepository.save(airportModel);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    public List<AirportModel> findAirportByCity2(String city){
        return airportRepository.findAllByCityModel_CityNameEqualsIgnoreCase(city);
    }

}
