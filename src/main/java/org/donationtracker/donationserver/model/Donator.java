package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Donator extends ModifiableEntity {

    @SequenceGenerator(name = "donator_gen",  allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donator_gen")
    @Id private Long id;
    private String name;

}
