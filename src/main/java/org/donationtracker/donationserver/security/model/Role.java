package org.donationtracker.donationserver.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.donationtracker.donationserver.core.model.ModifiableEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="SYS_ROLE")
public class Role extends ModifiableEntity {

	private static final long serialVersionUID = 8298645230374842036L;

	@Id
	@SequenceGenerator( name = "SEQ_SYS_ROLE_GEN", sequenceName = "SEQ_SYS_ROLE", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_SYS_ROLE_GEN" )
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 100)
	private String prettyName;
	
	@ManyToMany
    @JoinTable(name = "sys_role_authorities",
    joinColumns = {
                  @JoinColumn(name = "ROLE_ID", nullable = false)
                          },
    inverseJoinColumns = { 
                  @JoinColumn(name = "AUTHORITIES_ID",nullable = false)
                          })
    private List<Authority> authorities;


}