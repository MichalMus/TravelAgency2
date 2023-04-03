package com.example.travelagency2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
@Entity
public class TravelPurchaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //sprawdzić pole poniżej - czy musi być przy tej relacji również to samo odniesienie w drugiej klasie
    @OneToOne
    private TravelModel travelModel;

    @OneToMany
    @Column(name = "participants")
    private List<PersonsIdModel> personsIds;

    // nie wiem co z kwotą wymienioną w ostatnim punkcie



}
