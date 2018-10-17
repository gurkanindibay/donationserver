package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Street {
    @Id
    @SequenceGenerator(name="street_gen", allocationSize=100, sequenceName = "street_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="street_gen")
    private Integer id;
    private String name;
}
