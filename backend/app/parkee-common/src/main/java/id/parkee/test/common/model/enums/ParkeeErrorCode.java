package id.parkee.test.common.model.enums;

import lombok.Getter;

@Getter
public enum ParkeeErrorCode {
    SYSTEM_ERROR("SYSTEM_ERROR", "internal system error"),
    PARAM_ILLEGAL("PARAM_ILLEGAL", "request parameter illegal"),

    SIMILAR_PLATE_FOUND("SIMILAR_PLATE_FOUND", "vehicle plate number already exist in our parking lot"),
    ;

    ParkeeErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private final String errorCode;
    private final String errorMessage;
}
