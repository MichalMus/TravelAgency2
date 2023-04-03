package com.example.travelagency2.service;

import com.example.travelagency.model.CityModel;
import com.example.travelagency.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityModel> getAllCities() {
        return cityRepository.findAll();
    }

    public void addNewCity(CityModel cityModel) {
        cityRepository.save(cityModel);
    }

    public void deleteCityById(Long id){
        cityRepository.deleteById(id);
    }
}
