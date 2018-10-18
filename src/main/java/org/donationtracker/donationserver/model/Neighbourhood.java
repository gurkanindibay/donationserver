package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Neighbourhood extends ModifiableEntity{
    @Id
    @SequenceGenerator(name="neighbourhood_gen", allocationSize=100, sequenceName = "neighbourhood_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="neighbourhood_gen")
    private Long id;
    private String name;
}
