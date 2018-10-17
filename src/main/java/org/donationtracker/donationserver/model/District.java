package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class District {
    @Id
    @SequenceGenerator(name="district_gen", allocationSize=100, sequenceName = "district_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="district_gen")
    private Integer id;
    private String name;
}
