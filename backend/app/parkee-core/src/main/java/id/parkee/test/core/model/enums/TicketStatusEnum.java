package id.parkee.test.core.model.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum TicketStatusEnum {
    CHECKED_IN("CHECKED_IN"),
    CHECKED_OUT("CHECKED_OUT");;

    TicketStatusEnum(String status) {
        this.status = status;
    }

    private final String status;

    public static TicketStatusEnum findByStatus(String status) {
        for (TicketStatusEnum statusEnum : values()) {
            if (StringUtils.equals(statusEnum.getStatus(), status)) {
                return statusEnum;
            }
        }
        return null;
    }
}
