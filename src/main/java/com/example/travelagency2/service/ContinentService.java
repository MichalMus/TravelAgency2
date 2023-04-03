package com.example.travelagency2.service;

import com.example.travelagency.model.ContinentModel;
import com.example.travelagency.repository.ContinentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class ContinentService {
    private final ContinentRepository continentRepository;


    public ContinentService(final ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public List<ContinentModel> getAllContinents() {
        return continentRepository.findAll();
    }

    public void addNewContinent(ContinentModel continentModel) {
        continentRepository.save(continentModel);
    }

    public void deleteContinentById(Long id){
        continentRepository.deleteById(id);
    }
}
