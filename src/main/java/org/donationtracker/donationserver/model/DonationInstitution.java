package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DonationInstitution {
    @SequenceGenerator(name="donation_institution_gen", allocationSize=100, sequenceName = "donation_institution_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="donation_institution_gen")
    @Id private Integer id;
    private String name;
}
