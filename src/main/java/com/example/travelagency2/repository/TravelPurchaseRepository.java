package com.example.travelagency2.repository;

import com.example.travelagency2.model.TravelPurchaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPurchaseRepository extends JpaRepository<TravelPurchaseModel,Long> {
}
