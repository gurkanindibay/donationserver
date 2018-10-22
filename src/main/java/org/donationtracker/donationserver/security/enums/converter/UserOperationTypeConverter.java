package org.donationtracker.donationserver.security.enums.converter;

import org.donationtracker.donationserver.core.enums.BaseEnum;
import org.donationtracker.donationserver.security.enums.UserOperationType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserOperationTypeConverter implements AttributeConverter<UserOperationType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserOperationType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public UserOperationType convertToEntityAttribute(Integer dbValue) {
        return BaseEnum.fromValue(UserOperationType.class, dbValue);
    }
}
