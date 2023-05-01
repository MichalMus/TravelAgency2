package com.example.travelagency2.repository;

import com.example.travelagency2.model.PersonsIdModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonsIdRepository extends JpaRepository<PersonsIdModel,Long> {
    List<PersonsIdModel> findAllByPersonSurnameEqualsIgnoreCase(String surname);
}
