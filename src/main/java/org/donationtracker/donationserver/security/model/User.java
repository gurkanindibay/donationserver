package org.donationtracker.donationserver.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.donationtracker.donationserver.core.model.ModifiableEntity;
import org.donationtracker.donationserver.model.enums.Language;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name = "SYS_USER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends ModifiableEntity implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQ_SYS_USER_GEN", sequenceName = "SEQ_SYS_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SYS_USER_GEN")
    private Long id;

    @Column
    private byte[] picture;

    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false, length = 100)
    private String fname;
    
    @Column(nullable = false, length = 100)
    private String sname;

    @Column(nullable = false, length = 100)
    private String username;

    @JsonIgnore
    @Column(nullable = false, length = 1000)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;
    
    @Column(nullable = false, length = 100)
    private String phone;

    @JsonIgnore
    @Column(nullable = false)
    private Boolean isAccountNonExpired = true;

    @JsonIgnore
    @Column(nullable = false)
    private Boolean isAccountNonLocked = true;

    @JsonIgnore
    @Column(nullable = false)
    private Boolean isCredentialsNonExpired = true;

    @Column(nullable = false)
    private Boolean isEnabled = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Column(nullable = false)
    private Integer failedLoginCount=0;

    @Column(nullable = false)
    private String token="-";

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;


    @Override
    public List<Authority> getAuthorities() {
        if(role == null || CollectionUtils.isEmpty(role.getAuthorities())) {
            return Collections.emptyList();
        } else {
            return role.getAuthorities();
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }



}