package org.donationtracker.donationserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Donee extends ModifiableEntity {
    @SequenceGenerator(name="donee_gen", allocationSize=100, sequenceName = "donee_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="donee_gen")
    @Id private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;

    @JoinColumn(name = "address_id", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Address activeAddress;

}
