package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City extends ModifiableEntity{
    @Id
    @SequenceGenerator(name="city_gen", allocationSize=100, sequenceName = "city_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="city_gen")
    private Long id;
    private String name;
}
