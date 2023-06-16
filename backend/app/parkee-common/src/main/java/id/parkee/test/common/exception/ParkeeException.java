package id.parkee.test.common.exception;

import id.parkee.test.common.model.enums.ParkeeErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkeeException extends RuntimeException {
    private ParkeeErrorCode errorCode;

    public ParkeeException(Throwable cause, ParkeeErrorCode errorCode) {
        super(cause.getMessage(), cause);
        this.errorCode = errorCode;
    }

    public ParkeeException(String message, ParkeeErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
