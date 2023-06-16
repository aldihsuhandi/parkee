package id.parkee.test.common.model.request.ticket;

import id.parkee.test.common.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketInfoRequest extends BaseRequest {
    private static final long serialVersionUID = 1814859606325164330L;

    private String ticketNumber;
}
