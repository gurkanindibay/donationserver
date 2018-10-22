package org.donationtracker.donationserver.core.enums;

public interface BaseEnum<VT> {

    VT getValue();


	static <T extends Enum<T>> T valueOf(String name, T defaultVal) {
        try {
            return Enum.valueOf(defaultVal.getDeclaringClass() , name);
        } catch (IllegalArgumentException | NullPointerException e) {
            return defaultVal;
        }
    }

    static <E extends BaseEnum, VT> E fromValue(Class<E> clazz, VT value) {
        if (value != null) {
            for (E en : clazz.getEnumConstants()) {
                if (value.equals(en.getValue())) {
                    return en;
                }
            }
        }
        return null;
    }
}
