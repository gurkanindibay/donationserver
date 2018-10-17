package org.donationtracker.donationserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Donee {
    @SequenceGenerator(name="donee_gen", allocationSize=100, sequenceName = "donee_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="donee_gen")
    @Id private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;

    @JoinColumn(name = "address_id", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Address activeAddress;

}
