package id.parkee.test.common.util;

import id.parkee.test.common.exception.ParkeeException;
import id.parkee.test.common.model.enums.ParkeeErrorCode;

public class AssertUtil {
    public static void isExpected(int value, int comp, ParkeeErrorCode errorCode) {
        if (value != comp) {
            throwError(errorCode.getErrorMessage(), errorCode);
        }
    }

    public static void isExpected(Object value, Object comp, String msg, ParkeeErrorCode errorCode) {
        if (!value.equals(comp)) {
            throwError(msg, errorCode);
        }
    }

    public static void isExpected(boolean val, String msg, ParkeeErrorCode errorCode) {
        if (!val) {
            throwError(msg, errorCode);
        }
    }

    public static void isNull(Object o, String msg, ParkeeErrorCode errorCode) {
        if (o != null) {
            throwError(msg, errorCode);
        }
    }

    public static void isNotNull(Object o, String msg, ParkeeErrorCode errorCode) {
        if (o == null) {
            throwError(msg, errorCode);
        }
    }

    private static void throwError(String msg, ParkeeErrorCode errorCode) {
        throw new ParkeeException(msg, errorCode);
    }
}
