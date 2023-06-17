package id.parkee.test.core.validator.ticket;

import id.parkee.test.common.model.enums.ParkeeErrorCode;
import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.request.ticket.CheckOutRequest;
import id.parkee.test.common.util.ParamChecker;
import id.parkee.test.core.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class CheckOutRequestValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest baseRequest) {
        ParamChecker.isNotNull(baseRequest, "request", ParkeeErrorCode.PARAM_ILLEGAL);
        ParamChecker.isExpected(baseRequest instanceof CheckOutRequest, "request", ParkeeErrorCode.PARAM_ILLEGAL);

        CheckOutRequest request = (CheckOutRequest) baseRequest;
        ParamChecker.isNotEmpty(request.getTicketNumber(), "ticket number", ParkeeErrorCode.PARAM_ILLEGAL);
    }
}
