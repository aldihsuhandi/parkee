package id.parkee.test.common.model.request.ticket;

import id.parkee.test.common.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckOutRequest extends BaseRequest {
    private static final long serialVersionUID = 5578175197033192463L;

    private String ticketNumber;
}
