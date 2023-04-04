package com.example.travelagency2.service;

import com.example.travelagency2.model.HotelModel;
import com.example.travelagency2.repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(final HotelRepository hotelRepository){
        this.hotelRepository=hotelRepository;
    }

    public List<HotelModel> getAllHotels(){
        return hotelRepository.findAll();
    }
    public void addNewHotel(HotelModel hotelModel){
        hotelRepository.save(hotelModel);
    }

    public void deleteHotelById(Long id){
        hotelRepository.deleteById(id);
    }
}
