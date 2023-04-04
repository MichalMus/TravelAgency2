package com.example.travelagency2.repository;

import com.example.travelagency2.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long> {
}
