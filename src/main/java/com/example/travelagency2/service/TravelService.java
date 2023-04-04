package com.example.travelagency2.service;

import com.example.travelagency2.model.TravelModel;
import com.example.travelagency2.model.Type;
import com.example.travelagency2.repository.TravelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class TravelService {
    private final TravelRepository travelRepository;

    public TravelService(final TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public List<TravelModel> findByPromotion() {
        List<TravelModel> allByPromotionIsTrue = travelRepository.findAllByPromotionIsTrue();
        return allByPromotionIsTrue;
    }

    public List<TravelModel> findByStartDateAfterNow() {
        Date aktualDate = new Date();
        return travelRepository.findAllByStartDateIsAfterOrderByStartDate(aktualDate);
    }

    public List<TravelModel> findByStartDateAfterNowOrderByContinent() {
        Date aktualDate = new Date();
        return travelRepository.findAllByStartDateIsAfterOrderByContinentModelId(aktualDate);
    }

    public List<TravelModel> findByStartDateAfterNowOrderByCountry() {
        Date aktualDate = new Date();
        return travelRepository.findAllByStartDateIsAfterOrderByCountryModelId(aktualDate);
    }

    public List<TravelModel> findTravelsByAirportName(String airportName) {
        return travelRepository.findAllByStart_AirPortName(airportName);
    }

    public List<TravelModel> findTravelsByHotelName(String hotelName) {
        return travelRepository.findAllByHotelModel_HotelName(hotelName);
    }

    public List<TravelModel> findTravelsByStartDate(Date date) {
        return travelRepository.findAllByStartDateIs(date);
    }

    public List<TravelModel> findTravelsByEndDate(Date date) {
        return travelRepository.findAllByEndDateIs(date);
    }

    public List<TravelModel> findTravelsByHotelType(Type type) {  //czy dobry typ przekazany do metody
        return travelRepository.findAllByHotelTypeIs(type);
    }

    public List<TravelModel> findTravelsByHotelStars(Byte hotelStars) {
        return travelRepository.findAllByHotelModel_StarsNumber(hotelStars);
    }

    public List<TravelModel> findTravelsByCountry(String name) {
        return travelRepository.findAllByCountryModel_CountryName(name);
    }


    //sprawdzić czy poprawić
    public Double getPrice(Long id){
        Optional<TravelModel> travelModel = travelRepository.findById(id);
        Byte AdultsNumber = travelModel.get().getAdultsNumber();
        Byte ChildrenNumber = travelModel.get().getChildrenNumber();
        Integer AdultPrice = travelModel.get().getAdultPrice();
        Integer ChildrenPrice = travelModel.get().getChildPrice();
        return (double) ((AdultsNumber * AdultPrice) + (ChildrenNumber * ChildrenPrice));

    }
    public List<TravelModel> findTravelsByStartDateIsNear(Date date1, Date date2) {
        return travelRepository.findAllByStartDateIsBetw(date1,date2);
    }

    public List<TravelModel> findTravelsByEndDateIsNear(Date date1, Date date2) {
        return travelRepository.findAllByEndDateIsBetw(date1,date2);
    }


}
