package org.donationtracker.donationserver.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.donationtracker.donationserver.core.model.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SYS_AUTHORITY")
public class Authority extends BaseEntity implements GrantedAuthority {

    private static final long serialVersionUID = 4811746059139780234L;

    @Id
    @SequenceGenerator(name = "SEQ_SYS_AUTHORITY_GEN", sequenceName = "SEQ_SYS_AUTHORITY", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SYS_AUTHORITY_GEN")
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private String prettyName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authorities")
    private List<Role> roles;

    @Override
    public String getAuthority() {
        return name;
    }

}
