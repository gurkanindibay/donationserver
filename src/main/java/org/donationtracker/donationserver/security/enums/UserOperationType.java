package org.donationtracker.donationserver.security.enums;

import org.donationtracker.donationserver.core.enums.BaseEnum;
import org.donationtracker.donationserver.security.model.User;

public enum UserOperationType implements BaseEnum<Integer> {
    INSTANT_ON_OFF_DIMM(1), RESET_REQUEST(2), SET_CONFIGURATION_REQUEST(5), GET_CONFIGURATION_REQUEST(6),

    SAVE_USER(83, User.class, "SAVE"), DELETE_USER(84, User.class, "DELETE"), UPDATE_USER(85, User.class,
            "UPDATE"), ACTIVATE_USER(86, User.class, "ACTIVATE USER"), PASSIVATE_USER(87, User.class, "PASSIVATE USER"), //
    LOGIN_SUCCESS(90), LOGIN_FAILED(91), LOGOUT(92), //
    SAVE(200), DELETE(201), UPDATE(202);

    private final Integer value;

    private Class clazz;

    private String operation;

    UserOperationType(Integer value) {
        this.value = value;
    }

    UserOperationType(Integer value, Class clazz, String operation) {
        this.value = value;
        this.clazz = clazz;
        this.operation = operation;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public Class getClazz() {
        return clazz;
    }

    public String getOperation() {
        return operation;
    }

}
