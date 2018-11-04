package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Address extends ModifiableEntity {
    @Id
    @SequenceGenerator(name = "SEQ_Address_GEN", sequenceName = "SEQ_Address", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Address_GEN")
    private Long id;

    private String detail;

    @JoinColumn(name = "bystreet_id", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY)
    private ByStreet byStreet;

    @JoinColumn(name = "street_id", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Street street;

    @JoinColumn(name = "neighbourhood_id", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Neighbourhood neighbourhood;

    @JoinColumn(name = "district_id", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY)
    private District district;

    @JoinColumn(name = "city_id", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY)
    private City city;

    private boolean isActive = true;
}
