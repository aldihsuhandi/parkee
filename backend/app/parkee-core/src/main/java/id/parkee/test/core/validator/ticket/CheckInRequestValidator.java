package id.parkee.test.core.validator.ticket;

import id.parkee.test.common.model.enums.ParkeeErrorCode;
import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.request.ticket.CheckInRequest;
import id.parkee.test.common.util.ParamChecker;
import id.parkee.test.core.validator.BaseValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CheckInRequestValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest baseRequest) {
        ParamChecker.isNotNull(baseRequest, "request", ParkeeErrorCode.PARAM_ILLEGAL);
        ParamChecker.isExpected(baseRequest instanceof CheckInRequest, "request", ParkeeErrorCode.PARAM_ILLEGAL);

        CheckInRequest request = (CheckInRequest) baseRequest;
        ParamChecker.isNotEmpty(request.getVehicleType(), "vehicle type", ParkeeErrorCode.PARAM_ILLEGAL);
        ParamChecker.isExpected(StringUtils.equals(request.getVehicleType(), "MOTOR") ||
                StringUtils.equals(request.getVehicleType(), "MOBIL"), "vehicle type", ParkeeErrorCode.PARAM_ILLEGAL);

        ParamChecker.isNotEmpty(request.getAreaCode(), "area code", ParkeeErrorCode.PARAM_ILLEGAL);

        ParamChecker.isNotEmpty(request.getPlateNumber(), "plate number", ParkeeErrorCode.PARAM_ILLEGAL);
        ParamChecker.isExpected(request.getPlateNumber().length() == 4, "plate number", ParkeeErrorCode.PARAM_ILLEGAL);
        ParamChecker.isExpected(request.getPlateNumber(), "-?\\d+(\\.\\d+)?", "plate number", ParkeeErrorCode.PARAM_ILLEGAL);

        ParamChecker.isNotEmpty(request.getPlateCode(), "plate code", ParkeeErrorCode.PARAM_ILLEGAL);
    }
}
