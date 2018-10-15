package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(name="donation_institution_seq", allocationSize=100)
public class DonationInstitution {
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="donation_institution_seq")
    @Id private Integer id;
    private String name;
}
