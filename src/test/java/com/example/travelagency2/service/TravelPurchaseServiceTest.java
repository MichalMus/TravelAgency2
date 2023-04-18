package com.example.travelagency2.service;

import com.example.travelagency.model.TravelModel;
import com.example.travelagency.model.TravelPurchaseModel;
import com.example.travelagency.repository.TravelPurchaseRepository;
import com.example.travelagency.repository.TravelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TravelPurchaseServiceTest {

    @Autowired
    private TravelPurchaseService travelPurchaseService;
    @Autowired
    private TravelPurchaseRepository travelPurchaseRepository;
    @Autowired
    private TravelRepository travelRepository;

    @Test
    void getTravelPrice() {

        TravelModel travelModel = new TravelModel();
        travelModel.setAdultPrice(100);
        travelModel.setChildPrice(75);
        travelModel = travelRepository.save(travelModel);

        TravelPurchaseModel travelPurchaseModel = new TravelPurchaseModel();
        travelPurchaseModel.setAdultsNumber((byte) 3);
        travelPurchaseModel.setChildrenNumber((byte) 3);
        travelPurchaseModel.setTravelModel(travelModel);
        travelPurchaseModel = travelPurchaseRepository.save(travelPurchaseModel);

        double expected = 525;
        double result = travelPurchaseService.getTravelPrice(travelPurchaseModel.getId());

        Assertions.assertThat(result).isEqualTo(expected);

    }
}