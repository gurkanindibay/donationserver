package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class District extends ModifiableEntity {
    @Id
    @SequenceGenerator(name="district_gen", allocationSize=100, sequenceName = "district_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="district_gen")
    private Long id;
    private String name;
}
