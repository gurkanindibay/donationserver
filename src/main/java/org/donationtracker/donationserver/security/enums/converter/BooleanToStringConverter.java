package org.donationtracker.donationserver.security.enums.converter;

import org.donationtracker.donationserver.core.enums.BaseEnum;
import org.donationtracker.donationserver.security.enums.UserOperationType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return !attribute || attribute == null ? "N" : "Y";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbValue) {
        return dbValue != null && !dbValue.equals("N");
    }
}
