package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Neighbourhood extends ModifiableEntity {
    @Id
    @SequenceGenerator(name = "neighbourhood_gen", allocationSize = 100, sequenceName = "neighbourhood_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "neighbourhood_gen")
    private Long id;

    private String name;
}
