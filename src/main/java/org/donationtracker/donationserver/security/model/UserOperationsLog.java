package org.donationtracker.donationserver.security.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.donationtracker.donationserver.core.model.BaseEntity;
import org.donationtracker.donationserver.security.enums.UserOperationType;
import org.donationtracker.donationserver.security.enums.converter.UserOperationTypeConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SYS_USER_OPERATIONS_LOG")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserOperationsLog extends BaseEntity {

    @Id
    @SequenceGenerator( name = "SEQ_USER_OP_LOG_GEN", sequenceName = "SEQ_USER_OP_LOG", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_OP_LOG_GEN" )
    private Long id;

    @Column(name = "OPERATION")
    @Convert(converter = UserOperationTypeConverter.class)
    private UserOperationType operation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private String description;

}
