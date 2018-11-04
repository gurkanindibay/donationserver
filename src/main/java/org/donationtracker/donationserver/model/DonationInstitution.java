package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class DonationInstitution extends ModifiableEntity {
    @SequenceGenerator(name = "donation_institution_gen", allocationSize = 100, sequenceName = "donation_institution_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donation_institution_gen")
    @Id
    private Long id;

    private String name;
}
