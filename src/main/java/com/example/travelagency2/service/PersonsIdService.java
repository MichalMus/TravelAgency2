package com.example.travelagency2.service;

import com.example.travelagency2.model.PersonsIdModel;
import com.example.travelagency2.repository.PersonsIdRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class PersonsIdService {
    private final PersonsIdRepository personsIdRepository;

    public PersonsIdService(final PersonsIdRepository personsIdRepository){
        this.personsIdRepository=personsIdRepository;
    }

    public List<PersonsIdModel> getAllPersonsIdList(){
        return personsIdRepository.findAll();
    }

    public void addNewPersonsId(PersonsIdModel personsIdModel){
        personsIdRepository.save(personsIdModel);
    }
    public void deletePersonsIdById(Long id){
        personsIdRepository.deleteById(id);
    }
    public Optional<PersonsIdModel> findPersonById(Long id){
        return personsIdRepository.findById(id);
    }
    public List<PersonsIdModel> findPersonsBySurname(String surname){
        return personsIdRepository.findAllByPersonSurnameEqualsIgnoreCase(surname);
    }
}
