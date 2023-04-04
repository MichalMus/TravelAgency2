package com.example.travelagency2.repository;

import com.example.travelagency2.model.ContinentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<ContinentModel, Long> {
}
