package com.example.travelagency2.repository;

import com.example.travelagency.model.PersonsIdModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsIdRepository extends JpaRepository<PersonsIdModel,Long> {
}
