package com.example.travelagency2.repository;

import com.example.travelagency.model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Long> {


}
