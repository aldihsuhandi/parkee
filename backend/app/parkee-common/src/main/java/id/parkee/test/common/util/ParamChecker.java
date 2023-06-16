package id.parkee.test.common.util;

import id.parkee.test.common.exception.ParkeeException;
import id.parkee.test.common.model.enums.ParkeeErrorCode;

import java.util.List;

public class ParamChecker {
    public static void isNotNull(Object value, String param, ParkeeErrorCode errorCode) throws ParkeeException {
        if (value == null) {
            throwsException(String.format("%s cannot be null", param), errorCode);
        }
    }

    public static void isNotEmpty(String value, String param, ParkeeErrorCode errorCode) throws ParkeeException {
        if (value == null || value.isEmpty()) {
            throwsException(String.format("%s cannot be empty", param), errorCode);
        }
    }

    public static <T> void isNotEmpty(List<T> value, String param, ParkeeErrorCode errorCode) throws ParkeeException {
        if (value == null || value.isEmpty()) {
            throwsException(String.format("%s cannot be empty", param), errorCode);
        }
    }

    public static void isExpected(boolean value, String param, ParkeeErrorCode errorCode) throws ParkeeException {
        if (!value) {
            throwsException(String.format("the value of %s is not expected", param), errorCode);
        }
    }

    public static void isExpected(String value, String comp, String param, ParkeeErrorCode errorCode) throws ParkeeException {
        if (!value.matches(comp)) {
            throwsException(String.format("the value of %s is not expected", param), errorCode);
        }
    }

    private static void throwsException(String msg, ParkeeErrorCode errorCode) throws ParkeeException {
        throw new ParkeeException(msg, errorCode);
    }
}
