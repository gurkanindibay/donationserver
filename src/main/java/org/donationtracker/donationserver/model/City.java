package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class City extends ModifiableEntity {
    @Id
    @SequenceGenerator(name="city_gen", allocationSize=100, sequenceName = "city_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="city_gen")
    private Long id;
    private String name;
}
