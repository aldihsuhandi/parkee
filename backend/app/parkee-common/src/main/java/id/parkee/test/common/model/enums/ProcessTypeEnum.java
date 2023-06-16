package id.parkee.test.common.model.enums;

import lombok.Getter;

@Getter
public enum ProcessTypeEnum {
    CHECKED_IN("CHECKED_IN"),
    CHECKED_OUT("CHECKED_OUT"),
    TICKET_INFO("TICKET_INFO");

    ProcessTypeEnum(String code) {
        this.code = code;
    }

    private final String code;
}
