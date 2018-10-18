package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ByStreet extends ModifiableEntity{
    @Id
    @SequenceGenerator(name="bystreet_gen", allocationSize=100, sequenceName = "bystreet_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="bystreet_gen")
    private Long id;
    private String name;
}
