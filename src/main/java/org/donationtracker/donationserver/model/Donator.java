package org.donationtracker.donationserver.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Donator {
    @SequenceGenerator(name="donation_institution_seq")
    @Id private Integer id;
    private String name;

}
