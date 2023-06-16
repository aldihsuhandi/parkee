package id.parkee.test.common.model.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum VehicleTypeEnum {
    MOTOR("MOTOR"),
    MOBIL("MOBIL"),
    ;

    VehicleTypeEnum(String type) {
        this.type = type;
    }

    private final String type;

    public static VehicleTypeEnum findByType(String type) {
        for (VehicleTypeEnum typeEnum : values()) {
            if (StringUtils.equals(typeEnum.getType(), type)) {
                return typeEnum;
            }
        }
        return null;
    }
}
