package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Donator extends ModifiableEntity {

    @SequenceGenerator(name = "donator_gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donator_gen")
    @Id
    private Long id;

    private String name;

}
