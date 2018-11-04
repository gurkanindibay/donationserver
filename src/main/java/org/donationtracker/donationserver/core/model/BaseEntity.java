package org.donationtracker.donationserver.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.donationtracker.donationserver.security.enums.converter.BooleanToStringConverter;
import org.donationtracker.donationserver.security.enums.converter.UserOperationTypeConverter;
import org.hibernate.envers.Audited;
import org.springframework.util.ClassUtils;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "IS_DELETED", nullable = false)
    @Convert(converter = BooleanToStringConverter.class)
    @Audited
    private Boolean isDeleted = false;

    @Column(name = "DELETION_TOKEN", nullable = false)
    private String deletionToken = "-";

    public abstract Long getId();

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(ClassUtils.getUserClass(obj))) {
            return false;
        }

        BaseEntity that = (BaseEntity) obj;
        return null != this.getId() && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

}
