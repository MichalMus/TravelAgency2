package com.example.travelagency2.service;

import com.example.travelagency2.model.CountryModel;
import com.example.travelagency2.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CountryService {

    private final CountryRepository countryRepository;


    public CountryService(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryModel> getAllCountries(){
        return countryRepository.findAll();
    }
    public void addNewCountry(CountryModel countryModel){
        countryRepository.save(countryModel);
    }

    public void deleteCountryById(Long id){
        countryRepository.deleteById(id);
    }

    public Optional<CountryModel> getCountryById(Long id) {
        return countryRepository.findById(id);
    }
}
