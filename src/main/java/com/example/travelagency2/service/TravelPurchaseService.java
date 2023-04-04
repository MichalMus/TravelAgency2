package com.example.travelagency2.service;

import com.example.travelagency2.model.TravelPurchaseModel;
import com.example.travelagency2.repository.TravelPurchaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class TravelPurchaseService {

    private final TravelPurchaseRepository travelPurchaseRepository;

    public TravelPurchaseService(final TravelPurchaseRepository travelPurchaseRepository){
        this.travelPurchaseRepository=travelPurchaseRepository;
    }

    public List<TravelPurchaseModel> getAllTravelPurchaseModels(){
        return travelPurchaseRepository.findAll();
    }

    public void addNewTravelPurchaseModel(TravelPurchaseModel travelPurchaseModel){
        travelPurchaseRepository.save(travelPurchaseModel);
    }

    public void deleteTravelPurchaseModelById(Long id){
        travelPurchaseRepository.deleteById(id);
    }
}
