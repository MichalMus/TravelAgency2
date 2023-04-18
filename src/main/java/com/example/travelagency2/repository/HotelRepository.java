package com.example.travelagency2.repository;

import com.example.travelagency2.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelModel, Long> {

    List<HotelModel> findAllByCityModel_CityName(String cityName);
}
