package org.donationtracker.donationserver.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="donee_seq", allocationSize=100)
public class Donee {
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="donee_seq")
    @Id private Integer id;
    private String name;
}
