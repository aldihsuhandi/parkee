package id.parkee.test.core.validator.ticket;

import id.parkee.test.common.model.enums.ParkeeErrorCode;
import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.request.ticket.TicketInfoRequest;
import id.parkee.test.common.util.ParamChecker;
import id.parkee.test.core.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class TicketInfoRequestValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest baseRequest) {
        ParamChecker.isNotNull(baseRequest, "request", ParkeeErrorCode.PARAM_ILLEGAL);
        ParamChecker.isExpected(baseRequest instanceof TicketInfoRequest, "request", ParkeeErrorCode.PARAM_ILLEGAL);

        TicketInfoRequest request = (TicketInfoRequest) baseRequest;
        ParamChecker.isNotEmpty(request.getTicketNumber(), "ticket number", ParkeeErrorCode.PARAM_ILLEGAL);
    }
}
