package com.example.travelagency2.controller;

import com.example.travelagency2.model.CityModel;
import com.example.travelagency2.repository.CityRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.web.servlet.function.ServerResponse.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class CityControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    CityRepository cityRepository;

    @Test
    @Transactional
    void getAllCities() {
    }

    @Test
    @Transactional
    void should_get_City_By_Id() throws Exception  {
        //given
        CityModel cityModelTest = new CityModel();
        cityModelTest.setCityName("MiastoTestowe");
        cityRepository.save(cityModelTest);
      //when
        List<CityModel> cityModelList = objectMapper.convertValue(cityRepository.findAll(), new TypeReference<List<CityModel>>() {
        });
        MvcResult mvcResult = mockMvc.perform(get("/city/id/"+(cityModelList.size()-1)))
                .andDo(print())
                .andReturn();
        //then
        CityModel cityModelResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), CityModel.class);
        assertThat(cityModelTest.getCityName()).isEqualTo("MiastoTestowe");
    }

    @Test
    @Transactional
    void addNewCity() {
    }

    @Test
    @Transactional
    void deleteCity() {
    }

    @Test
    @Transactional
    void postCityById() {
    }
}