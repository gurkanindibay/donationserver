package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Street extends ModifiableEntity {
    @Id
    @SequenceGenerator(name="street_gen", allocationSize=100, sequenceName = "street_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="street_gen")
    private Long id;
    private String name;
}
