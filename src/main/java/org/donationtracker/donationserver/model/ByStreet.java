package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class ByStreet extends ModifiableEntity {
    @Id
    @SequenceGenerator(name = "bystreet_gen", allocationSize = 100, sequenceName = "bystreet_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bystreet_gen")
    private Long id;

    private String name;
}
