package com.example.travelagency2.repository;

import com.example.travelagency2.model.TravelModel;
import com.example.travelagency2.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
public interface TravelRepository extends JpaRepository<TravelModel, Long> {

    List<TravelModel> findAllByPromotionIsTrue();

    List<TravelModel> findAllByStartDateIsAfterOrderByStartDate(Date date);

    List<TravelModel> findAllByStartDateIsAfterOrderByContinentModelId(Date date);

    List<TravelModel> findAllByStartDateIsAfterOrderByCountryModelId(Date date);
    List<TravelModel>findAllByCountryModel_CountryName(String name);

    @Modifying
    @Transactional
    @Query(value = "SELECT t FROM TravelModel t WHERE t.start = :airportStart")
    List<TravelModel> findByAirport(@Param("airportStart") Long id);

    List<TravelModel> findAllByStart_AirPortName(String nameAirport);

    List<TravelModel> findAllByHotelModel_HotelName(String nameHotel);

    List<TravelModel> findAllByStartDateIs(Date startDate); //sprawdzić czy to działa

    List<TravelModel> findAllByEndDateIs(Date endDate); //sprawdzić czy to działa

    List<TravelModel> findAllByHotelTypeIs(Type type); //jaki argument ma być przekazany do metody skoro to ENUM

    List<TravelModel>findAllByHotelModel_StarsNumber(Integer starsNumber);

    List<TravelModel>findAllByNumberOfDaysIs(Byte days); //sprawdzić bo jeszcze można coś dodać do nazwy metody

    @Modifying
    @Transactional
    @Query(value = "SELECT t FROM TravelModel t WHERE t.startDate > :startDate1 AND t.startDate < :startDate2", nativeQuery = false)
    List<TravelModel> findAllByStartDateIsBetw(@Param("startDate1") Date startDate1, @Param("startDate2") Date startDate2);

}
