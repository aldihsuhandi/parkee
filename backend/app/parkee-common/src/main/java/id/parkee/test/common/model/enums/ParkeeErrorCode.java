package id.parkee.test.common.model.enums;

import lombok.Getter;

@Getter
public enum ParkeeErrorCode {
    SYSTEM_ERROR("SYSTEM_ERROR", "internal system error"),
    PARAM_ILLEGAL("PARAM_ILLEGAL", "request parameter illegal"),
    ;

    ParkeeErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private final String errorCode;
    private final String errorMessage;
}
